package com.samrae.jtools;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class JCrypt {

	public static String toBase64(String s) {
		return toBase64(s.getBytes());
	}

	public static String toBase64(byte[] bytes) {
		Base64.Encoder b64 = Base64.getEncoder();
		return b64.encodeToString(bytes);

	}

	public static byte[] getSHA1(String s) {
		return getSHA1(s.getBytes());
	}

	public static byte[] fromBase64(String s) {
		Base64.Decoder b64 = Base64.getDecoder();
		return b64.decode(s);
	}
	
	public static String SHA1toHexString(byte[] bytes) {
		String r = "";
		
		for (int i = 0; i < bytes.length; i += 1) {
			String s = ("00" + Integer.toHexString(bytes[i] & 0xff));
//			System.out.print("sbefore = " + s + " ");
			s = s.substring(s.length()-2, s.length());
//			System.out.print("safter = " + s + "\n");
			r += s;
			
		}
		return r;
	}

	public static String SHA1toString(byte[] bytes) {
		
		return new String(bytes, StandardCharsets.UTF_8);
		

	}

	public static String getSHA1Base64(byte[] ba) {
		return toBase64(getSHA1(ba));
	}
	
	public static String encode(String s) {
		return getSHA1Base64(s.getBytes());
	}

	public static byte[] getSHA1(byte[] ba) {

		byte[] bytes = null;

		MessageDigest sha;
		try {
			sha = MessageDigest.getInstance("SHA-1");
			sha.reset();
			sha.update(ba);
			bytes = sha.digest();
			// System.out.println(p + " " +p.length());
			// System.out.println(sha.digest().toString());
			// for (int i = 0; i < sha.digest().length; i += 1) {
			// System.out.println(sha.digest()[i]);
			// }
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bytes;

	}

}
