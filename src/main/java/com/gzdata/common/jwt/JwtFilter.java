package com.gzdata.common.jwt;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.gzdata.common.shiro.ShiroMd5Util;
import com.gzdata.core.dto.UserDto;
import com.gzdata.core.model.User;
import com.gzdata.core.service.UserService;

public class JwtFilter extends AuthenticatingFilter {
	
	
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);
			
    /**
     * 父类会在请求进入拦截器后调用该方法，返回true则继续，返回false则会调用onAccessDenied()。这里在不通过时，还调用了isPermissive()方法，我们后面解释。
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if(this.isLoginRequest(request, response))
            return true;
        boolean allowed = false;
        try {
            allowed = executeLogin(request, response);
        } catch(IllegalStateException e){ //not found any token
        	logger.info("Not found any token");
        }catch (Exception e) {
        	logger.info("Error occurs when login", e);
        }
        return allowed || super.isPermissive(mappedValue);
    }
    /**
     * 这里重写了父类的方法，使用我们自己定义的Token类，提交给shiro。这个方法返回null的话会直接抛出异常，进入isAccessAllowed（）的异常处理逻辑。
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) {
        String jwtToken = ((HttpServletRequest) servletRequest).getHeader("token");
        
        User user = userService.findByUserName(JwtUtil.getUsername(jwtToken));
        if(StringUtils.hasText(jwtToken)&&!JwtUtil.verify(jwtToken, JwtUtil.getUsername(jwtToken), user.getPassword())){
            logger.info("token已过期");
        	return new JwtToken(JwtUtil.sign(user.getUserName(), user.getPassword()));
        }

        return null;
    }
    /**
      * 如果这个Filter在之前isAccessAllowed（）方法中返回false,则会进入这个方法。我们这里直接返回错误的response
      */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletResponse httpResponse = WebUtils.toHttp(servletResponse);
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json;charset=UTF-8");
        httpResponse.setStatus(203);
//        fillCorsHeader(WebUtils.toHttp(servletRequest), httpResponse);
        return false;
    }
    /**
     *  如果Shiro Login认证成功，会进入该方法，等同于用户名密码登录成功，我们这里还判断了是否要刷新Token
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        String newToken = null;
        if(token instanceof JwtToken){
        	JwtToken jwtToken = (JwtToken)token;
            User user = (User) subject.getPrincipal();
            boolean shouldRefresh = JwtUtil.verify(jwtToken.getPrincipal().toString(), user.getUserName(), user.getPassword());
            if(!shouldRefresh) {
                newToken = JwtUtil.sign(user.getUserName(), ShiroMd5Util.MD5Pwd(user.getUserName(), user.getPassword()));
            }
        }
        if(StringUtils.hasText(newToken))
            httpResponse.setHeader("token", newToken);

        return true;
    }
    /**
      * 如果调用shiro的login认证失败，会回调这个方法，这里我们什么都不做，因为逻辑放到了onAccessDenied（）中。
      */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        logger.info("Validate token fail, token:{}, error:{}", token.toString(), e.getMessage());
        return false;
    }

}