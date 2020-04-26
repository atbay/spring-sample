package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends BizException {

	private HttpStatus status;

	public ApiException() {
		super();
	}

	public ApiException(String message) {
		super(message);
		this.message = message;
	}

	public ApiException(String message, HttpStatus status) {
		super(message);
		this.message = message;
		this.status = status;
	}

	public ApiException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
		this.cause = cause;
	}

	public ApiException(String message, Throwable cause, HttpStatus status) {
		super(message);
		this.message = message;
		this.status = status;
	}

	public ApiException(Throwable cause) {
		super(cause);
		this.cause = cause;
	}

	public HttpStatus getStatus() {
		return this.status;
	}

}
