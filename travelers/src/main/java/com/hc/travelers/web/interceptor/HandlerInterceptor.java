package com.hc.travelers.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器测试
 * springmvc配置类似全局的拦截器，spingmvc框架将配置的类似全局的拦截器注入到每个HandlerMapper中
 * @author Administrator
 *
 */
public class HandlerInterceptor implements org.springframework.web.servlet.HandlerInterceptor{

	//进入Handler之前执行
	//用于身份认证，身份授权
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
//		return false;	//拦截
		// TODO Auto-generated method stub
		
		//放行
		return org.springframework.web.servlet.HandlerInterceptor.super.preHandle(request, response, handler);
	}

	//进入Handler之后  在返回ModelAndView之前执行
	//将一些公用的资源  在这个方法中传入 modelAndView   比如菜单导航
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		org.springframework.web.servlet.HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	//在进入Handler之后执行
	//可以进行统一的异常处理   进行筒体的日志处理
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		org.springframework.web.servlet.HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
