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
import com.gzdata.core.dto.SlaveMonitorDto;
import com.gzdata.core.model.SlaveMonitor;
import com.gzdata.core.qo.SlaveMonitorQo;
import com.gzdata.core.service.SlaveMonitorService;

/**
 * 
 * SlaveMonitor信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2019年07月24日
 */
//@Controller
public class SlaveMonitorDataController {

	@Autowired
	private  SlaveMonitorService slaveMonitorService;
	
	/**
	 * 
	 * 功能描述：列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月24日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/slave/monitor/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody SlaveMonitorQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功", slaveMonitorService.findPaginationDataByCondition(qo));
	}
	
	/**
	 * 
	 * 功能描述：列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月24日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/slave/monitor/list")
	@ResponseBody
	public Result list(@RequestBody SlaveMonitorQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功", slaveMonitorService.findList(qo));
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
	@RequestMapping("data/slave/monitor/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功", slaveMonitorService.findById(id));
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
	@RequestMapping("data/slave/monitor/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

	 	 slaveMonitorService.batchDelete(ids);
			

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
	@RequestMapping("data/slave/monitor/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		
			 			 slaveMonitorService.deleteByID(id);
			
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
	@RequestMapping("data/slave/monitor/add")
	@ResponseBody
	 	 public Result add(@RequestBody SlaveMonitorDto dto) {
	
	
		 				SlaveMonitor slaveMonitor = new SlaveMonitor();
				BeanUtils.copyProperties(dto, slaveMonitor);
				slaveMonitorService.insert(slaveMonitor);
		
				

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
	@RequestMapping("data/slave/monitor/update")
	@ResponseBody
	 	 public Result edit(@RequestBody SlaveMonitorDto dto) {
		
	 				SlaveMonitor slaveMonitor = new SlaveMonitor();
				BeanUtils.copyProperties(dto, slaveMonitor);
				slaveMonitorService.updateSelective(slaveMonitor);
		
		
		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
