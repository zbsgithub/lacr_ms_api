package com.gzdata.common.jwt;

import org.apache.shiro.authc.AuthenticationToken;


public class JwtToken implements AuthenticationToken {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private String token;

	public JwtToken(String token) {
		this.token = token;
	}

	@Override
	public Object getPrincipal() {
		return token;
	}

	@Override
	public Object getCredentials() {
		return token;
	}
}
