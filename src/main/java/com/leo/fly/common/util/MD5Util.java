package com.leo.fly.common.util;

import java.security.MessageDigest;

public class MD5Util {
	public static String string2MD5(String inStr) {
		return enc(inStr);

	}
	public static String enc(String inStr) {
		if(StringUtils.isBlank(inStr)){
			return "";
		}
		MessageDigest md5 ;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();

	}
	public static String getNameSign(String appid,String platform,String timestamp,String sessionId,String key){
		StringBuffer buffer = new StringBuffer();
		buffer.append(appid).append(platform)
				.append(timestamp)
				.append(sessionId)
				;
		if(StringUtils.isNotBlank(key)){
			buffer.append(key);
		}
		return string2MD5(buffer.toString());
	}
}

