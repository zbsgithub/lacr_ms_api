package com.gzdata.core.controller.online;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.common.jwt.JwtUtil;
import com.gzdata.common.shiro.ShiroMd5Util;
import com.gzdata.core.dto.UserDto;
import com.gzdata.core.model.User;
import com.gzdata.core.service.UserService;

/**
 * 登录控制器
 * 
 *
 * @author 张兵帅
 *
 * @version 
 *
 * @since 2019年7月31日
 */
@CrossOrigin
@RestController
@Api(description="登录控制器")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
			
			
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String defaultLogin() {
        return "首页";
    }

	@ApiOperation("登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestParam(value="username",required=false) String username, @RequestParam(value="password",required=false) String password) {
        
        Subject subject = SecurityUtils.getSubject();//创建subject
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);//生成token
        
        // 执行认证登陆
        try {
        	
            subject.login(token);
	        
        } catch (UnknownAccountException uae) {
            return Result.valueOf(Result.ERROR,"未知账户");
        } catch (IncorrectCredentialsException ice) {
            return Result.valueOf(Result.ERROR,"密码不正确");
        } catch (LockedAccountException lae) {
            return Result.valueOf(Result.ERROR,"账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            return Result.valueOf(Result.ERROR,"用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
        	return Result.valueOf(Result.ERROR,"用户名或密码不正确！");
        }catch (Exception e){
//        	 token.clear();
             return Result.valueOf(Result.ERROR,"登录失败");
        }
        
        if (subject.isAuthenticated()) {
        	//Shiro认证通过后会将user信息放到subject内，生成token并返回
//            User user = (User) subject.getPrincipal();
	        String sign = JwtUtil.sign(username, ShiroMd5Util.MD5Pwd(username, password));
	        
	        return Result.valueOf(Result.SUCCESS,"登录成功",sign);
        } else {
            token.clear();
            return Result.valueOf(Result.ERROR,"登录失败");
        }
       
    }
    
    @RequestMapping(value = "/notRole", method = RequestMethod.POST)
    @ResponseBody
    public Result notRole() {
    	
    	SecurityUtils.getSubject().logout();//创建subject
    	logger.info("注销当前用户");
    	
    	return Result.valueOf(Result.ERROR,"无权限失败");
    }
    
}
