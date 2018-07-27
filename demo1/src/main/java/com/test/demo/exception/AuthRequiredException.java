package com.test.demo.exception;


public class AuthRequiredException extends Exception {

	private static final long serialVersionUID = 8542167522436023077L;

	public AuthRequiredException(String message) {
		super(message);
	}


}
