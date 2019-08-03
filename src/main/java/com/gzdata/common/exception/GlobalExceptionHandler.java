package com.gzdata.common.exception;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.gzdata.common.db.mybatis.result.Result;

/**
 * 全局异常处理信息
 * 
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2019年7月23日
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static Logger logger = LoggerFactory
			.getLogger(GlobalExceptionHandler.class);

	/**
	 * 处理运行时异常
	 * 
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Result doHandleRuntimeException(RuntimeException e) {

		return Result.valueOf(Result.ERROR, e.getMessage());
	}

	/**
	 * 
	 * 功能描述：处理shiro相关异常
	 *
	 * @param e
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年7月23日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@ExceptionHandler(ShiroException.class)
	@ResponseBody
	public Result doHandleShiroException(ShiroException e) {

		String msg = "";

		if (e instanceof IncorrectCredentialsException) {
			msg = "密码不正确";
		} else if (e instanceof UnknownAccountException) {
			msg = "此账户不存在";
		} else if (e instanceof LockedAccountException) {
			msg = "账户已被禁用";
		} else if (e instanceof UnauthenticatedException) {
			msg = "未认证";
		} else if (e instanceof UnauthorizedException) {
			msg = "未授权";
		} else {
			msg = "shiro未知异常";
		}

		return Result.valueOf(Result.ERROR, msg);

	}

	/**
	 * 
	 * 功能描述：处理非法访问相关异常
	 *
	 * @param e
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年7月23日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseBody
	public Result doHandleNotSupportedException(
			HttpRequestMethodNotSupportedException e) {

		String msg = "";

		if (e instanceof HttpRequestMethodNotSupportedException) {
			msg = "token不正确，请检查token有效性";
		}

		return Result.valueOf(Result.ERROR, msg);

	}
}
