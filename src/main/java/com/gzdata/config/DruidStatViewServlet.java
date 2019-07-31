package com.gzdata.config;

import com.alibaba.druid.support.http.StatViewServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;

/**
 * 配置监控界面
 * 
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2017年5月31日
 */
@WebServlet(urlPatterns = "/druid/*", initParams = { @WebInitParam(name = "allow", value = ""), // IP白名单
																														// (没有配置或者为空，则允许所有访问)
		@WebInitParam(name = "deny", value = ""), // IP黑名单
																// (存在共同时，deny优先于allow)
		@WebInitParam(name = "loginUsername", value = "admin"), // 用户名
		@WebInitParam(name = "loginPassword", value = "123"), // 密码
		@WebInitParam(name = "resetEnable", value = "false")// 禁用HTML页面上的“Reset
															// All”功能
})
public class DruidStatViewServlet extends StatViewServlet {
	private static final long serialVersionUID = 1L;

}