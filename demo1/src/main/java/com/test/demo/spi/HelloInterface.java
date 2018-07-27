package com.test.demo.spi;


public interface HelloInterface {
	public void sayHello();
	
	default public String getFullName() {
		try {
			return "da jia yi qi xue mao jiao";
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"No peer/service definition for " + getClass().getName());
		}
	}

}
