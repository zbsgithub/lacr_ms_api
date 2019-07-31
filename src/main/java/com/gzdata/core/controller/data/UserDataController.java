package com.gzdata.core.controller.data;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.core.dto.UserDto;
import com.gzdata.core.model.User;
import com.gzdata.core.qo.UserQo;
import com.gzdata.core.service.UserService;

/**
 * 
 * User信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2019年07月17日
 */
@RestController
@Api(description="用户管理-控制器")
@ApiModel()
public class UserDataController {

	@Autowired
	private UserService userService;

	/**
	 * 
	 * 功能描述：列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月17日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	/*@RequestMapping("data/user/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody UserQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				userService.findPaginationDataByCondition(qo));
	}*/

	/**
	 * 
	 * 功能描述：列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月17日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@GetMapping("data/user/list")
	@ResponseBody
	@ApiOperation("列表--通过条件查询")
	public Result list(@ModelAttribute UserQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功", userService.findList(qo));
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
	@ApiOperation("详情")
	@GetMapping("data/user/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功", userService.findById(id));
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
	/*@RequestMapping("data/user/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		userService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}*/

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
	@DeleteMapping("data/user/delete")
	@ResponseBody
	@ApiOperation("删除")
	public Result delete(@RequestParam String id) {

		userService.deleteByID(id);

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
	@PostMapping("data/user/add")
	@ResponseBody
	@ApiOperation("添加")
	public Result add(@ModelAttribute UserDto dto) {

		User user = new User();
		BeanUtils.copyProperties(dto, user);
		userService.insert(user);

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
	@PutMapping("data/user/update")
	@ResponseBody
	@ApiOperation("修改")
	public Result edit(@ModelAttribute UserDto dto) {

		if(dto.getId() !=null){
			User user = userService.findById(dto.getId());
			
			BeanUtils.copyProperties(dto, user,"id");
			userService.updateSelective(user);
		}

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
