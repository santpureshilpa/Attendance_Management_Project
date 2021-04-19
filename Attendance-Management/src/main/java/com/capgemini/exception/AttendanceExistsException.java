package com.capgemini.exception;

//Exception If providing attendance is already present in the database
public class AttendanceExistsException extends Exception{
	
	public AttendanceExistsException(String message) {
		super(message);
	}

}
