package com.test.demo.exception;

public class TransformException extends Exception {

	private static final long serialVersionUID = 476643084440446800L;

	public TransformException() {
		super();
	}

	public TransformException(String message) {
		super(message);
	}

	public TransformException(String message, Throwable cause) {
		super(message, cause);
	}

}
