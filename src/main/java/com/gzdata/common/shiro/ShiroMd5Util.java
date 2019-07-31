package com.gzdata.common.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
/**
 * 
 * shiro提供了SimpleHash类帮助我们快速加密：
 *
 * @author 张兵帅
 *
 * @version 
 *
 * @since 2019年7月18日
 */
public class ShiroMd5Util {
	
	/**
	 * 
	 * 功能描述：密码md5加密
	 *
	 * @param username
	 * @param pwd
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年7月22日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	public static String MD5Pwd(String username, String pwd) {
        // 加密算法MD5
        // salt盐 username + salt
        // 迭代次数
        String md5Pwd = new SimpleHash("MD5", pwd,ByteSource.Util.bytes(username + "salt"), 2).toHex();
        return md5Pwd;
    }
}
