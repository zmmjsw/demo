package com.test.demo.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask {
	 @Scheduled(cron="0/2 * * * * ?")
	private void GetdestinationTractNo() {
		System.out.println("哈哈"+new Date());
		try {
			Thread.sleep(1000*4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("呵呵"+new Date());
	}
	 

}
