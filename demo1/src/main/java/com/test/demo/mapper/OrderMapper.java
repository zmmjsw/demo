package com.test.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.test.demo.entity.Order;
import com.test.demo.plugin.BaseMapper;

/**
 * 
* @ClassName: MerchantMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年6月4日 下午3:02:05 
*
 */

@Mapper
public interface OrderMapper extends BaseMapper<Order>{

}
