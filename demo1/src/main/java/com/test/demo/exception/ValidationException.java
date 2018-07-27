package com.test.demo.exception;

import org.slf4j.helpers.MessageFormatter;

/**
 * Created by wi on 2015/7/1.
 */
public class ValidationException extends RuntimeException {
	public ValidationException(String message, Object... arguments) {
		super(MessageFormatter.arrayFormat(message,arguments).getMessage());
	}
}
