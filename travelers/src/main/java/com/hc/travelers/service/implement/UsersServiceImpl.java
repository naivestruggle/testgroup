package com.hc.travelers.service.implement;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.common.utils.string.Regx;
import com.hc.travelers.custombean.CustomUsers;
import com.hc.travelers.dao.mapper.UsersMapper;
import com.hc.travelers.exception.UsersException;
import com.hc.travelers.service.interfaces.UsersService;

public class UsersServiceImpl implements UsersService{
	@Resource
	private UsersMapper usersMapper;
	
	@Override
	@Transactional
	final public CustomUsers regist(CustomUsers registUser,String code,String sessionCode) throws Exception {
		
		//验证手机号
		final String telphoneNumber = registUser.getUserTel();
		if(!Regx.regxTelphone(telphoneNumber))
			throw new UsersException("手机号格式不正确!");
		
		//验证密码
		final String password = registUser.getUserPassword();
		if(!Regx.regxPassword(password))
			throw new UsersException("密码格式不正确,6-18位！");
		
		//验证确认密码
		final String password2 = registUser.getUserPassword2();
		if(!password.equals(password2))
			throw new UsersException("两次输入的密码不一致！");
		
		
		//查询是否存在
		CustomUsers keyUser = null;
		usersMapper.selectByUser(keyUser);
		
		//插入用户
		CustomUsers valueUser = null;
		CustomUsers user = usersMapper.insert(valueUser);
		
		return null;
	}
	

}
