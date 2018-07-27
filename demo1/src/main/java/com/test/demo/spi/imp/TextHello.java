package com.test.demo.spi.imp;

import org.springframework.stereotype.Component;

import com.test.demo.spi.HelloInterface;
@Component("TextHello")
public class TextHello implements HelloInterface{

	@Override
	public void sayHello() {
		System.out.println("TextHello");
		
	}

}
