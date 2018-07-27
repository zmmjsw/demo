package com.test.demo.test;


import javax.persistence.*;

import com.google.common.collect.Lists;

import java.util.Date;
import java.util.List;

@Entity
public class Order  extends BaseOrder{


	@Column(name = "ISSUE_DATE_TIME")
	private Date issueDateTime;

	@Column(name = "ISSUE_REFUSE_REASON")
	private String issueRefuseReason;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estimatedOrder", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderCharge> estimatedCharges = Lists.newArrayList();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderCharge> charges = Lists.newArrayList();

	private String paidCancelReason;//客户付款取消原因

	private String bookingRejectReson;//供应商付款取消原因

	public Date getIssueDateTime() {
		return issueDateTime;
	}

	public void setIssueDateTime(Date issueDateTime) {
		this.issueDateTime = issueDateTime;
	}

	public String getIssueRefuseReason() {
		return issueRefuseReason;
	}

	public void setIssueRefuseReason(String issueRefuseReason) {
		this.issueRefuseReason = issueRefuseReason;
	}

	public List<OrderCharge> getEstimatedCharges() {
		return estimatedCharges;
	}

	public void setEstimatedCharges(List<OrderCharge> estimatedCharges) {
		this.estimatedCharges = estimatedCharges;
	}

	public List<OrderCharge> getCharges() {
		return charges;
	}

	public void setCharges(List<OrderCharge> charges) {
		this.charges = charges;
	}

	public String getPaidCancelReason() {
		return paidCancelReason;
	}

	public void setPaidCancelReason(String paidCancelReason) {
		this.paidCancelReason = paidCancelReason;
	}

	public String getBookingRejectReson() {
		return bookingRejectReson;
	}

	public void setBookingRejectReson(String bookingRejectReson) {
		this.bookingRejectReson = bookingRejectReson;
	}
	
	
	
	
}
