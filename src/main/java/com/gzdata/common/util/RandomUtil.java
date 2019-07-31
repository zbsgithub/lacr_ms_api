package com.gzdata.common.util;

import java.util.Random;
import java.util.UUID;

/**
 * 随机数
 * 
 *
 * @author 张兵帅
 *
 * @version 
 *
 * @since 2018年12月20日
 */
public class RandomUtil {
	
	/**
	 * 
	 * 功能描述：生成唯一uuid(截取13位)+三位随机数
	 *
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2018年12月20日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	public static String generImgRandomName(){
		String uuidStr =UUID.randomUUID().toString();
//		System.out.println(uuidStr);
		
		 int i = (int)(Math.random()*900 + 100);
		 String myStr = Integer.toString(i);
//		 System.out.println(myStr);
		
		
		return uuidStr.substring(0, 13)+"-"+myStr;
		
	}
	
//	public static void main(String[] args) {
//		String abcString = generImgRandomName();
//		System.out.println(abcString);
//	}
	
}
