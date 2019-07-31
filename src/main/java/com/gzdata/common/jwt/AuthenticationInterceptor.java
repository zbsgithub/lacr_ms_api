package com.gzdata.common.jwt;


import com.gzdata.core.model.User;
import com.gzdata.core.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
 





import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
 
/**
 * 认证拦截器
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
	/**
	 * 日志
	 */
	private static Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);
	
 
    @Autowired
    protected UserService userService;
    
    //提供查询
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {}
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {}
    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
    	
    	String headerToken=arg0.getHeader("token");
    	
        //此处为不需要登录的接口放行
        if (arg0.getRequestURI().contains("/rpc") || arg0.getRequestURI().contains("/swagger-ui.html") || 
        		arg0.getRequestURI().contains("/webjars") ||
        		arg0.getRequestURI().contains("/v2") || arg0.getRequestURI().contains("/swagger-resources") || arg0.getRequestURI().contains("/login") || arg0.getRequestURI().contains("/register") || arg0.getRequestURI().contains("/error") || arg0.getRequestURI().contains("/static")) {
            return true;
        }
        
        //权限路径拦截
        arg1.setContentType("text/html;charset=utf-8");
        ServletOutputStream resultWriter = arg1.getOutputStream();
        
        //判断请求信息
        if(null==headerToken||headerToken.trim().equals("")){
        	throw new RuntimeException("token不能为空,请登录后获取");
        }
        //解析Token信息
        try {
        	String userName = JwtUtil.getUsername(headerToken);
            User user =  userService.findByUserName(userName);
 
            //数据库没有Token记录
            if(null==user) {
            	throw new RuntimeException("token无效,请登录后重新获取");
            }
            
            
            //判断Token过期
            boolean flag = JwtUtil.verify(headerToken, user.getUserName(), user.getRemark());//user.getPassword()"123456"
            
            if(flag){
            	logger.info("-----------token未过期-----");
            }else{
            	throw new RuntimeException("token已过期,请登录后重新获取");
            }
 
        } catch (Exception e) {
        	throw new RuntimeException("token不正确,请登录后重新获取");
        }
        //最后才放行
        return true;
    }
 
}
