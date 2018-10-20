package com.java.util;
/**
 * 字符串  工具类
 * @author Garin
 *
 */
public class stringUtil {
	/**
	 * 检查字段是否为空
	 * @param string
	 * @return
	 */
	public static boolean isEmpty(String string) {
		if (string==null||string.equals("")) {
			return true;
		}else {
			return false;
		}
	}
	
}
