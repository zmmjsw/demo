package com.test.demo.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.demo.entity.MerchantCondition;
import com.test.demo.properties.HelloService;
import com.test.demo.service.OrderService;
import com.test.demo.spi.HelloInterface;
import com.test.demo.spi.IClient;
import com.test.demo.util.SpringContextUtil;

import io.swagger.annotations.Api;

@Api("测试")
@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private HelloService helloService;
	
	
	@Autowired
	@Qualifier("HelloIStableClient")
	private IClient clent;
	
	
	private static final Map<String, HelloInterface> clients = new ConcurrentHashMap<>();
	private static final Map<String, IClient> clientss = new ConcurrentHashMap<>();
	@RequestMapping(value = "/api/test", method = RequestMethod.POST)
	@ResponseBody
	public String Test(@Valid @RequestBody MerchantCondition vo) {
		ApplicationContext ctx = SpringContextUtil.getApplicationContext();
		Map<String, HelloInterface> configuredClients = ctx.getBeansOfType(HelloInterface.class, false, true);
		for (Map.Entry<String, HelloInterface> clientEntry : configuredClients.entrySet()) {
			HelloInterface client = clientEntry.getValue();
			String serviceName = client.getFullName();
			System.err.println("Register client service: " + serviceName);
			clients.put(serviceName, client);
		}
		System.out.println(clients.toString());
		
		
		Map<String, IClient> conf = ctx.getBeansOfType(IClient.class, false, true);
		for (Map.Entry<String, IClient> clientEntry : conf.entrySet()) {
			IClient client = clientEntry.getValue();
			String serviceName = client.getName();
			System.err.println("Register client service: " + serviceName);
			clientss.put(serviceName, client);
		}
		System.out.println(clientss.toString());
		
		
		System.out.println(clent.getName());
		
		System.out.println(helloService.sayHello());
		
		return "helloword";
	}

}
