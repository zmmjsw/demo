package com.test.demo.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) {
		System.out.println(request.getRequestURI());
		System.out.println("hehe++++++++++");
		return true;
	}
	
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("************BaseInterceptor postHandle executed**********");
	}
	
	/**
	 * 在页面渲染完成返回给客户端之前执行
	 * */
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("************BaseInterceptor afterCompletion executed**********");
	}


}
