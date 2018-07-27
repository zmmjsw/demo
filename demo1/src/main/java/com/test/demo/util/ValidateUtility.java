package com.test.demo.util;

import java.util.List;


import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
/**
 * 
* @ClassName: ValidateUtility 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年7月10日 下午6:01:36 
*
 */
public class ValidateUtility {

	public static String judgeValidate(BindingResult result) {
			List<ObjectError> list = result.getAllErrors();
			StringBuilder stringBuilder = new StringBuilder();
			for (ObjectError error : list) {
				Object[] arguments = error.getArguments();
				DefaultMessageSourceResolvable de = (DefaultMessageSourceResolvable) arguments[0];
				String code = de.getCode();
				stringBuilder.append("/n" + error.getDefaultMessage() + "--错误列 : " + code);
			}
			return stringBuilder.toString();

	}

}
