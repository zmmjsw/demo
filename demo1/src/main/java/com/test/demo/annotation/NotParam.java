package com.test.demo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import com.test.demo.annotation.validator.NotParamValidator;
/**
 * 
* @ClassName: NotParam 
* @Description: TODO(标注属性不能为空和空字符窜和空格) 
* @author zhumingming 
* @date 2018年7月10日 下午2:33:11 
*
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=NotParamValidator.class)
@Documented
public @interface NotParam {
	String message() default "{com.baili.pms.annotation.NotParam.message}";
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

	

}
