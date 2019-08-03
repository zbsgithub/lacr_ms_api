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
import com.gzdata.core.dto.RoleDto;
import com.gzdata.core.model.Role;
import com.gzdata.core.qo.RoleQo;
import com.gzdata.core.service.RoleService;

/**
 * 
 * Role信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2019年07月23日
 */
@CrossOrigin
@RestController
@Api(description="角色管理-控制器")
public class RoleDataController {

	@Autowired
	private RoleService roleService;

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
	 * @RequestMapping("data/role/pagelist")
	 * 
	 * @ResponseBody public Result pagelist(@RequestBody RoleQo qo) { return
	 * Result.valueOf(Result.SUCCESS, "操作成功",
	 * roleService.findPaginationDataByCondition(qo)); }
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
	@GetMapping("data/role/list")
	@ResponseBody
	@ApiOperation("获取角色列表")
	public Result list(@RequestBody RoleQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功", roleService.findList(qo));
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
	@GetMapping("data/role/detail")
	@ResponseBody
	@ApiOperation("获取角色详情")
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功", roleService.findById(id));
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
	 * @RequestMapping("data/role/batch_delete")
	 * 
	 * @ResponseBody public Result batchDelete(@RequestParam Serializable...
	 * ids) {
	 * 
	 * roleService.batchDelete(ids);
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
	@DeleteMapping("data/role/delete")
	@ResponseBody
	@ApiOperation("删除角色")
	public Result delete(@RequestParam String id) {

		roleService.deleteByID(id);

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
	@PostMapping("data/role/add")
	@ResponseBody
	@ApiOperation("添加")
	public Result add(@ModelAttribute RoleDto dto) {

		Role role = new Role();
		BeanUtils.copyProperties(dto, role);
		roleService.insert(role);

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
	@PutMapping("data/role/update")
	@ResponseBody
	@ApiOperation("更新用户角色")
	public Result edit(@ModelAttribute RoleDto dto) {

		if(dto.getId()!=null ){
			Role role = roleService.findById(dto.getId());
			BeanUtils.copyProperties(dto, role,"id");
			roleService.updateSelective(role);
		}
		

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
