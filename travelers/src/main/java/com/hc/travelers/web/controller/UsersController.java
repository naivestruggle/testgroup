package com.hc.travelers.web.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hc.travelers.custombean.CustomUsers;
import com.hc.travelers.exception.UsersException;
import com.hc.travelers.service.interfaces.UsersService;

@Controller
final public class UsersController {
	@Resource
	private UsersService usersService;
	
	/**
	 * 注册
	 * @param sessionVerifyCode	系统发送的验证码
	 * @param verifyCode	用户输入的验证码
	 * @param registUser	注册信息
	 * @param session		会话对象
	 * @param response		响应对象
	 * @throws Exception
	 */
	@RequestMapping(value="regist",produces="text/html;charset=UTF-8")
	private final void regist(String verifyCode,CustomUsers registUser,HttpSession session,HttpServletResponse response)throws Exception{
		final String userTel = registUser.getUserTel();
		response.setContentType("text/html;charset=utf-8");
		final String sessionVerifyCode = (String)session.getAttribute(userTel+ "sessionRegistVerifyCode");
		try {
			//注册
			final CustomUsers user = usersService.registService(registUser, verifyCode, sessionVerifyCode);
			//清空验证码
			session.removeAttribute(userTel+ "sessionRegistVerifyCode");
			//登录
			session.setAttribute("loginedUser", user);
			//响应结果
			response.getWriter().append("ok");
		} catch (Exception e) {
			disposeException(response, e);
		}
	}
	/**
	 * 用户登录
	 * @param account 手机号或邮箱
	 * @param verifyCode 验证码
	 * @param session
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("login")
	private void login(String account,String verifyCode,HttpSession session,HttpServletResponse response) throws IOException {
//		System.out.println("account = " + account);
//		System.out.println("verifyCode = " + verifyCode);
		response.setCharacterEncoding("utf-8");
		//得到系统生成的验证码
		final String sessionVerifyCode = (String) session.getAttribute(account + "sessionLoginVerifyCode");
		try {
			//登录
			final CustomUsers user = usersService.loginService(account,verifyCode,sessionVerifyCode);
			//清空验证码
			session.removeAttribute(account + "sessionLoginVerifyCode");
			//将用户信息存入session
			session.setAttribute("loginedUser", user);
			//响应结果
			response.getWriter().append("ok");
			
		} catch (Exception e) {
			disposeException(response, e);
		}
		
	}
	
	/**
	 * 修改密码
	 * @param account	手机号/邮箱地址
	 * @param verifyCode	用户输入的验证码
	 * @param info	用户对象（里面有 新密码 和 确认密码）
	 * @param session	会话对象
	 * @param response	响应对象
	 * @throws Exception
	 */
	@RequestMapping("alterPassword")
	private void alterPassword(String account,String verifyCode,CustomUsers info,HttpSession session,HttpServletResponse response)throws Exception {
		response.setCharacterEncoding("utf-8");
		//得到系统生成的验证码
		final String sessionVerifyCode = (String) session.getAttribute(account + "sessionAlterPwdVerifyCode");
		try {
			//修改密码
			usersService.alterPasswordService(account,verifyCode,sessionVerifyCode,info);
			
			//修改成功后   将当前登录用户清空
			session.removeAttribute("loginedUser");
			
			response.getWriter().append("ok");
		} catch (Exception e) {
			disposeException(response, e);
		}
	}
	
	
	/**
	 * 发送登录验证码
	 * @param account 手机号或邮箱
	 * @param session
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("sendLoginVerifyCode")
	private final void sendLoginVerifyCode(String account,HttpSession session,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		try {
			final String verifyCode = usersService.sendLoginVerifyCodeService(account);
			
			//将验证码保存到session域
			session.setAttribute(account + "sessionLoginVerifyCode", verifyCode);
			response.getWriter().append("ok");
		} catch (Exception e) {
			disposeException(response, e);
		}
		
	}
	
	/**
	 * 发送注册验证码
	 * @param userTel	手机号
	 * @param session	会话对象
	 * @param response	响应对象
	 * @throws Exception
	 */
	@RequestMapping(value="sendRegistVerifyCode")
	private final void sendRegistVerifyCode(String userTel,HttpSession session,HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		try {
			//发送验证码
			final String verifyCode = usersService.sendTelVerifyCodeService(userTel);
//			将发送成功的验证码保存到cookie中
//			Cookie cookie = new Cookie(userTel+"cookieVerifyCode",verifyCode);	//创建cookie
//			cookie.setMaxAge(60*10);		//设置cookie有效时间为10分钟
//			response.addCookie(cookie);	//添加cookie
			
			//将验证码保存到session中
			session.setAttribute(userTel+"sessionRegistVerifyCode", verifyCode);
			response.getWriter().append("ok");
		} catch (Exception e) {
			disposeException(response, e);
		}
	}
	
	/**
	 * 发送修改密码验证码
	 * @param account	手机号/邮箱
	 * @param session	会话对象
	 * @param response	响应对象
	 * @throws Exception 
	 */
	@RequestMapping("sendAlterPwdCode")
	private final void sendAlterPwdCode(String account,HttpSession session,HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=utf-8");
		try {
			final String verify = usersService.sendAlterPwdCodeService(account);
			//将验证码保存到session中
			session.setAttribute(account+"sessionAlterPwdVerifyCode", verify);
			response.getWriter().append("ok");
		} catch (Exception e) {
			disposeException(response, e);
		}
	}
	
	/**
	 * 处理异常
	 * @param response	响应对象
	 * @param e	异常对象
	 * @throws IOException
	 */
	private final void disposeException(HttpServletResponse response, Exception e) throws IOException {
		e.printStackTrace();
		if(e instanceof UsersException){
			//是自定义的业务异常
			response.getWriter().append(e.getMessage());
		}else{
			//不是自定义的业务异常
			response.getWriter().append("系统繁忙，请稍后再试！");
		}
	}
}
