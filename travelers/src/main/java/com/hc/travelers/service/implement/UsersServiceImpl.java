package com.hc.travelers.service.implement;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.hc.travelers.custombean.CustomUsers;
import com.hc.travelers.dao.mapper.UsersMapper;
import com.hc.travelers.service.interfaces.UsersService;

public class UsersServiceImpl implements UsersService{
	@Resource
	private UsersMapper usersMapper;
	/**
	 * 注册
	 */
	@Override
	@Transactional
	public CustomUsers regist(CustomUsers registUser) throws Exception {
		//查询是否存在
		CustomUsers keyUser = null;
		usersMapper.selectByUser(keyUser);
		
		//插入用户
		CustomUsers valueUser = null;
		usersMapper.insert(valueUser);
		
		return null;
	}

}
