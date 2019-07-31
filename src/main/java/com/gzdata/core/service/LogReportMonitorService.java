                                                            
package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.master.LogReportMonitorDao;
import com.gzdata.core.model.LogReportMonitor;

/**
 * 
 * 说明：处理对的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2019年07月23日
 */
@Service
public class LogReportMonitorService extends AbstractBaseService<LogReportMonitor> {

	@Autowired
	private LogReportMonitorDao logReportMonitorDao;
	
	 
	@Override
	protected BaseDAOInterface<LogReportMonitor> getDAO() {
		return logReportMonitorDao;
	}
	
	/**
	 * 
	 * 功能描述：clear table data
	 *
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年7月26日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	public int truncateTable(){
		return logReportMonitorDao.truncateTable();
	}

}