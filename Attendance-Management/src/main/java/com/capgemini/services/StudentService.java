package com.capgemini.services;

import java.util.List;

import com.capgemini.entity.StudentEntity;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.StudentNotFoundException;

public interface StudentService {

	public StudentEntity getStudentById(int id) throws StudentNotFoundException;

	public List<StudentEntity> getStudents();
	
	public StudentEntity addStudent(StudentEntity entity);

	public StudentEntity updateStudent(StudentEntity entity);

	public String deleteStudent(int id) throws RecordNotFoundException;

	public String deleteRecord(StudentEntity e);
	
	

}
