package com.capgemini.services;

import java.util.List;

import javax.validation.Valid;

import com.capgemini.entity.CourseEntity;
import com.capgemini.exception.CourseIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;

public interface CourseService {
	
	//For adding the courses one by one
    public CourseEntity addCourse(CourseEntity entity) ;
	
    //For getting the details of all the courses present in the database
    public List<CourseEntity> getCourse() throws RecordNotFoundException;
    
    //For getting the details of the course by Course ID
    public CourseEntity getCourseById(int courseId) throws CourseIdNotFoundException;
    
    //For updating the details of the courses By Course ID
    public CourseEntity updateByCourseId(int courseid, CourseEntity entity) throws CourseIdNotFoundException;
     
    //For deleting records of Course by Course ID
    public String deleteByCourseId(int courseId) throws RecordNotFoundException;
    
    //For getting the details of course by Course name
    public List<CourseEntity> findCourseByName(String courseName) throws RecordNotFoundException;

	public boolean getCourseExistById(int courseId);

}

