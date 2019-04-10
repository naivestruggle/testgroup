package com.common.utils.string;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;

public class Code {
	public static final int VERIFY_CODE_TYPE_EMAIL = 1;
	public static final int VERIFY_CODE_TYPE_TEL = 2;
	private static String codes = "23456789ABCDEFGHJKMNPQRSTUVWXYZ";
	
	/**
	 * 生成一个长度为len的验证码文本
	 * @param len 验证码长度
	 * @param type 验证码类型  邮箱验证码  手机验证码
	 * @return
	 */
	public static String createVerifyCode(int len,int type){
		StringBuilder sb = new StringBuilder();
		Random ra = new Random();
		switch(type){
		case 1:
			for(int i=0;i<len;i++){
				int index = ra.nextInt(codes.length());
				sb.append(codes.charAt(index));
			}
			return sb.toString();
		case 2:
			for(int i=0;i<len;i++)
				sb.append(ra.nextInt(10));
			return sb.toString();
		}
		return null;
	}
	
	/**
	 * 生成唯一的字符串 11位
	 * @param strBegin	字符串前缀
	 * @param strEnd	字符串后缀
	 * @param len		字符串数字区长度
	 * @return
	 */
	public static String createUserName(String strBegin,String strEnd){
		String s = MD5.parseMD5(UUID.randomUUID().toString().replace("-", "")).substring(0, 10);
		char[] carr = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(char c : carr){
			sb.append((int)c);
		}
		return strBegin+"_"+sb.toString().substring(0,10)+strEnd;
	}
	
	@Test
	public void testA(){
//		Set<String> set = new HashSet<String>();
//		for(int i=0;i<10000;i++){
//			String s = Code.createUserName("hc", "");
//			set.add(s);
//			System.out.println(s);
//		}
//		System.out.println("num:"+set.size());
//		System.out.println(MD5.parseMD5(UUID.randomUUID().toString().replace("-", "")));
		System.out.println(new Timestamp(new Date().getTime()));
	}
}
