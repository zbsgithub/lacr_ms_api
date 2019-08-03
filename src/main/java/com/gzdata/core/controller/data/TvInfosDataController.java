package com.gzdata.core.controller.data;

import io.swagger.annotations.Api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.common.db.mybatis.result.ResultPage;
import com.gzdata.core.dto.TvInfosDto;
import com.gzdata.core.model.LogoCharacters;
import com.gzdata.core.model.TvInfos;
import com.gzdata.core.qo.LogoCharactersQo;
import com.gzdata.core.qo.TvInfosQo;
import com.gzdata.core.service.LogoCharactersService;
import com.gzdata.core.service.TvInfosService;

/**
 * 
 * TvInfos信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2019年07月30日
 */
@CrossOrigin
@RestController
@Api(description="设备列表-控制器")
public class TvInfosDataController {

	@Autowired
	private TvInfosService tvInfosService;
	@Autowired
	private LogoCharactersService logoCharactersService;

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
	@GetMapping("data/tv/infos/pagelist")
	@ResponseBody
	public ResultPage pagelist(@ModelAttribute TvInfosQo qo) {
		
		List<Map<String, Object>> mapList=new ArrayList<Map<String, Object>>();
		
		
		List<TvInfos> tiList = tvInfosService.findPaginationDataByCondition(qo);
		
		for (TvInfos tvInfos : tiList) {//each data list
			Map<String, Object> map= new HashMap<>();
			
			
			LogoCharactersQo logoQo = new LogoCharactersQo();
			logoQo.setChecked(1);
			logoQo.setTvInfoId(tvInfos.getId());
			List<LogoCharacters> logoList = logoCharactersService.findList(logoQo);
			map.put("machine", tvInfos.getMachine());
			map.put("checkedNum", logoList.size());
			mapList.add(map);
		}
		
		return ResultPage.valueOf(ResultPage.SUCCESS, "操作成功",tvInfosService.findTotalCountByCondition(qo),mapList);
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
	/*@RequestMapping("data/tv/infos/list")
	@ResponseBody
	public Result list(@RequestBody TvInfosQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				tvInfosService.findList(qo));
	}

	*//**
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
	 *//*
	@RequestMapping("data/tv/infos/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				tvInfosService.findById(id));
	}

	*//**
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
	 *//*
	@RequestMapping("data/tv/infos/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		tvInfosService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	*//**
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
	 *//*
	@RequestMapping("data/tv/infos/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		tvInfosService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	*//**
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
	 *//*
	@RequestMapping("data/tv/infos/add")
	@ResponseBody
	public Result add(@RequestBody TvInfosDto dto) {

		TvInfos tvInfos = new TvInfos();
		BeanUtils.copyProperties(dto, tvInfos);
		tvInfosService.insert(tvInfos);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	*//**
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
	 *//*
	@RequestMapping("data/tv/infos/update")
	@ResponseBody
	public Result edit(@RequestBody TvInfosDto dto) {

		TvInfos tvInfos = new TvInfos();
		BeanUtils.copyProperties(dto, tvInfos);
		tvInfosService.updateSelective(tvInfos);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}*/

}
