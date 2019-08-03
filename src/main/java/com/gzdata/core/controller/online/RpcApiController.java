package com.gzdata.core.controller.online;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.common.db.mybatis.result.ResultPage;
import com.gzdata.core.dto.StdChannelsRpcDto;
import com.gzdata.core.model.StdChannels;
import com.gzdata.core.qo.StdChannelsQo;
import com.gzdata.core.service.StdChannelsService;

@CrossOrigin
@RestController
@Api(description="远程调用接口-控制器")
public class RpcApiController {

	
	@Autowired
	private StdChannelsService stdChannelsService;
	
	/**
	 * 
	 * 功能描述：根据频道名-查询频道名称
	 *
	 * @param name
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年4月15日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@ApiOperation("按照频道名查询频道名称")
	@GetMapping("/rpc/find/std_channel/by/name")
	@ResponseBody
	public Map<String, Object> findStdChannelByName(@ApiParam(value="name") @RequestParam(value="name",required=false) String name){
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<StdChannels> stdChannelList = stdChannelsService.findStdNameByName(name);
		if(stdChannelList!=null && !stdChannelList.isEmpty()){//非空
			
			resultMap.put("count", 1);
			
			Map<String, Object> tempMap = new HashMap<String, Object>();
			tempMap.put("name", stdChannelList.get(0).getName());
			tempMap.put("ch_id", stdChannelList.get(0).getCid());
			tempMap.put("checked", stdChannelList.get(0).getChecked());
			
			tempMap.put("operator", stdChannelList.get(0).getOperator());
			tempMap.put("sourceType", stdChannelList.get(0).getSource());
			
			resultMap.put("results", tempMap);
			
		}else{
			resultMap.put("count", 0);
			
			Map<String, Object> tempMap = new HashMap<String, Object>();
			tempMap.put("name", null);
			tempMap.put("ch_id", null);
			tempMap.put("operator", null);
			tempMap.put("sourceType", null);
			
			resultMap.put("results", tempMap);
			
		}
		
		return resultMap;//找到则返回
		
	}
	/**
	 * 
	 * 功能描述：按照频道id查询频道信息
	 *
	 * @param chId
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年4月30日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@ApiOperation("按照chId查询频道名称")
	@GetMapping("/rpc/find/stdInfo/by/chId")
	@ResponseBody
	public Result findStdInfoByChId(@ApiParam(value="chId") @RequestParam(value="chId",required=false) String chId){
		
		StdChannels std = stdChannelsService.findStdInfoByChId(chId);
		return Result.valueOf(Result.SUCCESS,std);//找到则返回
		
	}
	
	
	/**
	 * 
	 * 功能描述：列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2018年12月19日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@ApiOperation("查询IPTV列表信息")
	@GetMapping("/rpc/data/std/channel/pagelist")
	@ResponseBody
	public ResultPage pagelist(@ModelAttribute StdChannelsQo qo) {
		List<StdChannels> stdList = stdChannelsService.findPaginationDataByCondition(qo);
		List<StdChannelsRpcDto> dtoList = new ArrayList<StdChannelsRpcDto>();
		
		for (StdChannels stdChannel : stdList) {
			StdChannelsRpcDto dto = new StdChannelsRpcDto();
			BeanUtils.copyProperties(stdChannel, dto);
			
			dto.setSourceType(stdChannel.getSource());//字段名更换
			dto.setChId(stdChannel.getCid());//字段名更换
			
			dto.setChecked(stdChannel.getChecked() == 1 ? true : false);
			
			dtoList.add(dto);//装载容器
		}
		return ResultPage.valueOf(ResultPage.SUCCESS,ResultPage.SUCCESS_STR,stdChannelsService.findTotalCountByCondition(qo),dtoList);
	}
	
}
