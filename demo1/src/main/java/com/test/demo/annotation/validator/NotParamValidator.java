package com.test.demo.annotation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.test.demo.annotation.NotParam;
/**
 * 
* @ClassName: NotParamValidator 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年7月10日 下午2:34:04 
*
 */
public class NotParamValidator implements ConstraintValidator<NotParam, String>{
	@SuppressWarnings("unused")
	private String value;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if("".equals(value)||value==null) {
			return false;
		}
		value=	value.replace(" ", "");//去除空格
		if("".equals(value)||value==null) {
			return false;
		}
		return true;
	}
	
	@Override
	public void initialize(NotParam param) {
		this.value=param.message();
	}

}
