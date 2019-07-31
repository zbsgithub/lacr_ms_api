package com.gzdata.core.qo;

import com.gzdata.common.db.mybatis.page.Pagination;
import com.gzdata.core.model.RolePermiInfo;

public class RolePermiInfoQo extends Pagination<RolePermiInfo> {

	private Integer rolePermiId; //

	private Integer roleId; //

	private Integer permiId; //

	/** 以下为get,set方法 */

	public Integer getRolePermiId() {
		return this.rolePermiId;
	}

	public void setRolePermiId(Integer rolePermiId) {
		this.rolePermiId = rolePermiId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPermiId() {
		return this.permiId;
	}

	public void setPermiId(Integer permiId) {
		this.permiId = permiId;
	}

}