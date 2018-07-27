package com.test.demo.exception;

public class FailureException extends Exception {
	private static final long serialVersionUID = 7102958594556887409L;

	public FailureException() {
		super();
	}

	public FailureException(String message) {
		super(message);
	}

	public FailureException(String message, Throwable cause) {
		super(message, cause);
	}
}
