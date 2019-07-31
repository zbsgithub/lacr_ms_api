package com.gzdata.core.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gzdata.common.util.DateUtil;

/**
 * 
 * 说明： 值对象类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2019年07月17日
 */
public class User {

	private Integer id; // 主键

	private String userName; //

	private String password; //

	private String eableState; // 启用状态：启用、停用、注销

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT)
	private Date createTime; // 创建时间

	private String remark;

	/** 以下为get,set方法 */

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEableState() {
		return this.eableState;
	}

	public void setEableState(String eableState) {
		this.eableState = eableState;
	}

	@JsonFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
