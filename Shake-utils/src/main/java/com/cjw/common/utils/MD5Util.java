package com.cjw.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5
 * 
 * @author LIMENGCHENG292
 * 
 */
public class MD5Util {

	private static final String DEFAULTMD5String = "00000000000000000000000000000000";
	private static MD5Util instance = null;
	private static String TYPE = "MD5";

	private MD5Util() {
	}

	public static synchronized MD5Util getInstance() {
		return instance == null ? new MD5Util() : instance;
	}

	public String encrypt(String str) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance(TYPE);
		} catch (NoSuchAlgorithmException e) {
			return DEFAULTMD5String;
		}
		if (str == null) {
			return DEFAULTMD5String;
		}
		try {
			md5.update(str.getBytes("UTF-8"));
		} catch (Exception e) {
			return DEFAULTMD5String;
		}
		byte[] b = md5.digest();
		int i = 0;
		StringBuffer buf = new StringBuffer("");
		for (int offset = 0; offset < b.length; offset++) {
			i = b[offset];
			if (i < 0) {
				i = i + 256;
			}
			if (i < 16) {
				buf.append("0");
			}
			buf.append(Integer.toHexString(i));
		}
		return buf.toString();
	}

	public String encrypt(Object obj) throws IOException {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance(TYPE);
		} catch (NoSuchAlgorithmException e) {
			return DEFAULTMD5String;
		}
		if (obj == null) {
			return DEFAULTMD5String;
		}
		md5.update(objToBytes(obj));
		byte[] b = md5.digest();
		int i = 0;
		StringBuffer buf = new StringBuffer("");
		for (int offset = 0; offset < b.length; offset++) {
			i = b[offset];
			if (i < 0) {
				i = i + 256;
			}
			if (i < 16) {
				buf.append("0");
			}
			buf.append(Integer.toHexString(i));
		}
		return buf.toString();
	}

	public static byte[] objToBytes(Object obj) throws IOException {
		if (obj == null) {
			return null;
		}
		ByteArrayOutputStream bo = null;
		ObjectOutputStream oo = null;
		try {
			bo = new ByteArrayOutputStream();
			oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);
			oo.flush();
			oo.close();
			return bo.toByteArray();
		} catch (IOException e) {
			throw e;
		} finally {
			if (bo != null) {
				bo.close();
				bo = null;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(getInstance().encrypt("广东省深圳市福田区新洲村湖北大厦9楼C区234567890key"));
	}

}
