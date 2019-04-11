package com.hc.travelers.service.implement;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.utils.mail.MailUtils;
import com.common.utils.string.Code;
import com.common.utils.string.MD5;
import com.common.utils.string.Regx;
import com.common.utils.telephone.Tel;
import com.hc.travelers.custombean.CustomUsers;
import com.hc.travelers.dao.mapper.UsersMapper;
import com.hc.travelers.exception.UsersException;
import com.hc.travelers.service.interfaces.UsersService;

@Service("usersService")
final public class UsersServiceImpl implements UsersService {
	@Resource
	private UsersMapper usersMapper;

	/**
	 * 注册
	 */
	@Override
	@Transactional(rollbackFor = UsersException.class)
	final public CustomUsers registService(CustomUsers registUser, String verifyCode, String sessionVerifyCode)
			throws Exception {
		// 验证手机号
		final String telphoneNumber = registUser.getUserTel();
		if (!Regx.regxTelphone(telphoneNumber))
			throw new UsersException("手机号格式不正确!");

		// 验证密码
		final String password = registUser.getUserPassword();
		if (!Regx.regxPassword(password))
			throw new UsersException("密码格式不正确,6-18位！");

		// 验证确认密码
		final String password2 = registUser.getUserPassword2();
		if (!password.equals(password2))
			throw new UsersException("两次输入的密码不一致！");

		// 验证验证码
		if (!Regx.regxVerifCode(verifyCode, sessionVerifyCode))
			throw new UsersException("验证码输入错误！");

		// 查询是否存在
		Integer count = usersMapper.selectByTelToCount(telphoneNumber);
		if (count != null && count > 0)
			throw new UsersException("手机号已注册！");

		// 密码加密
		registUser.setUserPassword(MD5.parseMD5(password));

		// 设置昵称
		registUser.setUserUsername(Code.createUserName("hc", ""));

		// 设置创建时间
		registUser.setUserCreatetime(new Timestamp(new Date().getTime()));

		// 设置用户初始状态
		registUser.setUserStatus(1);

		// 设置用户初始性别
		registUser.setUserSex(1);

		// 插入用户
		usersMapper.insert(registUser);

		// 返回插入的用户ID
		Integer userId = registUser.getUserId();
//		System.out.println("userId:"+userId);

		// 查询用户
		final List<CustomUsers> userList = usersMapper.selectById(userId);
		if (userList == null || userList.size() != 1)
			throw new UsersException("注册失败，系统繁忙，请稍后再试！");

		// 返回注册的对象
		return userList.get(0);
	}

	/**
	 * 登录
	 * 
	 * @throws Exception
	 */
	@Override
	@Transactional(rollbackFor = UsersException.class)
	final public CustomUsers loginService(String account, String verifyCode, String sessionVerifyCode) throws Exception {
		// 验证验证码
		if (!Regx.regxVerifCode(verifyCode, sessionVerifyCode))
			throw new UsersException("验证码输入错误！");
		// 判断是手机号还是邮箱
		if (Regx.regxTelphone(account)) {
			List<CustomUsers> userList = usersMapper.selectByTel(account);
			// 如果有多个用户，则报错
			if (userList == null || userList.size() != 1) {
				throw new UsersException("账号不正确！");
			}
			return userList.get(0);
		} else if (Regx.regxEmail(account)) {
			List<CustomUsers> userList = usersMapper.selectByMail(account);
			// 如果有多个用户，则报错
			if (userList == null || userList.size() != 1) {
				throw new UsersException("账号不正确！");
			}
			return userList.get(0);
		} else {
			throw new UsersException("账号不正确！");
		}
	}

	/**
	 * 发送手机验证码
	 */
	@Override
	@Transactional(rollbackFor = UsersException.class)
	final public String sendTelVerifyCodeService(String userTel) throws Exception {
		// 验证手机号格式
		if (!Regx.regxTelphone(userTel))
			throw new UsersException("手机号格式不正确!");

		// 查询是否存在
		Integer count = usersMapper.selectByTelToCount(userTel);
		if (count != null && count > 0)
			throw new UsersException("手机号已注册！");

		// 生成验证码
		String verifyCode = Code.createVerifyCode(6, Code.VERIFY_CODE_TYPE_TEL);

		try {
			// 发送验证码
			Tel.sendTelCode(userTel, "您的验证码：" + verifyCode + "请勿将验证码泄露给他人！");
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsersException("验证码发送失败，系统异常，请稍后再试！");
		}

		// 返回验证码
		return verifyCode;
	}

	/**
	 * 发送登录验证码
	 */
	@Override
	@Transactional(rollbackFor = UsersException.class)
	final public String sendLoginVerifyCodeService(String account) throws Exception {
		// 生成验证码
		String verifyCode = null;
		// 判断是手机号还是邮箱
		if (Regx.regxTelphone(account)) {
			// 发送手机验证码

			// 查询手机号是否存在
			Integer count = usersMapper.selectByTelToCount(account);
			if (count <= 0 || count == null) {
				throw new UsersException("该账号尚未注册，请先注册");
			}
			try {
				verifyCode = Code.createVerifyCode(6, Code.VERIFY_CODE_TYPE_TEL);
				// 发送验证码
				Tel.sendTelCode(account, "您的验证码：" + verifyCode + "请勿将验证码泄露给他人！");
			} catch (Exception e) {
				e.printStackTrace();
				throw new UsersException("验证码发送失败，系统异常，请稍后再试！");
			}
		} else if (Regx.regxEmail(account)) {
			// 发送邮箱验证码

			// 查询邮箱是否存在
			Integer count = usersMapper.selectByMailToCount(account);
			if (count <= 0 || count == null) {
				throw new UsersException("该账号尚未注册，请先注册");
			}
			try {
				verifyCode = Code.createVerifyCode(6, Code.VERIFY_CODE_TYPE_EMAIL);
				Object[] code = { verifyCode };
				MailUtils.sendMail(this.getClass(), account, code, "mail/user_sendMailCode.properties");
			} catch (Exception e) {
				e.printStackTrace();
				throw new UsersException("验证码发送失败，系统异常，请稍后再试！");
			}
		} else {
			throw new UsersException("账号不正确！");
		}
		return verifyCode;
	}

	/**
	 * 发送修改密码验证码
	 */
	@Override
	@Transactional(rollbackFor = UsersException.class)
	final public String sendAlterPwdCodeService(String account) throws Exception {
		return sendLoginVerifyCodeService(account);
	}

	/**
	 * 修改密码
	 */
	@Override
	@Transactional(rollbackFor = UsersException.class)
	final public void alterPasswordService(String account, String verifyCode, String sessionVerifyCode, CustomUsers info)
			throws Exception {
		//验证验证码
		if(!Regx.regxVerifCode(verifyCode, sessionVerifyCode))
			throw new UsersException("验证码输入错误！");
		
		final String password1 = info.getUserPassword(); //新密码
		final String password2 = info.getUserPassword2();	//确认密码
		
		//验证新密码格式
		if(!Regx.regxPassword(password1))
			throw new UsersException("新密码格式错误，6-18位！");
		
		//验证两次输入的密码是否一致
		if(!password1.equals(password2))
			throw new UsersException("两次输入的密码不一致！");
		
		//加密
		String password = MD5.parseMD5(password1);
		
		if(Regx.regxTelphone(account)) {
			//是手机号修改
			usersMapper.updatePwdByTel(account,password);
		}else if(Regx.regxEmail(account)){
			usersMapper.updatePwdByEmail(account,password);
		}
	}

}
