package com.hc.travelers.service.implement;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.utils.date.DateUtils;
import com.common.utils.string.Code;
import com.common.utils.string.MD5;
import com.common.utils.string.Regx;
import com.common.utils.telephone.Tel;
import com.hc.travelers.custombean.CustomUsers;
import com.hc.travelers.dao.mapper.UsersMapper;
import com.hc.travelers.exception.UsersException;
import com.hc.travelers.service.interfaces.UsersService;

@Service("usersService")
final public class UsersServiceImpl implements UsersService{
	@Resource
	private UsersMapper usersMapper;
	
	/**
	 * 注册
	 */
	@Override
	@Transactional(rollbackFor=UsersException.class)
	final public CustomUsers regist(CustomUsers registUser,String verifyCode,String sessionVerifyCode) throws Exception {
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
		
		//验证验证码
		if(!Regx.regxVerifCode(verifyCode, sessionVerifyCode))
			throw new UsersException("验证码输入错误！");
		
		//查询是否存在
		Integer count = usersMapper.selectByTelToCount(telphoneNumber);
		if(count != null && count > 0)
			throw new UsersException("手机号已注册！");
		
		//密码加密
		registUser.setUserPassword(MD5.parseMD5(password));
		
		//设置昵称
		registUser.setUserUsername(Code.createUserName("hc", ""));
		
		//设置创建时间
		registUser.setUserCreatetime(new Timestamp(new Date().getTime()));
		
		//设置用户初始状态
		registUser.setUserStatus(1);
		
		//设置用户初始性别
		registUser.setUserSex(1);
		
		//插入用户
		usersMapper.insert(registUser);
		
		//返回插入的用户ID
		Integer userId = registUser.getUserId();
//		System.out.println("userId:"+userId);
		
		//查询用户
		final List<CustomUsers> userList = usersMapper.selectById(userId);
		if(userList == null || userList.size() != 1)
			throw new UsersException("注册失败，系统繁忙，请稍后再试！");
		
		//返回注册的对象
		return userList.get(0);
	}

	/**
	 * 发送手机验证码
	 */
	@Override
	public String sendTelVerifyCode(String userTel) throws Exception {
		//验证手机号格式
		if(!Regx.regxTelphone(userTel))
			throw new UsersException("手机号格式不正确!");
		
		//查询是否存在
		Integer count = usersMapper.selectByTelToCount(userTel);
		if(count != null && count > 0)
			throw new UsersException("手机号已注册！");
		
		//生成验证码
		String verifyCode = Code.createVerifyCode(6, Code.VERIFY_CODE_TYPE_TEL);
		
		try{
			//发送验证码
			Tel.sendTelCode(userTel, "您的验证码："+verifyCode+"请勿将验证码泄露给他人！");
		}catch(Exception e){
			e.printStackTrace();
			throw new UsersException("验证码发送失败，系统异常，请稍后再试！");
		}
		
		//返回验证码
		return verifyCode;
	}
	

}
