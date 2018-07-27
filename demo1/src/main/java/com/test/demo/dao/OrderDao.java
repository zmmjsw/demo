package com.test.demo.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.demo.entity.Order;

/**
 * 
* @ClassName: MerchantDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年6月1日 下午3:21:55 
*
 */
@Repository
public interface OrderDao extends JpaRepository<Order,Long>{

	

}
