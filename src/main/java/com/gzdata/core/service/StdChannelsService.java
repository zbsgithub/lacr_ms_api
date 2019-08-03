                                                                                                            
package com.gzdata.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.StdChannelsDao;
import com.gzdata.core.model.StdChannels;

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
public class StdChannelsService extends AbstractBaseService<StdChannels> {

	@Autowired
	private StdChannelsDao stdChannelsDao;
	
	 
	@Override
	protected BaseDAOInterface<StdChannels> getDAO() {
		return stdChannelsDao;
	}
	

	/**
	 * 
	 * 功能描述：根据频道名称查询对象
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
	public List<StdChannels> findStdNameByName(String name){
		return stdChannelsDao.findStdNameByName(name);
	}

	/**
	 * 
	 * 功能描述：根据标准频道ID查询对象
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
	public StdChannels findStdInfoByChId(String chId){
		return stdChannelsDao.findStdInfoByChId(chId);
	}

}