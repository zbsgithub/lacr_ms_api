package com.gzdata.core.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gzdata.common.util.DateUtil;

/**
 * 
 * 
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2019年07月24日
 */
public class SlaveMonitorDto {

	private Integer id; // 主键

	private String slaveName; //

	private String programName; //

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT)
	private Date monitorTime; //

	private String runState; //

	private String remark; //

	/** 以下为get,set方法 */

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSlaveName() {
		return this.slaveName;
	}

	public void setSlaveName(String slaveName) {
		this.slaveName = slaveName;
	}

	public String getProgramName() {
		return this.programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	@JsonFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
	public Date getMonitorTime() {
		return this.monitorTime;
	}

	public void setMonitorTime(Date monitorTime) {
		this.monitorTime = monitorTime;
	}

	public String getRunState() {
		return this.runState;
	}

	public void setRunState(String runState) {
		this.runState = runState;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
