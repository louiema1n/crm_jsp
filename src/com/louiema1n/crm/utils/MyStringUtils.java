package com.louiema1n.crm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyStringUtils {
	
	/**
	 * 将密码转换为MD5值
	 * @param value 明文
	 * @return	密文
	 */
	public String getMD5(String value) {
		try {
			//1.获得jdk提供消息摘要算法工具类
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			//2.加密的 结果10进制
			byte[] md5ValueByteArray = messageDigest.digest(value.getBytes());
			//3.将10进制转换成16进制(-1 for negative, 0 for zero, 1 for positive).
			BigInteger bigInteger = new BigInteger(1, md5ValueByteArray);
			//4.转换成16进制字符串输出
			return bigInteger.toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
}
