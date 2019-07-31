package com.gzdata.common.compoent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 登陆 控制拦截器
 * 
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private HttpSession session;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 如果用户没有登陆 返回false
		if (session.getAttribute("user") == null) {

			response.sendRedirect(request.getContextPath() + "/page/pub/logout");
			// 没有登陆
			return false;
		}
		return true;
	}
}
