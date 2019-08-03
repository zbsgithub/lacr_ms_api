package com.gzdata.common.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
/**
 * JWT工具类
 *
 * @author 张兵帅
 *
 * @version 
 *
 * @since 2018年5月25日
 */
public class JwtUtil {

	private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
			
    /**
     * 过期时间: 30分钟
     */
    private static final long EXPIRE_TIME = 30 * 60 * 1000;

    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return true 有效，反之无效
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            
            return true;
        } catch (Exception exception) {
        	System.out.println(exception.getMessage());
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            String userName = jwt.getClaim("username").asString();
            return userName;
        } catch (JWTDecodeException e) {
        	throw new RuntimeException("----------JWTDecodeException---------");
        }
    }

    /**
     * 生成签名,30min后过期
     *
     * @param username 用户名
     * @param secret   用户的密码
     * @return 加密的token
     */
    public static String sign(String username, String secret) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
		Algorithm algorithm = Algorithm.HMAC256(secret);
		
		// 附带username信息
		return JWT.create()
		        .withClaim("username", username)
		        .withExpiresAt(date)
		        .sign(algorithm);
    }
    
}