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
import com.gzdata.core.dto.LogReportMonitorDto;
import com.gzdata.core.model.LogReportMonitor;
import com.gzdata.core.qo.LogReportMonitorQo;
import com.gzdata.core.service.LogReportMonitorService;

/**
 * 
 * LogReportMonitor信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2019年07月23日
 */
//@Controller
public class LogReportMonitorDataController {

	@Autowired
	private  LogReportMonitorService logReportMonitorService;
	
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
	@RequestMapping("data/log/report/monitor/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody LogReportMonitorQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功", logReportMonitorService.findPaginationDataByCondition(qo));
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
	@RequestMapping("data/log/report/monitor/list")
	@ResponseBody
	public Result list(@RequestBody LogReportMonitorQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功", logReportMonitorService.findList(qo));
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
	@RequestMapping("data/log/report/monitor/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功", logReportMonitorService.findById(id));
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
	@RequestMapping("data/log/report/monitor/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

	 	 logReportMonitorService.batchDelete(ids);
			

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
	@RequestMapping("data/log/report/monitor/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		
			 			 logReportMonitorService.deleteByID(id);
			
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
	@RequestMapping("data/log/report/monitor/add")
	@ResponseBody
	 	 public Result add(@RequestBody LogReportMonitorDto dto) {
	
	
		 				LogReportMonitor logReportMonitor = new LogReportMonitor();
				BeanUtils.copyProperties(dto, logReportMonitor);
				logReportMonitorService.insert(logReportMonitor);
		
				

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
	@RequestMapping("data/log/report/monitor/update")
	@ResponseBody
	 	 public Result edit(@RequestBody LogReportMonitorDto dto) {
		
	 				LogReportMonitor logReportMonitor = new LogReportMonitor();
				BeanUtils.copyProperties(dto, logReportMonitor);
				logReportMonitorService.updateSelective(logReportMonitor);
		
		
		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
