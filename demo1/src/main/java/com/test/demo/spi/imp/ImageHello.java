package com.test.demo.spi.imp;

import org.springframework.stereotype.Component;

import com.test.demo.spi.HelloInterface;
@Component("ImageHello")
public class ImageHello implements HelloInterface{

	@Override
	public void sayHello() {
        System.out.println("Image Hello");		
	}

}
