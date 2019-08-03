package com.gzdata.core.controller.data;

import io.swagger.annotations.Api;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.gzdata.core.dto.LogoCharactersDto;
import com.gzdata.core.model.LogoCharacters;
import com.gzdata.core.qo.LogoCharactersQo;
import com.gzdata.core.service.LogoCharactersService;

/**
 * 
 * LogoCharacters信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2019年07月30日
 */
@CrossOrigin
@RestController
@Api(description="模型-控制器")
public class LogoCharactersDataController {

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
	@GetMapping("data/logo/characters/pagelist")
	@ResponseBody
	public ResultPage pagelist(@ModelAttribute LogoCharactersQo qo) {

		return ResultPage.valueOf(ResultPage.SUCCESS, "操作成功",
				logoCharactersService.findTotalCountByCondition(qo),
				logoCharactersService.findPaginationDataByCondition(qo));
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
	@GetMapping("data/logo/characters/list")
	@ResponseBody
	public Result list(@ModelAttribute LogoCharactersQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				logoCharactersService.findList(qo));
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
	@GetMapping("data/logo/characters/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				logoCharactersService.findById(id));
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
	@DeleteMapping("data/logo/characters/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		logoCharactersService.batchDelete(ids);

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
	@DeleteMapping("data/logo/characters/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		logoCharactersService.deleteByID(id);

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
	@PostMapping("data/logo/characters/add")
	@ResponseBody
	public Result add(@RequestBody LogoCharactersDto dto) {

		LogoCharacters logoCharacters = new LogoCharacters();
		BeanUtils.copyProperties(dto, logoCharacters);
		logoCharactersService.insert(logoCharacters);

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
	@PutMapping("data/logo/characters/update")
	@ResponseBody
	public Result edit(@RequestBody LogoCharactersDto dto) {

		LogoCharacters logoCharacters = new LogoCharacters();
		BeanUtils.copyProperties(dto, logoCharacters);
		logoCharactersService.updateSelective(logoCharacters);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
