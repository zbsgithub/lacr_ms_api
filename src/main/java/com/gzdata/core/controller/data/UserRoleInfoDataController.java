package com.gzdata.core.controller.data;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.core.dto.UserRoleInfoDto;
import com.gzdata.core.model.UserRoleInfo;
import com.gzdata.core.qo.UserRoleInfoQo;
import com.gzdata.core.service.UserRoleInfoService;

/**
 * 
 * UserRoleInfo信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2019年07月23日
 */
//@Controller
public class UserRoleInfoDataController {

	@Autowired
	private  UserRoleInfoService userRoleInfoService;
	
	/**
	 * 
	 * 功能描述：列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月23日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/user/role/info/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody UserRoleInfoQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功", userRoleInfoService.findPaginationDataByCondition(qo));
	}
	
	/**
	 * 
	 * 功能描述：列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月23日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/user/role/info/list")
	@ResponseBody
	public Result list(@RequestBody UserRoleInfoQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功", userRoleInfoService.findList(qo));
	}

	

	/**
	 * 
	 * 功能描述：详情
	 *
	 * @param id
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2015年10月30日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/user/role/info/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功", userRoleInfoService.findById(id));
	}
	
	/**
	 * 
	 * 功能描述：批量删除
	 *
	 * @param id
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2015年10月30日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/user/role/info/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

	 	 userRoleInfoService.batchDelete(ids);
			

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：删除
	 *
	 * @param id
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2015年10月30日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/user/role/info/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		
			 			 userRoleInfoService.deleteByID(id);
			
		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：添加
	 *
	 * @param id
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2015年10月30日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/user/role/info/add")
	@ResponseBody
	 	 public Result add(@RequestBody UserRoleInfoDto dto) {
	
	
		 				UserRoleInfo userRoleInfo = new UserRoleInfo();
				BeanUtils.copyProperties(dto, userRoleInfo);
				userRoleInfoService.insert(userRoleInfo);
		
				

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：修改
	 *
	 * @param id
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2015年10月30日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/user/role/info/update")
	@ResponseBody
	 	 public Result edit(@RequestBody UserRoleInfoDto dto) {
		
	 				UserRoleInfo userRoleInfo = new UserRoleInfo();
				BeanUtils.copyProperties(dto, userRoleInfo);
				userRoleInfoService.updateSelective(userRoleInfo);
		
		
		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
