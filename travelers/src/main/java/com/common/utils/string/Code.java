package com.common.utils.string;

import java.util.Random;

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
}
