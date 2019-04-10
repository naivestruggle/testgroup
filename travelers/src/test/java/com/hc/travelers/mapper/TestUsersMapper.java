package com.hc.travelers.mapper;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hc.travelers.custombean.CustomUsers;
import com.hc.travelers.dao.mapper.UsersMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-dao.xml",
		"classpath:spring/applicationContext-transaction.xml",})
public class TestUsersMapper {
	@Resource
	private UsersMapper usersMapper;
	
	@Test
	public void testInsert() throws Exception{
		//user_id,user_username,user_password,user_tel,user_email,user_birthday,user_sex,user_imgpath,user_status,user_createtime
		CustomUsers user = new CustomUsers();
		user.setUserPassword("123");
		user.setUserTel("123123123");
		user.setUserEmail("12312312312");
		user.setUserSex(0);
		user.setUserImgpath("wqeqweqw");
		user.setUserStatus(0);
		usersMapper.insert(user);
	}
}
