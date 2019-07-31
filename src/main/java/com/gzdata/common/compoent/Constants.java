package com.gzdata.common.compoent;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


/**
 * 常量类
 * 
 *
 * @author 张兵帅
 *
 * @version 
 *
 * @since 2018年4月7日
 */
public class Constants {
	/**
	 * linux下文件保存路径
	 */	
	public static final String fileUploadPath=File.separator+"data"+File.separator+"lacr_media"+File.separator+"system_info"+File.separator+"std_channel"+File.separator;//文件上传地址
	/**
	 * window下保存路径
	 */
//	public static final String fileUploadPath="D:"+File.separator+"develop tools"+File.separator+"img"+File.separator+"";//文件上传地址
	
	/**
	 * 10个从节点信息
	 */
	public static final String SLAVER_NODE_STR = "["
			+ "{\"lacr\":\"lacr_002\",\"ip\":\"59.110.116.73\",\"mac\":\"00163E0AA006\"},"
			+ "{\"lacr\":\"lacr_003\",\"ip\":\"101.201.181.119\",\"mac\":\"00163E0E563C\"},"
			+ "{\"lacr\":\"lacr_004\",\"ip\":\"39.107.61.139\",\"mac\":\"00163E0A0340\"},"
			+ "{\"lacr\":\"lacr_005\",\"ip\":\"47.93.148.29\",\"mac\":\"00163E0AB982\"},"
			+ "{\"lacr\":\"lacr_006\",\"ip\":\"47.93.115.141\",\"mac\":\"00163E309CD9\"},"
			+ "{\"lacr\":\"lacr_007\",\"ip\":\"39.96.115.45\",\"mac\":\"00163E3065A9\"},"
			+ "{\"lacr\":\"lacr_008\",\"ip\":\"47.93.151.103\",\"mac\":\"00163E06A993\"},"
			+ "{\"lacr\":\"lacr_009\",\"ip\":\"101.201.180.204\",\"mac\":\"00163E2EA15F\"},"
			+ "{\"lacr\":\"lacr_010\",\"ip\":\"47.93.208.184\",\"mac\":\"00163E309A1C\"},"
			+ "{\"lacr\":\"lacr_011\",\"ip\":\"47.93.208.152\",\"mac\":\"00163E2ED94C\"}]";

}
