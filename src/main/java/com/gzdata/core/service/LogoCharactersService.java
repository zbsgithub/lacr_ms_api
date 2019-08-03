                                                                                                                                                                                    
package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.LogoCharactersDao;
import com.gzdata.core.model.LogoCharacters;

/**
 * 
 * 说明：处理对的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2019年07月30日
 */
@Service
public class LogoCharactersService extends AbstractBaseService<LogoCharacters> {

	@Autowired
	private LogoCharactersDao logoCharactersDao;
	
	 
	@Override
	protected BaseDAOInterface<LogoCharacters> getDAO() {
		return logoCharactersDao;
	}

}