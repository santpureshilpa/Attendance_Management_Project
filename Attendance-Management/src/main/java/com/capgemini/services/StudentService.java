package com.capgemini.services;

import java.util.List;

import com.capgemini.entity.StudentEntity;
import com.capgemini.exception.CourseIdNotFoundException;
import com.capgemini.exception.DuplicateRecordException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.StudentNotFoundException;

public interface StudentService {
	
    //To get the students using studentID
	StudentEntity getStudentById(int studentId) throws StudentNotFoundException;

	//To get the list of students present in the database
	List<StudentEntity> getStudents() throws RecordNotFoundException;
	
	//To update the student using studentID
	StudentEntity updateStudent(int studentId, StudentEntity entity) throws StudentNotFoundException;

	//To delete the student from the database using studentID
	String deleteStudent(int studentId) throws RecordNotFoundException;	
	
	//To add the student using courseID
	StudentEntity addStudentwithC(StudentEntity entity, int courseId)throws CourseIdNotFoundException, DuplicateRecordException;
	
	//To get the list of students by firstname
	List<StudentEntity> findStudentByFirstName(String firstName)throws StudentNotFoundException;
	
	//To get the list of students by firstname and lastname
	List<StudentEntity> findStudentByFirstNameAndLastName(String firstName,String lastName)throws StudentNotFoundException;

	boolean getStudentExistById(int studentId);
	

}