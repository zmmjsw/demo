package com.test.demo.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="logger_infos")
public class LoggerEntity extends BastEntity{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -1123467680530915975L;
	
	private String clientIp;//客户端请求ip
	
	private String url;//客户请求路径
	private String type;//终端请求方式
	
	private String method;//请求方法
	
	private String paramDate;//请求参数内容 json
	
	private String sessionId;//请求接口唯一session标识
	
	private Date allTime;//请求时间
	
	private Date returnTime;//接口返回时间
	
	private String returnDate;//接口返回json

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getParamDate() {
		return paramDate;
	}

	public void setParamDate(String paramDate) {
		this.paramDate = paramDate;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}


	public Date getAllTime() {
		return allTime;
	}

	public void setAllTime(Date allTime) {
		this.allTime = allTime;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "LoggerEntity [clientIp=" + clientIp + ", url=" + url + ", type=" + type + ", method=" + method
				+ ", paramDate=" + paramDate + ", sessionId=" + sessionId + ", allTime=" + allTime + ", returnTime="
				+ returnTime + ", returnDate=" + returnDate + "]";
	}
	
	

}
