/*package com.gzdata.core.qo.jqgrid;

import com.gzdata.core.common.db.mybatis.component.jqgrid.JqgridQuery;
import com.gzdata.core.model.LogReportMonitor;


                                                                                    



import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import com.gzdata.core.common.util.DateUtil;

import java.util.Date;



public class LogReportMonitorJqgridQo extends JqgridQuery<LogReportMonitor>{


 							private Integer id; //主键


 							private String slaveNode; //


 							private String reportState; //上报状态


 		    
    		@DateTimeFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT)
    						private Date reportTime; //上报时间


 							private String remark; //备注


 		    
    		@DateTimeFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT)
    						private Date updateTime; //更新时间




*//** 以下为get,set方法 *//*
   		 						
        	
        	 public Integer getId() {
		        return this.id;
	        }
	        public void setId(Integer id) {
	        	this.id = id;
	        }
	

   		 						
        	
        	 public String getSlaveNode() {
		        return this.slaveNode;
	        }
	        public void setSlaveNode(String slaveNode) {
	        	this.slaveNode = slaveNode;
	        }
	

   		 						
        	
        	 public String getReportState() {
		        return this.reportState;
	        }
	        public void setReportState(String reportState) {
	        	this.reportState = reportState;
	        }
	

   		     
    		@JsonFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
    							
        	
        	 public Date getReportTime() {
		        return this.reportTime;
	        }
	        public void setReportTime(Date reportTime) {
	        	this.reportTime = reportTime;
	        }
	

   		 						
        	
        	 public String getRemark() {
		        return this.remark;
	        }
	        public void setRemark(String remark) {
	        	this.remark = remark;
	        }
	

   		     
    		@JsonFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
    							
        	
        	 public Date getUpdateTime() {
		        return this.updateTime;
	        }
	        public void setUpdateTime(Date updateTime) {
	        	this.updateTime = updateTime;
	        }
	






}
*/