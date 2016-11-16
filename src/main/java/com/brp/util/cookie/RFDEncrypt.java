package com.brp.util.cookie;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2016/3/24.
 */
public class RFDEncrypt {
    @SuppressWarnings("unused")
    private static final String key = "FD!@7*$)";

    private static final String Algorithm = "DESede";

    /**
     *
     * @param message
     *            穿入要解密的cookie的值
     * @return 解密后的cookie的值
     * @throws Exception
     */
    public static String decrypt(String message) throws Exception {
        String[] split = message.split("-");
        byte[] data = new byte[split.length];
        for (int i = 0; i < split.length; i++) {
            int valueOf = Integer.valueOf(split[i], 16);
            data[i] = (byte) valueOf;
            if (data[i] < 0) {
                data[i] += 256;
            }
        }
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        byte[] retByte = cipher.doFinal(data);
        String decode = URLDecoder.decode(new String(retByte), "utf-8");
        return decode;
    }
    
    private static byte[] CreateMD5Base64CodeKey()
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] md5key = md5.digest(key.getBytes("GB2312"));
		BASE64Encoder base64Encoder = new BASE64Encoder();
		String MD5Codekey = base64Encoder.encode(md5key);
		return MD5Codekey.getBytes("GB2312");
	}

	public static String encryptMode(String painText)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] keybyte = CreateMD5Base64CodeKey();
		String enCode = encryptMode(keybyte, painText.getBytes("GB2312"));
		return enCode;
	}

	public static String decryptMode(String enCode)
			throws NoSuchAlgorithmException, IOException {
		byte[] keybyte = CreateMD5Base64CodeKey();
		String deCode = decryptMode(keybyte, enCode);
		return deCode;

	}

	// DES,DESede,Blowfish

	// keybyte
	// src
	private static String encryptMode(byte[] keybyte, byte[] src) {

		try {

			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			//
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			byte[] b = c1.doFinal(src);
			BASE64Encoder base64Encoder = new BASE64Encoder();
			String DesBase64Code = base64Encoder.encode(b);
			return new String(DesBase64Code);
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	// 
	// 
	private static String decryptMode(byte[] keybyte, String enCode)
			throws IOException {
		BASE64Decoder base64Decoder = new BASE64Decoder();
		byte[] src = base64Decoder.decodeBuffer(enCode);
		// byte[] keybyte = key.getBytes();
		try {
			
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return new String(c1.doFinal(src));
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

    public static String dpsEncrypt3DES(String plainText) throws Exception {
        String key = "8a9f24bc-cf06-4d65-9ccc-4f3368898440";
        byte[] data = plainText.getBytes("GB2312");

        //step 1 ,对key做md5运算
        //java的3DES中Key必须为24字节
        byte[] bTmp = MessageDigest.getInstance("MD5").digest(key.getBytes("GB2312"));
        byte[] bKey = new byte[24];
        System.arraycopy(bTmp,0,bKey,0,bTmp.length);
        System.arraycopy(bTmp,0,bKey,16,8);


        //step 1 ,生成key
        DESedeKeySpec desKeySpec = new DESedeKeySpec(bKey);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

        //step 2 ,3DES加密
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] retByte = cipher.doFinal(data);

        //step 3 ,Base64加密
        String lastStr = new String(Base64.encodeBase64String(retByte));
        return lastStr;

    }

}
