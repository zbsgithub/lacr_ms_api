package com.gzdata.core.controller.data;

import io.swagger.annotations.Api;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.common.db.mybatis.result.ResultPage;
import com.gzdata.core.dto.StdChannelsDto;
import com.gzdata.core.model.StdChannels;
import com.gzdata.core.qo.StdChannelsQo;
import com.gzdata.core.service.StdChannelsService;

/**
 * 
 * StdChannels信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2019年07月30日
 */
@RestController
@Api(description="标准频道-控制器")
public class StdChannelsDataController {

	@Autowired
	private StdChannelsService stdChannelsService;

	/**
	 * 
	 * 功能描述：列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月30日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@GetMapping("data/std/channels/pagelist")
	@ResponseBody
	public ResultPage pagelist(@ModelAttribute StdChannelsQo qo) {
		return ResultPage.valueOf(ResultPage.SUCCESS, "操作成功",stdChannelsService.findTotalCountByCondition(qo),
				stdChannelsService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月30日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@GetMapping("data/std/channels/list")
	@ResponseBody
	public Result list(@RequestBody StdChannelsQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				stdChannelsService.findList(qo));
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
	@GetMapping("data/std/channels/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				stdChannelsService.findById(id));
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
	@DeleteMapping("data/std/channels/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		stdChannelsService.batchDelete(ids);

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
	@DeleteMapping("data/std/channels/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		stdChannelsService.deleteByID(id);

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
	@PostMapping("data/std/channels/add")
	@ResponseBody
	public Result add(@RequestBody StdChannelsDto dto) {

		StdChannels stdChannels = new StdChannels();
		BeanUtils.copyProperties(dto, stdChannels);
		stdChannelsService.insert(stdChannels);

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
	@PutMapping("data/std/channels/update")
	@ResponseBody
	public Result edit(@RequestBody StdChannelsDto dto) {

		StdChannels stdChannels = new StdChannels();
		BeanUtils.copyProperties(dto, stdChannels);
		stdChannelsService.updateSelective(stdChannels);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
