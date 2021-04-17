package com.capgemini.services;

import java.util.List;

import com.capgemini.entity.StudentEntity;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.StudentNotFoundException;

public interface StudentService {

	public StudentEntity getStudentById(int studentId) throws StudentNotFoundException;

	public List<StudentEntity> getStudents();
	
	public StudentEntity addStudent(StudentEntity entity);

	public StudentEntity updateStudent(int studentId, StudentEntity entity) throws StudentNotFoundException;

	public String deleteStudent(int studentId) throws RecordNotFoundException;	

}