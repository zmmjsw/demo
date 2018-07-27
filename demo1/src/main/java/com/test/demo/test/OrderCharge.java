package com.test.demo.test;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class OrderCharge extends AggregateRoot {

	public static final String POL = "起运地";
	public static final String POD = "目的地";
	public static final String SHIPPING = "海运段";
	public static final int DEFUALT_QTY = 1;
	private Order order;
	
	private BigDecimal  Price;
	

	private BigDecimal matchedAmount; 

	private BigDecimal outstandingAmount;

	private Order estimatedOrder;

	private long id;


	private ChargeStatus status;


	public BigDecimal getPrice() {
		return Price;
	}

	public void setPrice(BigDecimal price) {
		Price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public BigDecimal getMatchedAmount() {
		return matchedAmount;
	}

	public void setMatchedAmount(BigDecimal matchedAmount) {
		this.matchedAmount = matchedAmount;
	}

	public BigDecimal getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(BigDecimal outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public Order getEstimatedOrder() {
		return estimatedOrder;
	}

	public void setEstimatedOrder(Order estimatedOrder) {
		this.estimatedOrder = estimatedOrder;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ChargeStatus getStatus() {
		return status;
	}

	public void setStatus(ChargeStatus status) {
		this.status = status;
	}
	private BigDecimal  qty;

	public Object getQty() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}



}
