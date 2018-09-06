package com.huateng.scf.bas.batch.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.lang.StringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 * DES encryption algorithm, providing the encryption and decryption
 * algorithm for byte array and string
 */

public class CryptionData {
	// The length of Encryptionstring should be 8 bytes and not be
	// a weak key
	private String EncryptionString;

	// The initialization vector should be 8 bytes
	private final byte[] EncryptionIV = "abcdefgh".getBytes();
	private final static String DES = "DES/CBC/PKCS5Padding";

	/**
	 * Saving key for encryption and decryption
	 * @param EncryptionString String
	 */
	public CryptionData(String EncryptionString) {
		this.EncryptionString = EncryptionString;
	}

	/**
	 * Encrypt a byte array
	 * @param SourceData byte[]
	 * @throws Exception
	 * @return byte[]
	 */
	public byte[] EncryptionByteData(byte[] SourceData) throws Exception {
		byte[] retByte = null;

		// Create SecretKey object

		byte[] EncryptionByte = EncryptionString.getBytes();
		DESKeySpec dks = new DESKeySpec(EncryptionByte);

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Create IvParameterSpec object with initialization vector
		IvParameterSpec spec=new IvParameterSpec(EncryptionIV);

		// Create Cipter object
		Cipher cipher = Cipher.getInstance(DES);

		// Initialize Cipher object
		cipher.init(Cipher.ENCRYPT_MODE, securekey, spec);

		// Encrypting data
		retByte = cipher.doFinal(SourceData);
		return retByte;
	}

	/**
	 * Decrypt a byte array
	 * @param SourceData byte[]
	 * @throws Exception
	 * @return byte[]
	 */
	public byte[] DecryptionByteData(byte[] SourceData) throws Exception {
		byte[] retByte = null;

		// Create SecretKey object
		byte[] EncryptionByte = EncryptionString.getBytes();
		DESKeySpec dks = new DESKeySpec(EncryptionByte);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Create IvParameterSpec object with initialization vector
		IvParameterSpec spec=new IvParameterSpec(EncryptionIV);

		// Create Cipter object
		Cipher cipher = Cipher.getInstance(DES);

		// Initialize Cipher object
		cipher.init(Cipher.DECRYPT_MODE, securekey, spec);

		// Decrypting data
		retByte = cipher.doFinal(SourceData);

		return retByte;
	}

	/**
	 * Encrypt a string
	 * @param SourceData String
	 * @throws Exception
	 * @return String
	 */
	public String EncryptionStringData(String SourceData) throws Exception {
		String retStr = null;
		byte[] retByte = null;

		// Transform SourceData to byte array
		byte[] sorData = SourceData.getBytes();

		// Encrypte data
		retByte = EncryptionByteData(sorData);

		// Encode encryption data
		BASE64Encoder be = new BASE64Encoder();
		retStr = be.encode(retByte);

		return retStr;
	}

	/**
	 * Decrypt a string
	 * @param SourceData String
	 * @throws Exception
	 * @return String
	 */
	public String DecryptionStringData(String SourceData) throws Exception {
		String retStr = null;
		byte[] retByte = null;

		// Decode encryption data
		BASE64Decoder bd = new BASE64Decoder();
		byte[] sorData = bd.decodeBuffer(SourceData);

		// Decrypting data
		retByte = DecryptionByteData(sorData);
		retStr = new String(retByte);

		return retStr;
	}

	public static void main ( String[] argv ){

//		if ( argv.length != 3 ){
//			System.out.println("错误的参数！CryptionData 密钥 转换方式(enc-加密 dec-解密) 数据源");
//		}
//
//		String key = argv[0];
//		String type = argv[1];
//		String src = argv[2];
		String key = "Huateng.gd.Ocean's Fourteen.DWMNTH2CJFLCWL";
		String type = "enc";
		String src = "pass1234";
		String dest = "";

		CryptionData tools = new CryptionData(key);
		try{
			if ( StringUtils.equalsIgnoreCase(type, "enc")){ //加密
				dest = tools.EncryptionStringData(src);
			}else if ( StringUtils.equalsIgnoreCase(type, "dec")){ //解密
				dest = tools.DecryptionStringData(src);
			}
			System.out.println("处理结果["+dest+"]");
		}catch (Exception ex ){
			ex.printStackTrace();
		}


	}
}