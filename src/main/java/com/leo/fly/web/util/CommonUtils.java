package com.leo.fly.web.util;

import com.leo.fly.common.enums.Platform;
import com.leo.fly.web.form.PublicRequestHeader;

public class CommonUtils {

	public static Platform getPlatform() {
		String platform = UserContextHolder.getInstance().getPlatform();
		return Platform.valueOf(platform);
	}

	public static String getUniqByPlatform(String platform, String... str) {
		if (str.length < 1) {
			return null;
		}
		StringBuilder stringBuilder = new StringBuilder(platform);
		for (String s : str) {
			stringBuilder.append("_").append(s);
		}
		return stringBuilder.toString();
	}

//	public static void main(String[] args) {
//		String decode = AES256.decode(
//				"OERCREVDODE5MjM1RjFDQ0REODhFRTNCOUYyRTQ3MEI5RjNGNTJBNTJEOURGNUU5NkJFOUIxMTM1MkI5RTM3QjZFMkU1QzJCMjIzNkE2MkQ0QUIyOUI1MzAxMEI5NURBNDJDMzEyRTc1NDA2RjRGQ0NGMEJBQTRDM0UwQjIwRjg1NTcwMUQ0NUJDNjhDMkQ0RUJBM0UwNTFEMEY2QkI4RjY4M0YyMDk5MkY3QjkyMzAzNUUyRTBBNTNCMkIwRUEyRDMwOTRBQzcwQkE4OUI3RDQ4MjFBNUFCOTA3REU4MEJBRjE0NkMxQjg2QUNBMjQ3OUFDNjE1RjhDOTBENEIzQTI1MDQyMDdCRDVBMjExMzVEOTEyRTQyRDk5QTVGNzIw",
//				"ccd91278035e6ec4");
//		PublicRequestHeader header = JSONObject.parseObject(decode, PublicRequestHeader.class);
//		String signEnc = getSignEnc(header);
//		String signEnc2 = getSignEnc2(header);
//		String signEnc3 = getSignEnc3(header);
//		String sourceSign = MD5Util.string2MD5(signEnc);
//		String sourceSign2 = MD5Util.string2MD5(signEnc2);
//		String sourceSign3 = MD5Util.string2MD5(signEnc3);
//		String targetSign = header.getSign();
//		if (StringUtils.notEquals(sourceSign, targetSign)) {
//			throw new ComException(ErrorCodeEnum.E_SIGN);
//		}
//	}

	public static String getSignEnc(PublicRequestHeader header) {
		Platform platform = header.getPlatform();
		StringBuffer sb = new StringBuffer();
		sb.append(header.getAppId()).append(platform).append(header.getTimestamp()).append(header.getSessionId())
				.append(platform.getKey32());
		return sb.toString();
	}
	public static String getSignEnc2(PublicRequestHeader header) {
		Platform platform = header.getPlatform();
		StringBuffer sb = new StringBuffer();
		sb.append(header.getAppId()).append(platform).append(header.getTimestamp()).append(header.getSessionId());
		return sb.toString();
	}
	public static String getSignEnc3(PublicRequestHeader header) {
		Platform platform = header.getPlatform();
		StringBuffer sb = new StringBuffer();
		sb.append(header.getAppId()).append(platform).append(header.getTimestamp()).append(header.getSessionId()).append(platform.getKey16());
		return sb.toString();
	}
}
