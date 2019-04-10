package com.hc.travelers.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		final String sessionVerifyCode = (String)session.getAttribute(userTel+ "sessionVerifyCode");
		try {
			//注册
			final CustomUsers user = usersService.regist(registUser, verifyCode, sessionVerifyCode);
			//清空验证码
			session.removeAttribute(userTel+ "sessionVerifyCode");
			//登录
			session.setAttribute("loginedUser", user);
			//响应结果
			response.getWriter().append("ok");
		} catch (Exception e) {
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
	
	@RequestMapping("login")
	private final void login(CustomUsers loginedUser,HttpServletResponse response){
		
	}
	
	@RequestMapping(value="sendVerifyCode")
	private final void sendVerifyCode(String userTel,HttpSession session,HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		try {
			//发送验证码
			String verifyCode = usersService.sendTelVerifyCode(userTel);
//			将发送成功的验证码保存到cookie中
//			Cookie cookie = new Cookie(userTel+"cookieVerifyCode",verifyCode);	//创建cookie
//			cookie.setMaxAge(60*10);		//设置cookie有效时间为10分钟
//			response.addCookie(cookie);	//添加cookie
			
			//将验证码保存到session中
			session.setAttribute(userTel+"sessionVerifyCode", verifyCode);
			response.getWriter().append("ok");
		} catch (Exception e) {
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
}
