                                                        
package com.gzdata.core.service;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.master.SlaveMonitorDao;
import com.gzdata.core.model.SlaveMonitor;

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
public class SlaveMonitorService extends AbstractBaseService<SlaveMonitor> {

	@Autowired
	private SlaveMonitorDao slaveMonitorDao;
	
	 
	@Override
	protected BaseDAOInterface<SlaveMonitor> getDAO() {
		return slaveMonitorDao;
	}
	
	/**
	 * 
	 * 功能描述：清空表数据
	 *
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年7月26日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	public int clearTable(){
		return slaveMonitorDao.clearTable();
	}

}