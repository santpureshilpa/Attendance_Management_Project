package com.capgemini.exception;

//Exception if Given Attendance Id Is NOt Present In The Database
public class AttendanceIdNotFoundException extends Exception{
	public AttendanceIdNotFoundException(String msg) {
		super(msg);
	}

}
