package com.hc.travelers.service.interfaces;

import com.hc.travelers.custombean.CustomUsers;

public interface UsersService {
	
	/**
	 * 注册
	 * @param registUser	注册信息
	 * @return	注册完成的用户对象
	 * @throws Exception
	 */
	CustomUsers regist(CustomUsers registUser)throws Exception;
}
