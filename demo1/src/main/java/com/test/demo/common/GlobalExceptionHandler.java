package com.test.demo.common;


import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.test.demo.util.ErrorInfo;
import com.test.demo.util.ResponseStatusEnum;
import com.test.demo.util.ValidateUtility;

/**
 * 
 * @ClassName: GlobalExceptionHandler
 * @Description: TODO(全局异常统一处理)
 * @author zhumingming
 * @date 2017年12月7日 下午5:55:14
 *
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
	private Logger log = LoggerFactory.getLogger(this.getClass());


	/**
	 * 
	 * @Title: notFount
	 * @Description: TODO(拦截未知的运行时异常)
	 * @return ErrorInfo 返回类型
	 */
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorInfo notFount(RuntimeException e, HttpServletRequest req) {
		log.error("运行时异常:", e);
		log.info("错误接口" + req.getRequestURL().toString() + "--------错误信息" + e.getMessage());
		return new ErrorInfo(ResponseStatusEnum.ERROR.getCode(), ResponseStatusEnum.ERROR.getMessage(),
				req.getRequestURL().toString());
	}

	/**
	 * 
	 * @Title: notFount2
	 * @Description: TODO(拦截参数错误异常)
	 * @return ErrorInfo 返回类型
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorInfo notFount2(MethodArgumentNotValidException e, HttpServletRequest req) {
		log.error("参数异常:", e);
		log.info("错误接口" + req.getRequestURL().toString() + "--------错误信息" + e.getMessage());
		String judgeValidate = ValidateUtility.judgeValidate(e.getBindingResult());
		return new ErrorInfo(ResponseStatusEnum.NOT_VALID.getCode(), ResponseStatusEnum.NOT_VALID.getMessage()+judgeValidate, req.getRequestURL().toString());
	}

}
