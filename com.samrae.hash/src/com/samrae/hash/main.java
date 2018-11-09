package com.samrae.hash;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.samrae.jtools.JCrypt;





public class main {
	static String nonce = "";
	static String createdTimestamp = "";
	static String password = "";
	
	public static void out(String s) {
		System.out.println(s);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		out(makeNonce());
		Random rng = new Random();
		nonce = Long.toHexString(rng.nextLong()) + Long.toHexString(rng.nextLong());
		nonce = nonce.substring(0,16);
		
//		out(r + " " + r.length());
		
		if (args.length == 3) {
			createdTimestamp = args[0];
			password = args[1];
			String filename = args[2];
			
//			out(filename);
			
//			getFileLines(filename);
//			String nonce = 
			if (createdTimestamp.length() > 0 && password.length() > 0) {
				ArrayList<String> list = new ArrayList<String>();
				String pwd = JCrypt.encode(nonce+createdTimestamp+JCrypt.encode(password));
//				out(pwd);
				list.add("timestamp\t"+createdTimestamp);
				list.add("outputPath\t"+filename);
				list.add("base64Nonce\t"+JCrypt.toBase64(nonce));
				list.add("nonce\t"+nonce);
				list.add("digest\t"+pwd);
				for (String s : list) {
					out(s);
				}
				writeToFile(filename, list);

				
				
				
			}
		}
		

	}
	
	
	
	public static void writeToFile(String filename, List<String> lines) {
		Path file = Paths.get(filename);
		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	



}
