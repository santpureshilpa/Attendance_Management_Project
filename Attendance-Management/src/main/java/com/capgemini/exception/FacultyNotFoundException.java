package com.capgemini.exception;

public class FacultyNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public FacultyNotFoundException(String msg) {
		super(msg);
	}

}