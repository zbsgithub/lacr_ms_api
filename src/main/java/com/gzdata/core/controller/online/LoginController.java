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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.common.jwt.JwtUtil;
import com.gzdata.core.service.UserService;

@RestController
@Api(description="登录控制器")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
			
			
	@Autowired
	private UserService userService;
	
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
        }
        if (subject.isAuthenticated()) {
        	String sign = JwtUtil.sign(username, password);
            return Result.valueOf(Result.SUCCESS,"登录成功",sign);
        } else {
            token.clear();
            return Result.valueOf(Result.ERROR,"登录失败");
        }
    }
    
    @RequestMapping(value = "/notRole", method = RequestMethod.POST)
    @ResponseBody
    public Result notRole() {
    	
    	Subject subject = SecurityUtils.getSubject();//创建subject
    	subject.logout();
    	
    	return Result.valueOf(Result.ERROR,"无权限失败");
    }
    
    
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    @ResponseBody
//    public Result loginMethod() {
//    	
//    	
//    	return Result.valueOf(Result.SUCCESS,"操作成功");
//    }
}
