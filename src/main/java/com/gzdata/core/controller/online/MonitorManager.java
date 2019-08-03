package com.gzdata.core.controller.online;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.core.model.LogReportMonitor;
import com.gzdata.core.model.ServerMonitor;
import com.gzdata.core.model.SlaveMonitor;
import com.gzdata.core.service.LogReportMonitorService;
import com.gzdata.core.service.ServerMonitorService;
import com.gzdata.core.service.SlaveMonitorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 概要:
 * 
 * 1.日志上报监控
 * 2.server监控
 * 3.slave监控
 *
 *
 * @author 张兵帅
 *
 * @version 
 *
 * @since 2019年7月24日
 */
@CrossOrigin
@Api(description="监控管理-控制器")
@RestController
public class MonitorManager {
	
	private Logger logger = LoggerFactory.getLogger(MonitorManager.class);

	@Autowired
	private SlaveMonitorService slaveMonitorService;
	@Autowired
	private ServerMonitorService serverMonitorService;
	@Autowired
	private LogReportMonitorService logReportMonitorService;
	
	
	
	
	/**
	 * 
	 * 功能描述：日志上报监控
	 *
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年7月24日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@GetMapping("/anon/log/report/monitor")
	@ResponseBody
	@ApiOperation("日志上报监控")
	public Result logRepotMonitorInfo(){
		
		List<LogReportMonitor> lrmList = logReportMonitorService.findAll();
		if(lrmList!=null && !lrmList.isEmpty()){
			
			return Result.valueOf(Result.SUCCESS,"操作成功",lrmList);
		}else{
			return Result.valueOf(Result.ERROR,"操作失败：暂无数据");
		}
		
	}
	
	/**
	 * 
	 * 功能描述：server监控
	 *
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年7月24日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@GetMapping("/anon/server/monitor")
	@ResponseBody
	@ApiOperation("server监控")
	public Result serverMonitorInfo(){
		
		List<ServerMonitor> smList = serverMonitorService.findAll();
		if(smList!=null && !smList.isEmpty()){
			
			return Result.valueOf(Result.SUCCESS,"操作成功",smList);
		}else{
			return Result.valueOf(Result.ERROR,"操作失败：暂无数据");
		}
		
	}
	
	
	/**
	 * 
	 * 功能描述：slave监控
	 *
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年7月24日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@GetMapping("/anon/slave/monitor")
	@ResponseBody
	@ApiOperation("slave监控")
	public Result slaveMonitorInfo(){
		
		List<SlaveMonitor> slaveMonitorsList = slaveMonitorService.findAll();
		if(slaveMonitorsList!=null && !slaveMonitorsList.isEmpty()){
			
			return Result.valueOf(Result.SUCCESS,"操作成功",slaveMonitorsList);
		}else{
			return Result.valueOf(Result.ERROR,"操作失败：暂无数据");
		}
		
		
	}
	
}
