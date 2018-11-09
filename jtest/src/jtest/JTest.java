package jtest;
//import jtest.JCrypt;
import com.samrae.jtools.*;
public class JTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String hello = "hello";
		out(hello);
		
		byte[] sha1 = JCrypt.getSHA1(hello);
		out(JCrypt.SHA1toString(sha1));
		String hex = JCrypt.SHA1toHexString(sha1);
		out(hex + " " + hex.length());
		
		out(JCrypt.toBase64(sha1));
		
		
	}
	
	public static void out(String s) {
		System.out.println(s);
	}
	
	

}
