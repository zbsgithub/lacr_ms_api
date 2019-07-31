package com.gzdata.common.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.gzdata.core.model.User;
import com.gzdata.core.service.UserService;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述：
 *
 * @author caojing
 * @create 2019-01-27-13:57
 */
public class AuthorizationInfoRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;

	/**
	 * 权限认证
	 */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> stringSet = new HashSet<>();
//        stringSet.add("user:show");
//        stringSet.add("user:ddd");
        info.setStringPermissions(stringSet);
        return info;
    }

    /**
     * 身份认证
     * 获取即将需要认证的信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    	System.out.println("-------身份认证方法--------");
        
    	String userName = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());
        
        System.out.println("token解析的："+ShiroMd5Util.MD5Pwd(userName,userPwd));
        
        User user = userService.findByUserName(userName);
        if (userName == null) {
            throw new AccountException("用户名不正确");
        } else if (!ShiroMd5Util.MD5Pwd(userName,userPwd).equals(user.getPassword())) {
            throw new AccountException("密码不正确");
        }
       
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        return new SimpleAuthenticationInfo(userName, user.getPassword(),
                ByteSource.Util.bytes(userName + "salt"), getName());
    }
    
}