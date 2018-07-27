package com.test.demo.entity;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;


/**
 * 
* @ClassName: MerchantConditionVo 
* @Description: TODO(Merchant条件) 
* @author zhumingming 
* @date 2018年6月4日 下午4:21:27 
*
 */
public class MerchantCondition {
	
	@NotEmpty(message = "名字不能为空")
	private String name;
	
	@Range(min=0, max=2,message = "年龄范围0-2")
	private Integer age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	

}
