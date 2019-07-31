package com.gzdata.common.db.mybatis.result;

public class ResultPage{

	private int code;

	private String msg;

	private int count;

	private Object data;
	
	public final static int SUCCESS = 1;
	public final static int ERROR = 0;
	public final static String SUCCESS_STR = "success";
	public final static String ERROR_STR = "error";
	
	public ResultPage( int code, String msg) {
		this.msg=msg;
		this.code=code;
	}

	public static ResultPage valueOf(int code) {
		
		switch (code) {
		case SUCCESS:
			return new ResultPage(code,SUCCESS_STR);
		case ERROR:
			return new ResultPage(code,ERROR_STR);
		default:
			return null;
		}
	}

	public static ResultPage valueOf(int code, String msg) {
		ResultPage r = ResultPage.valueOf(code);
		if (r == null) {
			return null;
		}
		r.setMsg(msg);
		return r;
	}

	public static ResultPage valueOf(int code, Object data) {
		ResultPage r = ResultPage.valueOf(code);
		if (r == null) {
			return null;
		}
		r.setData(data);
		return r;
	}

	public static ResultPage valueOf(int code, String msg, Object data) {
		ResultPage r = ResultPage.valueOf(code, msg);
		if (r == null) {
			return null;
		}
		r.setData(data);
		return r;
	}
	public static ResultPage valueOf(int code, String msg, int count,Object data) {
		ResultPage r = ResultPage.valueOf(code, msg,data);
		if (r == null) {
			return null;
		}
//		r.setData(data);
		r.setCount(count);
		return r;
	}


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultNew [code=" + code + ", msg=" + msg + ", count=" + count
				+ ", data=" + data + "]";
	}
	
	
	

}
