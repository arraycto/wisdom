package com.cslg.system.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class ShiroUtils {

	/**
	 * 加盐加密
	 * @param username
	 * @param password
	 * @return
	 */
	public static String shiroSalt(String username, String password) {
		
		// 将用户名作为盐值
        ByteSource salt = ByteSource.Util.bytes(username);
        /*
         * MD5加密：
                  *  使用SimpleHash类对原始密码进行加密。
                  *  第一个参数代表使用MD5方式加密
                  *  第二个参数为原始密码
                  *  第三个参数为盐值，即用户名
                  *  第四个参数为加密次数
                  *  最后用toHex()方法将加密后的密码转成String
         * */
        String newPassword = new SimpleHash("MD5", password, salt, 1024).toHex();
		return newPassword;
	}
}
