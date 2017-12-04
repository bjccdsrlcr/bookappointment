package com.bjccdsrlcr.appoint.exception;

/**
 * Author: bjccdsrlcr
 * Date: 2017/11/30 0030
 * Time: 16:25
 */
public class AppointException extends RuntimeException{
    public AppointException(String message) {
		super(message);
	}

	public AppointException(String message, Throwable cause) {
		super(message, cause);
	}
}
