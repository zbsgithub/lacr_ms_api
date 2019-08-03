package com.gzdata.core.controller.data;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.core.dto.PermissionDto;
import com.gzdata.core.model.Permission;
import com.gzdata.core.qo.PermissionQo;
import com.gzdata.core.service.PermissionService;

/**
 * 
 * Permission信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2019年07月23日
 */
@CrossOrigin
@RestController
@Api(description="权限-控制器")
public class PermissionDataController {

	@Autowired
	private PermissionService permissionService;

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
	/*
	 * @RequestMapping("data/permission/pagelist")
	 * 
	 * @ResponseBody public Result pagelist(@RequestBody PermissionQo qo) {
	 * return Result.valueOf(Result.SUCCESS, "操作成功",
	 * permissionService.findPaginationDataByCondition(qo)); }
	 */

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
	@GetMapping("data/permission/list")
	@ResponseBody
	@ApiOperation("权限列表")
	public Result list(@RequestBody PermissionQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				permissionService.findList(qo));
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
	@GetMapping("data/permission/detail")
	@ResponseBody
	@ApiOperation("获取权限详情")
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				permissionService.findById(id));
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
	/*
	 * @RequestMapping("data/permission/batch_delete")
	 * 
	 * @ResponseBody public Result batchDelete(@RequestParam Serializable...
	 * ids) {
	 * 
	 * permissionService.batchDelete(ids);
	 * 
	 * 
	 * return Result.valueOf(Result.SUCCESS, "操作成功"); }
	 */

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
	@DeleteMapping("data/permission/delete")
	@ResponseBody
	@ApiOperation("删除")
	public Result delete(@RequestParam String id) {

		permissionService.deleteByID(id);

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
	@PostMapping("data/permission/add")
	@ResponseBody
	@ApiOperation("添加-权限")
	public Result add(@ModelAttribute PermissionDto dto) {

		Permission permission = new Permission();
		BeanUtils.copyProperties(dto, permission);
		permissionService.insert(permission);

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
	@PutMapping("data/permission/update")
	@ResponseBody
	@ApiOperation("修改-权限")
	public Result edit(@ModelAttribute PermissionDto dto) {

		if(dto.getId()!=null){
			Permission permission = permissionService.findById(dto.getId());
			BeanUtils.copyProperties(dto, permission,"id");
			permissionService.updateSelective(permission);
		}

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
