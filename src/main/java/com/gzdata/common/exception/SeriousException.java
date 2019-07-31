package com.gzdata.common.exception;

/**
 * 【严重异常】 抛出此异常，给出提示信息,并要求在调用出处理
 * 
 */
public class SeriousException extends Exception {

	private static final long serialVersionUID = -8233749574972852877L;

	/*
	 * 提示信息
	 */
	public SeriousException(String message) {
		super(message);
	}

	/*
	 * 指定异常及该异常的（提示信息）
	 */
	public SeriousException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
