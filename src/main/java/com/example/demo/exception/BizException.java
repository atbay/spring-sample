package com.example.demo.exception;

public class BizException extends BaseException {

	public BizException() {
		super();
	}

	public BizException(String message) {
		super(message);
		this.message = message;
	}

	public BizException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
		this.cause = cause;
	}

	public BizException(Throwable cause) {
		super(cause);
		this.cause = cause;
	}
}
