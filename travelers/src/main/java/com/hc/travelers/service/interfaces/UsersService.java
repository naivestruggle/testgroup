package com.hc.travelers.service.interfaces;

import com.hc.travelers.custombean.CustomUsers;

public interface UsersService {
	
	
	/**
	 * 注册
	 * @param registUser	注册信息
	 * @param code	用户输入的验证码
	 * @param sessionCode	系统生成的验证码
	 * @return	注册完成的用户对象
	 * @throws Exception
	 */
	CustomUsers registService(CustomUsers registUser,String verifyCode,String sessionVerifyCode)throws Exception;

	/**
	 * 发送手机验证码
	 * @param userTel	手机号
	 * @return	返回发送成功的验证码   发送失败返回null
	 * @throws Exception
	 */
	String sendTelVerifyCodeService(String userTel)throws Exception;
	/**
	 * 发送登录验证码
	 * @param account 手机或邮箱
	 * @return
	 * @throws Exception
	 */
	String sendLoginVerifyCodeService(String account)throws Exception;
	
	/**
	 * 发送修改密码验证码
	 * @param account	手机号或邮箱
	 * @return
	 * @throws Exception
	 */
	String sendAlterPwdCodeService(String account)throws Exception;
	/**
	 * 登录
	 * @param account 手机或邮箱
	 * @param verifyCode 用户输入的验证码
	 * @param sessionVerifyCode 系统生成的验证码
	 * @return ok 成功
	 * @throws Exception 
	 */
	CustomUsers loginService(String account, String verifyCode, String sessionVerifyCode) throws Exception;

	/**
	 * 修改密码
	 * @param account	手机号/邮箱
	 * @param verifyCode	用户输入的验证码
	 * @param sessionVerifyCode	系统生成的验证码
	 * @param info	用户对象（里面有 新密码 和 确认密码）
	 * @throws Exception
	 */
	void alterPasswordService(String account, String verifyCode, String sessionVerifyCode, CustomUsers info)throws Exception;

	
}
