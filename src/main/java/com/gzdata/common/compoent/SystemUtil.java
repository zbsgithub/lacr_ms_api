package com.gzdata.common.compoent;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import com.gzdata.core.model.UserBack;

/**
 * 系统工具类
 * 
 *
 * @author 张兵帅
 *
 * @version 
 *
 * @since 2018年4月1日
 */
@Component
public class SystemUtil {

	@Autowired
	private HttpSession session;
	/**
	 * 
	 * 功能描述：得到当前用户信息
	 *
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2018年4月1日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
//	public UserBack getCurrentUser(){
//		UserBack user=	(UserBack) session.getAttribute("user");
//		return user;
//	}
	
}
