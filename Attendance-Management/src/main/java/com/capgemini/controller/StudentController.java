package com.capgemini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.StudentEntity;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.StudentNotFoundException;
import com.capgemini.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/get/{studentId}")
	public ResponseEntity<StudentEntity> getStudentById(@Valid @PathVariable int studentId) throws StudentNotFoundException
	{
		return new ResponseEntity<StudentEntity>(studentService.getStudentById(studentId),HttpStatus.FOUND);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<StudentEntity>> getStudents()
	{
		return new ResponseEntity<List<StudentEntity>>(studentService.getStudents(),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<StudentEntity> addStudent(@Valid @RequestBody StudentEntity entity)
	{
		return new ResponseEntity<StudentEntity>(studentService.addStudent(entity),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{studentId}")
	public ResponseEntity<StudentEntity> updateStudent(@Valid @PathVariable int studentId, @Valid @RequestBody StudentEntity entity) throws StudentNotFoundException
	{
		return new ResponseEntity<StudentEntity>(studentService.updateStudent(studentId, entity),HttpStatus.ACCEPTED);
	}
	

	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<String> deleteStudent(@Valid @PathVariable int studentId) throws RecordNotFoundException
	{
		return new ResponseEntity<String>(studentService.deleteStudent(studentId),HttpStatus.ACCEPTED);
	}


}