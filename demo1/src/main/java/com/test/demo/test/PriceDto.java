package com.test.demo.test;

import java.math.BigDecimal;


public class PriceDto   {

	private String currency;
	private BigDecimal totalPrice;
	
	private BigDecimal tpy;
	
	

	public BigDecimal getTpy() {
		return tpy;
	}

	public void setTpy(BigDecimal tpy) {
		this.tpy = tpy;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
}
