package com.cg.bookstore.exception;

public class AuthenticationFailureException extends RuntimeException{
	public AuthenticationFailureException(String msg) {
		super(msg);
	}

}
