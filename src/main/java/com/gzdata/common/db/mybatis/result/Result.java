package com.gzdata.common.db.mybatis.result;

public class Result {

	public final static char SUCCESS = '1';
	public final static char ERROR = '2';
	public final static String SUCCESS_STR = "success";
	public final static String ERROR_STR = "error";

	private String result;
	private String msg;
	private Object object;

	public static Result valueOf(char result) {
		switch (result) {
		case SUCCESS:
			return new Result(SUCCESS_STR);
		case ERROR:
			return new Result(ERROR_STR);
		default:
			return null;
		}
	}

	public static Result valueOf(char result, String msg) {
		Result r = Result.valueOf(result);
		if (r == null) {
			return null;
		}
		r.setMsg(msg);
		return r;
	}

	public static Result valueOf(char result, Object object) {
		Result r = Result.valueOf(result);
		if (r == null) {
			return null;
		}
		r.setObject(object);
		return r;
	}

	public static Result valueOf(char result, String msg, Object object) {
		Result r = Result.valueOf(result, msg);
		if (r == null) {
			return null;
		}
		r.setObject(object);
		return r;
	}

	Result(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}