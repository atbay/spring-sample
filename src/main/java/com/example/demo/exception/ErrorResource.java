package com.example.demo.exception;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResource implements Serializable {

	private final Long timestamp = new Date().getTime();
	private Integer status = -1;
	private String error;
	private String code;
	private String message;
	private String path;
	private String method;

	ErrorResource() {
	}

	ErrorResource(Integer status, String error, String message, String path, String method) {
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
		this.method = method;
	}

	ErrorResource(Exception e) {
		this.message = e.getMessage();
	}

	public static ErrorResource getInstance() {
		return new ErrorResource();
	}

	public static ErrorResource getInstance(Integer status, String error, String message, String path) {
		return new ErrorResource(status, error, message, path, null);
	}

	public static ErrorResource getInstance(Integer status, String error, String message, String path, String method) {
		return new ErrorResource(status, error, message, path, method);
	}

	public static ErrorResource getInstance(Exception e) {
		return new ErrorResource(e);
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

}
