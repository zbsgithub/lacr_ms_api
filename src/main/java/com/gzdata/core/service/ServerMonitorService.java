                                                                
package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.ServerMonitorDao;
import com.gzdata.core.model.ServerMonitor;

/**
 * 
 * 说明：处理对的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2019年07月24日
 */
@Service
public class ServerMonitorService extends AbstractBaseService<ServerMonitor> {

	@Autowired
	private ServerMonitorDao serverMonitorDao;
	
	 
	@Override
	protected BaseDAOInterface<ServerMonitor> getDAO() {
		return serverMonitorDao;
	}
	
	public int truncateTable(){
		return serverMonitorDao.truncateTable();
	}

}