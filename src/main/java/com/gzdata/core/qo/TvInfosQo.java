package com.gzdata.core.qo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gzdata.common.db.mybatis.page.Pagination;
import com.gzdata.common.util.DateUtil;
import com.gzdata.core.model.TvInfos;

public class TvInfosQo extends Pagination<TvInfos> {

	private Integer id; //

	private String on; //

	private String dn; //

	private String dm; //

	private String did; //

	private String gzid; //

	private String area; //

	private String machine; //

	private Integer packed; //

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT)
	private Date packedAt; //

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT)
	private Date createdAt; //

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT)
	private Date updatedAt; //

	/** 以下为get,set方法 */

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOn() {
		return this.on;
	}

	public void setOn(String on) {
		this.on = on;
	}

	public String getDn() {
		return this.dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}

	public String getDm() {
		return this.dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	public String getDid() {
		return this.did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getGzid() {
		return this.gzid;
	}

	public void setGzid(String gzid) {
		this.gzid = gzid;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getMachine() {
		return this.machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public Integer getPacked() {
		return this.packed;
	}

	public void setPacked(Integer packed) {
		this.packed = packed;
	}

	@JsonFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
	public Date getPackedAt() {
		return this.packedAt;
	}

	public void setPackedAt(Date packedAt) {
		this.packedAt = packedAt;
	}

	@JsonFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@JsonFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}