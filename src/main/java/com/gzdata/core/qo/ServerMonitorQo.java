package com.gzdata.core.qo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gzdata.common.db.mybatis.page.Pagination;
import com.gzdata.common.util.DateUtil;
import com.gzdata.core.model.ServerMonitor;

public class ServerMonitorQo extends Pagination<ServerMonitor> {

	private Integer id; // 主键

	private String host; //

	private String cpu; //

	private String mem; //

	private String disk; //

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT)
	private Date monitorTime; //

	private String remark; //

	/** 以下为get,set方法 */

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getCpu() {
		return this.cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getMem() {
		return this.mem;
	}

	public void setMem(String mem) {
		this.mem = mem;
	}

	public String getDisk() {
		return this.disk;
	}

	public void setDisk(String disk) {
		this.disk = disk;
	}

	@JsonFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
	public Date getMonitorTime() {
		return this.monitorTime;
	}

	public void setMonitorTime(Date monitorTime) {
		this.monitorTime = monitorTime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}