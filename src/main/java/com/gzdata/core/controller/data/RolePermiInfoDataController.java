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
import com.gzdata.core.dto.RolePermiInfoDto;
import com.gzdata.core.model.RolePermiInfo;
import com.gzdata.core.qo.RolePermiInfoQo;
import com.gzdata.core.service.RolePermiInfoService;

/**
 * 
 * RolePermiInfo信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2019年07月23日
 */
//@Controller
public class RolePermiInfoDataController {

	@Autowired
	private  RolePermiInfoService rolePermiInfoService;
	
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
	@RequestMapping("data/role/permi/info/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody RolePermiInfoQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功", rolePermiInfoService.findPaginationDataByCondition(qo));
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
	@RequestMapping("data/role/permi/info/list")
	@ResponseBody
	public Result list(@RequestBody RolePermiInfoQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功", rolePermiInfoService.findList(qo));
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
	@RequestMapping("data/role/permi/info/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功", rolePermiInfoService.findById(id));
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
	@RequestMapping("data/role/permi/info/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

	 	 rolePermiInfoService.batchDelete(ids);
			

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
	@RequestMapping("data/role/permi/info/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		
			 			 rolePermiInfoService.deleteByID(id);
			
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
	@RequestMapping("data/role/permi/info/add")
	@ResponseBody
	 	 public Result add(@RequestBody RolePermiInfoDto dto) {
	
	
		 				RolePermiInfo rolePermiInfo = new RolePermiInfo();
				BeanUtils.copyProperties(dto, rolePermiInfo);
				rolePermiInfoService.insert(rolePermiInfo);
		
				

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
	@RequestMapping("data/role/permi/info/update")
	@ResponseBody
	 	 public Result edit(@RequestBody RolePermiInfoDto dto) {
		
	 				RolePermiInfo rolePermiInfo = new RolePermiInfo();
				BeanUtils.copyProperties(dto, rolePermiInfo);
				rolePermiInfoService.updateSelective(rolePermiInfo);
		
		
		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
