package com.shiro.exception;

import org.apache.shiro.authc.AuthenticationException;

public class NoUserException extends AuthenticationException{

	public NoUserException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoUserException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoUserException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoUserException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
