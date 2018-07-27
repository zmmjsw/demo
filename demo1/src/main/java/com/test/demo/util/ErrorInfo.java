package com.test.demo.util;
/**
 * 
* @ClassName: ErrorInfo 
* @Description: TODO(错误状态) 
* @author zhumingming 
* @date 2017年12月7日 下午6:24:10 
* 
* @param <T>
 */
public class ErrorInfo {
	public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    private Integer code;
    private String message;
    private String url;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ErrorInfo(Integer code, String message, String url) {
		super();
		this.code = code;
		this.message = message;
		this.url = url;
	}
	
	
    



}
