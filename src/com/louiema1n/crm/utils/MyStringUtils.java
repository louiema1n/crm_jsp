package com.louiema1n.crm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyStringUtils {
	
	/**
	 * ������ת��ΪMD5ֵ
	 * @param value ����
	 * @return	����
	 */
	public String getMD5(String value) {
		try {
			//1.���jdk�ṩ��ϢժҪ�㷨������
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			//2.���ܵ� ���10����
			byte[] md5ValueByteArray = messageDigest.digest(value.getBytes());
			//3.��10����ת����16����(-1 for negative, 0 for zero, 1 for positive).
			BigInteger bigInteger = new BigInteger(1, md5ValueByteArray);
			//4.ת����16�����ַ������
			return bigInteger.toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
}
