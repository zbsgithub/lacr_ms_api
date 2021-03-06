                            
package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.UserRoleInfoDao;
import com.gzdata.core.model.UserRoleInfo;

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
public class UserRoleInfoService extends AbstractBaseService<UserRoleInfo> {

	@Autowired
	private UserRoleInfoDao userRoleInfoDao;
	
	 
	@Override
	protected BaseDAOInterface<UserRoleInfo> getDAO() {
		return userRoleInfoDao;
	}

}