package com.leo.fly.common.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;


/**
 *
 * @author Administrator
 *
 */
public class AES256 {

	private static final String ENCODE = "UTF-8";
	private static final String FORMAT = "AES";
	private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

	public static String encryption(String content, String secretKey) {
		if (secretKey == null) {
			return null;
		}
		if (secretKey.length() != 16) {
			return null;
		}
		try {
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			byte[] raw = secretKey.getBytes();
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] encrypted = cipher.doFinal(content.getBytes("utf-8"));
			String hexString = Hex.encodeHexString(encrypted);
			return Base64.encodeBase64String(hexString.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密
	 */
	public static String decode(String str, String skey) {
		try {
			if (str == null) {
				return null;
			}
			byte[] b64 = Base64.decodeBase64(str);
			String b64Str = new String(b64);
			byte[] data = Hex.decodeHex(b64Str);

			Security.addProvider(new  org.bouncycastle.jce.provider.BouncyCastleProvider());

			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);

			SecretKeySpec secretKeySpec = new SecretKeySpec(skey.getBytes(ENCODE), FORMAT);

			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

			return new String(cipher.doFinal(data), ENCODE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
