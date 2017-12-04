package com.bjccdsrlcr.appoint.exception;

/**
 * Author: bjccdsrlcr
 * Date: 2017/11/30 0030
 * Time: 16:26
 */
public class RepeatAppoint extends RuntimeException {
    public RepeatAppoint(String message) {
		super(message);
	}

	public RepeatAppoint(String message, Throwable cause) {
		super(message, cause);
	}
}
