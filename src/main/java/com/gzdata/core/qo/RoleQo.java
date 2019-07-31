package com.gzdata.core.qo;

import com.gzdata.common.db.mybatis.page.Pagination;
import com.gzdata.core.model.Role;

public class RoleQo extends Pagination<Role> {

	private Integer id; // 主键

	private String roleName; // 角色名称

	/** 以下为get,set方法 */

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}