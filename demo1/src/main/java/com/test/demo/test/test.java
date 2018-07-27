package com.test.demo.test;

import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.test.demo.spi.HelloInterface;

@SpringBootApplication
public class test  {
	
	private static final Map<String, HelloInterface> clients = new ConcurrentHashMap<>();
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(test.class, args);
		Map<String, HelloInterface> configuredClients = ctx.getBeansOfType(HelloInterface.class, false, true);
		for (Map.Entry<String, HelloInterface> clientEntry : configuredClients.entrySet()) {
			HelloInterface client = clientEntry.getValue();
			String serviceName = client.getFullName();
			System.err.println("Register client service: " + serviceName);
			clients.put(serviceName, client);
		}
		
		
		ServiceLoader<HelloInterface> loaders = ServiceLoader.load(HelloInterface.class);

	        for (HelloInterface in : loaders) {
	            in.sayHello();
	        }
		
	}
   

}
