package com.test.demo.Interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.test.demo.dao.LoggerDao;
import com.test.demo.entity.LoggerEntity;
import com.test.demo.util.LoggerUtils;
import com.test.demo.util.SpringContextUtil;

public class LoggerInterceptor implements HandlerInterceptor {
	//请求开始时间标识
	private static final String LOGGER_SEND_TIME="_send_time";
	//请求实体标识
	private static final String LOGGER_ENTITY="_logger_entity";

	@SuppressWarnings("unused")
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) {
		LoggerEntity log = new LoggerEntity();
		log.setSessionId(request.getRequestedSessionId());
		log.setUrl(request.getRequestURI());
		String paramData = JSON.toJSONString(request.getParameterMap(),
				SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue);
		log.setParamDate(paramData);
		log.setClientIp(LoggerUtils.getClientIp(request));
		log.setMethod(request.getMethod());
		log.setAllTime(new Date());
		request.setAttribute(LOGGER_ENTITY,log);
		System.out.println(LoggerUtils.getIp(request));
		System.out.println(LoggerUtils.getLocalIp(request));
		return true;
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("************BaseInterceptor postHandle executed**********");
	}

	/**
	 * 在页面渲染完成返回给客户端之前执行
	 */
	@SuppressWarnings("unused")
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exc,ModelAndView modelAndView)
			throws Exception {
		System.out.println("************BaseInterceptor afterCompletion executed**********");
		//获取请求错误码
		int status=response.getStatus();
		LoggerEntity log=(LoggerEntity) request.getAttribute(LOGGER_ENTITY);
		log.setReturnTime(new Date());
		log.setReturnDate(LoggerUtils.httpRequest(log.getUrl(), log.getMethod()));
		LoggerDao dao=SpringContextUtil.getBean(LoggerDao.class,request);
		dao.save(log);
	}

}
