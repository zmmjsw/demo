package com.test.demo.test;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.test.demo.entity.Order;

public class test2 {
	public static void main(String[] args) {
		Map<String,Object> mao=new HashMap<String,Object>();
		mao.put("deliveryTime","123");
		mao.put("routeName","123");
		Order parseMap2Object = mapParseObject(mao,Order.class);
		System.out.println(parseMap2Object.toString());
	}
	
	public static <T> T mapParseObject(Map<String, Object> paramMap, Class<T> cls) {
		return JSONObject.parseObject(JSONObject.toJSONString(paramMap), cls);
	}
}
