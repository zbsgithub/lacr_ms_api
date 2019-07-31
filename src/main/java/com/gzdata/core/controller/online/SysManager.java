package com.gzdata.core.controller.online;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.core.qo.UserQo;
import com.gzdata.core.service.UserService;

//@Api("系统管理-控制器")
//@RestController
public class SysManager {
	@Autowired
	private UserService userService;

	private Logger logger = LoggerFactory.getLogger(MonitorManager.class);
	
	
	
	/**
	 * 主要：
	 * 1.用户管理
	 * 
	 * 2.角色管理
	 * 
	 * 3.权限管理
	 */
	
	/**
	 * 
	 * 功能描述：用户列表数据
	 *
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年7月23日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/user/userList")
	@ResponseBody
	public Result pagelist() {
		return Result.valueOf(Result.SUCCESS, "操作成功", userService.findAll());
	}
	
	
	@RequestMapping("/ss/")
	@ResponseBody
	@ApiOperation("xxxx")
	public Result example(){
		
		return Result.valueOf(Result.SUCCESS,"操作成功");
	}
}
