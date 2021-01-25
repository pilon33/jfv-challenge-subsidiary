package com.subsidiary.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResouceNotFoundException extends RuntimeException {

	public ResouceNotFoundException(String message) {
		super(message);
	}

	public ResouceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
