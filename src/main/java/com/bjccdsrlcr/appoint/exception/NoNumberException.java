package com.bjccdsrlcr.appoint.exception;

/**
 * Author: bjccdsrlcr
 * Date: 2017/11/30 0030
 * Time: 16:26
 */
public class NoNumberException extends RuntimeException {
    public NoNumberException(String message) {
		super(message);
	}

	public NoNumberException(String message, Throwable cause) {
		super(message, cause);
	}

}
