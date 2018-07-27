package com.test.demo.bean;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.springframework.context.annotation.Bean;

import com.test.demo.spi.IClient;

public class Beans {
	
	@Bean
	public IClient smsSend() {
		ServiceLoader<IClient> spis=ServiceLoader.load(IClient.class);
		IClient sms=null;
		Iterator<IClient> iter=spis.iterator();
		while(iter.hasNext()) {
			sms=iter.next();
		}
		return sms;
		
	}

}
