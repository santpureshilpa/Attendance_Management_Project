package com.capgemini.exception;

//Exception if Given Course Id Is NOt Present In The Database
public class CourseIdNotFoundException extends Exception{
	public CourseIdNotFoundException(String msg) {
		super(msg);
	}


}
