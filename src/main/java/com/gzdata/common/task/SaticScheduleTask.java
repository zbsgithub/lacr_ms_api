package com.gzdata.common.task;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gzdata.common.compoent.Constants;
import com.gzdata.common.util.DateUtil;
import com.gzdata.common.util.SshUtil;
import com.gzdata.common.util.SystemUsageUtil;
import com.gzdata.core.model.LogReportMonitor;
import com.gzdata.core.model.ServerMonitor;
import com.gzdata.core.model.SlaveMonitor;
import com.gzdata.core.service.LogReportMonitorService;
import com.gzdata.core.service.ServerMonitorService;
import com.gzdata.core.service.SlaveMonitorService;
import com.trilead.ssh2.Connection;



/**
 * 定时任务
 * 
 *
 * @author 张兵帅
 *
 * @version 
 *
 * @since 2019年7月24日
 */
@Component
//@EnableScheduling
public class SaticScheduleTask {

	
	private static Logger logger = LoggerFactory.getLogger(SaticScheduleTask.class);
	
	@Autowired
	private SlaveMonitorService slaveMonitorService;
	@Autowired
	private LogReportMonitorService logReportMonitorService;
	@Autowired
	private ServerMonitorService serverMonitorService;
	
	
	/**
	 * 
	 * 功能描述：slave监控源数据来源
	 *
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年7月25日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Scheduled(cron = "0 0/30 * * * ?")
    public void slaveMonitorData() {
		
		JSONArray jsonArray = JSONArray.parseArray(Constants.SLAVER_NODE_STR);
		
		//两个程序名称
		String [] programArray= {"lacr_classify","lacr_imgsyn_slave_v1"};
		
		try {
			
			slaveMonitorService.clearTable();//清空表数据
			
			//遍历10个节点信息
		    for (Object obj : jsonArray) {
		    	
		        JSONObject jsonObject = (JSONObject) obj;
		        
			    for (int i = 0; i < programArray.length; i++) {
			    		SlaveMonitor sm= new SlaveMonitor();
			    	
			    	   Connection conn=SshUtil.connec(jsonObject.getString("ip"), 22, "root", "Gzdatun1161n");
						
			    	   Map<String, Object> resultMap = SshUtil.excuteShell(conn, "ps -ef | grep "+programArray[i]+" | grep -v grep");
						
						
						sm.setMonitorTime(DateUtil.getNow());
						sm.setSlaveName(jsonObject.getString("lacr"));
						sm.setRunState(String.valueOf(resultMap.get("code")));
						sm.setProgramName(programArray[i]);//程序名称
						
						if(programArray[i].equals("lacr_classify")){//分类器程序
							
							Map<String, Object> dateMap = SshUtil.excuteShell(conn, "ls /data/snapshot_study/ -t | head -n 1 | grep -v total");
							String dateStr=String.valueOf(dateMap.get("result"));//日期
							
							//处理设备数
							String joinCommand = "ls /data/snapshot_study/"+dateStr+" | wc -l";
							Map<String, Object> handleMap = SshUtil.excuteShell(conn, joinCommand);//统计当前分类器处理多少个设备的图片
							
							//设备归档数
							String archiveCommand = "ls /data/snapshot_archives/"+jsonObject.getString("mac")+"/"+dateStr+" | wc -l";
							Map<String, Object> archiveMap = SshUtil.excuteShell(conn, archiveCommand);//统计当前分类器处理多少个设备的图片
							
							sm.setRemark("日期："+dateStr+"  snapshot_study处理设备数："+String.valueOf(handleMap.get("result")) +" / " + "snapshot_archives 总数："+archiveMap.get("result"));
						}
						
						slaveMonitorService.insertSelective(sm);
				}
				
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
    }
	
	/**
	 * 
	 * 功能描述：服务器运行状态监控
	 *
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年7月26日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Scheduled(cron = "0 0/30 * * * ?")
	public void serverMonitor(){

		logger.info("-----------磁盘和cpu内存---begin -------------");
		
		try {
			serverMonitorService.truncateTable();//清空表数据
			 
			 JSONArray jsonArray = JSONArray.parseArray(Constants.SLAVER_NODE_STR);
			
			 	//遍历10个节点信息
			    for (Object obj : jsonArray) {
			    	JSONObject jsonObject = (JSONObject) obj;
			    	 Connection conn=SshUtil.connec(jsonObject.getString("ip"), 22, "root", "Gzdatun1161n");
			    	 
			    	 String excuteCommand="df -h | grep dev";
			    	 
			    	 Map<String, Object> smState = SshUtil.excuteShell(conn,excuteCommand);
			    	 
			    	 ServerMonitor sMonitor=new ServerMonitor();
			    	 
			    	 	sMonitor.setHost(String.valueOf(jsonObject.getString("lacr")));
			    	 	
				        sMonitor.setCpu("");//cpu
			    	 	sMonitor.setMem(String.valueOf(1-SystemUsageUtil.getMemoryUsage()));
			    	 	sMonitor.setDisk(String.valueOf(smState.get("result")));
				        sMonitor.setMonitorTime(DateUtil.getNow());//更新时间
				        sMonitor.setRemark("运行状态监控每隔：30分钟探测一次");
			    	 
				     serverMonitorService.insertSelective(sMonitor);
			    	 logger.info("-----------slave node : -------------"+jsonObject.getString("lacr"));
			    }
		} catch (Exception e) {
			final Writer result = new StringWriter();
			final PrintWriter print = new PrintWriter(result);
			e.printStackTrace(print);
			logger.error("==============================="+result.toString());
		}
		 
		 logger.info("-----------磁盘和cpu内存-----end-------------");
		 
		 
		 
		 
		
	}
	
	/**
	 * 
	 * 功能描述：日志上报运行状态监控
	 *
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年7月26日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Scheduled(cron = "0 0/30 * * * ?")
	public void logReportMonitor(){
		logger.info("-----------log report monitor begin -------------");
		
		try {
			logReportMonitorService.truncateTable();//清空表数据
			 
			 JSONArray jsonArray = JSONArray.parseArray(Constants.SLAVER_NODE_STR);
			
			 	//遍历10个节点信息
			    for (Object obj : jsonArray) {
			    	JSONObject jsonObject = (JSONObject) obj;
			    	 Connection conn=SshUtil.connec(jsonObject.getString("ip"), 22, "root", "Gzdatun1161n");
			    	 
			    	 String excuteCommand="ls /data/lacr_report/ -t | head -n 1";
			    	 
			    	 Map<String, Object> logReportState = SshUtil.excuteShell(conn,excuteCommand);
			    	 
			    	 LogReportMonitor lrm=new LogReportMonitor();
			    	 
			    	 if(DateUtil.getDate(DateUtil.addDays(-2)).equals(logReportState.get("result")) || DateUtil.getDate(DateUtil.addDays(-1)).equals(logReportState.get("result"))){//相等
					        lrm.setReportState("0");
					        lrm.setRemark(String.valueOf(logReportState.get("result"))+"-日志-"+"已上报");
					        lrm.setReportTime(DateUtil.getNow());//上报时间
			    	 }else{
			    		 	lrm.setReportState("1");
					        lrm.setRemark("未上报");
			    	 }
			    	 	lrm.setSlaveNode(jsonObject.getString("lacr"));
				        lrm.setUpdateTime(DateUtil.getNow());//更新时间
			    	 
			    	 logReportMonitorService.insertSelective(lrm);
			    	 logger.info("-----------slave node : -------------"+jsonObject.getString("lacr"));
			    }
		} catch (Exception e) {
			final Writer result = new StringWriter();
			final PrintWriter print = new PrintWriter(result);
			e.printStackTrace(print);
			logger.error("==============================="+result.toString());
		}
		 
		 logger.info("-----------log report monitor end -------------");
		
	}
	
}
