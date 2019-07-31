package com.gzdata.core.qo;

import com.gzdata.common.db.mybatis.page.Pagination;
import com.gzdata.core.model.UserRoleInfo;

public class UserRoleInfoQo extends Pagination<UserRoleInfo> {

	private Integer userRoleId; // 主键

	private Integer userId; //

	private Integer roleId; //

	/** 以下为get,set方法 */

	public Integer getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}