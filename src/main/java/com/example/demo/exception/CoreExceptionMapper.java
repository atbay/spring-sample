package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;

import org.springframework.http.HttpStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoreExceptionMapper implements ExceptionMapper<Exception> {

	@Context
	private UriInfo info;

	@Context
	private HttpServletRequest servletRequest;

	@Override
	public Response toResponse(Exception exception) {
		String path = info.getPath();
		String method = servletRequest.getMethod();

		log.error("message", exception);
		ErrorResource body = ErrorResource.getInstance(exception);
		body.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		body.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		body.setPath(path);
		body.setMethod(method);
		return Response.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).entity(body)
				.type(MediaType.APPLICATION_JSON).build();
	}

}
