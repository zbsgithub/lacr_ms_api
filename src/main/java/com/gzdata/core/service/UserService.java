                                                
package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.UserDao;
import com.gzdata.core.model.User;

/**
 * 
 * 说明：处理对的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2019年07月17日
 */
@Service
public class UserService extends AbstractBaseService<User> {

	@Autowired
	private UserDao userDao;
	
	 
	@Override
	protected BaseDAOInterface<User> getDAO() {
		return userDao;
	}


	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

}