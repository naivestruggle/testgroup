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
	CustomUsers regist(CustomUsers registUser,String verifyCode,String sessionVerifyCode)throws Exception;

	/**
	 * 发送手机验证码
	 * @param userTel	手机号
	 * @return	返回发送成功的验证码   发送失败返回null
	 * @throws Exception
	 */
	String sendTelVerifyCode(String userTel)throws Exception;
}
