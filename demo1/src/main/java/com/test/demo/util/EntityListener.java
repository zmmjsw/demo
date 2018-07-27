package com.test.demo.util;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.StringUtils;

import com.test.demo.entity.BastEntity;


/**
 * 
* @ClassName: EntityListener 
* @Description: TODO(jpa创建人修改人) 
* @author zhumingming 
* @date 2018年6月21日 上午10:41:16 
*
 */
public class EntityListener extends AuditingEntityListener {

	/**
	 * 
	* @Title: onPrePersist 
	* @Description: TODO(创建时添加用户信息) 
	* @return void    返回类型
	 */
	@PrePersist
	public void onPrePersist(BastEntity o) {
		String name="朱明明";
		o.setCreateTime(new Date());
		o.setUpdateTime(new Date());
		if (StringUtils.isEmpty(o.getCreatedBy())) {
			o.setCreatedBy(name);
		}
		if (StringUtils.isEmpty(o.getUpdatedBy())) {
			o.setUpdatedBy(name);
		}
	}
   
	/**
	 * 
	* @Title: onPreUpdate 
	* @Description: TODO(修改时添加用户信息) 
	* @return void    返回类型
	 */
	@PreUpdate
	public void onPreUpdate(BastEntity o) {
		String name="朱明明";
		o.setUpdateTime(new Date());
		if (!StringUtils.isEmpty(name)) {
			o.setUpdatedBy(name);
		}
	}

}
