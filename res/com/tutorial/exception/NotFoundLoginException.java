package com.tutorial.exception;

public class NotFoundLoginException extends Exception {

	public NotFoundLoginException() {
		super("아이디 또는 패스워드가 올바르지 않습니다");
	}
	
}
