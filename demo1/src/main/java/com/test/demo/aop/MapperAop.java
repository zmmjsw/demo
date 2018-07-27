package com.test.demo.aop;

import java.util.Date;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;
import com.github.pagehelper.util.StringUtil;

/**
 * 
 * @ClassName: MapperAop
 * @Description: TODO(切面编程，mapper注入创建人修改人)
 * @author zhumingming
 * @date 2018年6月21日 上午10:39:34
 *
 */
public class MapperAop {

	/**
	 * 
	 * @ClassName: OperateAspect
	 * @Description: TODO(添加的切面)
	 * @author zhumingming
	 * @date 2018年6月21日 上午10:40:25
	 *
	 */
	@Aspect
	@Component
	public class OperateAspect {
		@Pointcut("execution(public com.test.demo.mapper.*.save *(..))")
		public void saveEntity() {
		}

		@Before("saveEntity()")
		public void beforeSave(JoinPoint jp) throws Exception, Exception {
			// 这个参数从域里获取。为用户名
			String zz = "朱明明";
			Object[] args = jp.getArgs();
			if (args != null && args.length > 0) {
				Object argument = args[0];
				BeanWrapper beanWrapper = new BeanWrapperImpl(argument);
				// 设置创建时间和修改时间
				if (beanWrapper.isWritableProperty("createTime")) {
					beanWrapper.setPropertyValue("createTime", new Date());
				}
				if (beanWrapper.isWritableProperty("updateTime")) {
					beanWrapper.setPropertyValue("updateTime", new Date());
				}
				// 设置创建人和修改人
				if (beanWrapper.isWritableProperty("createdBy") && StringUtil.isNotEmpty(zz)) {
					beanWrapper.setPropertyValue("createdBy", zz);
				}
				if (beanWrapper.isWritableProperty("updatedBy") && StringUtil.isNotEmpty(zz)) {
					beanWrapper.setPropertyValue("updatedBy", zz);
				}
			}
			System.out.println("添加了");
		}

		/**
		 * 
		* @Title: updateEntity 
		* @Description: TODO(修改的切面) 
		* @return void    返回类型
		 */
		@Pointcut("execution(public com.test.demo.mapper.*.update *(..))")
		public void updateEntity() {
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Before("updateEntity()")
		public void beforeUpdate(JoinPoint jp) throws Exception, Exception {
			// 这个参数从域里获取。为用户名
			String privilegeInfo = "朱明明";
			Object[] args = jp.getArgs();
			// myBatis只能传递一个参数
			if (args != null && args.length > 0) {
				Object argument = args[0];
				// 如果argument是map类型
				if (argument instanceof Map) {
					Map map = (Map) argument;
					map.put("updateTime", new Date());
					if (privilegeInfo != null && StringUtil.isNotEmpty(privilegeInfo)) {
						map.put("updatedBy", privilegeInfo);
					}
				} else {
					BeanWrapper beanWrapper = new BeanWrapperImpl(argument);
					if (beanWrapper.isWritableProperty("updateTime")) {
						beanWrapper.setPropertyValue("updateTime", new Date());
					}
					if (beanWrapper.isWritableProperty("updatedBy") && StringUtil.isNotEmpty(privilegeInfo)) {
						beanWrapper.setPropertyValue("updatedBy", privilegeInfo);
					}
				}
			}
			System.out.println("修改了");
		}

	}
}