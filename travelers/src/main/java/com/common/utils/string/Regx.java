package com.common.utils.string;

final public class Regx {
	private Regx(){}
	private static final String PWD_REGX = "[A-Za-z\\d.!@#$%^&*]{6,18}"; // 密码
	public static final String USERNAME_REGX = "\\d{10}"; // 用户名
	public static final String REGISTER_CODE_REGX = "[A-Z\\d]{4}[-][A-Z\\d]{4}[-][A-Z\\d]{4}[-][A-Z\\d]{4}"; // 注册码
	public static final String NAME_REGX = "^(([\\u4e00-\\u9fa5]{2,8}))$"; // 姓名
	public static final String ID_NUM_REGX = "[1-9]\\d{16}[0-9X]"; // 身份证号
	public static final String QQ_NUM_REGX = "[1-9]\\d{4,10}"; // QQ号
	private static final String EMAIL_REGX = "^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$"; // 邮箱
	public static final String AGE_REGX = "\\d{1,3}"; // 年龄
	public static final String SEX_REGX = "[男女]"; // 性别
	private static final String TEL_NUM_REGX = "[1][34578]\\d{9}"; // 手机号码
	public static final String IP_ADDR_AND_PRO_NAME = "address_and_projectName.properties";  //项目的IP地址和项目名所在的配置文件
	public static final String VERIFY_TEL_REGX = "[0-9]{6}";
	public static final String VERIFY_EMAIL_REGX = "[a-zA-Z0-9]{6}";
	public static final int REGX_TYPE_RESTER = 1;
	public static final int REGX_TYPE_ALTER = 2;
	public static final int REGX_TYPE_ALTERINOF = 3;
	
	/**
	 * 验证手机号格式
	 * @param telphoneNumber	手机号
	 * @return	正确返回true / 错误返回false
	 */
	public static final boolean regxTelphone(final String telphoneNumber){
		if(telphoneNumber == null)
			return false;
		return telphoneNumber.matches(TEL_NUM_REGX);
	}
	
	/**
	 * 验证密码格式
	 * @param password	密码
	 * @return	正确返回true / 错误返回false
	 */
	public static final boolean regxPassword(final String password){
		if(password == null)
			return false;
		return password.matches(PWD_REGX);
	}
	
	/**
	 * 验证两个验证码是否正确
	 * @param verifyCode1	验证码1
	 * @param verifyCode2	 验证码2
	 * @return	正确返回true / 错误返回false
	 */
	public static final boolean regxVerifCode(final String verifyCode1,final String verifyCode2){
		if(verifyCode1 == null)
			return false;
		if(verifyCode2 == null)
			return false;
		if(!verifyCode1.equals(verifyCode2))
			return false;
		return true;
	}
	
	/**
	 * 验证邮箱格式
	 * @param email
	 * @return
	 */
	public static final boolean regxEmail(String email) {
		if(email == null)
			return false;
		return email.matches(EMAIL_REGX);
	}
}
