package com.gzdata.core.qo;

import com.gzdata.common.db.mybatis.page.Pagination;
import com.gzdata.core.model.Permission;

public class PermissionQo extends Pagination<Permission> {

	private Integer id; // 主键

	private String permissionName; //

	/** 以下为get,set方法 */

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPermissionName() {
		return this.permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

}