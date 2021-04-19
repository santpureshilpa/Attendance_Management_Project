package com.capgemini.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.SubjectEntity;
import com.capgemini.exception.CourseIdNotFoundException;
import com.capgemini.exception.DuplicateRecordException;
import com.capgemini.exception.FacultyIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.SubjectNotFoundException;
import com.capgemini.services.*;
import com.capgemini.services.SubjectService;

@RestController
@RequestMapping("/Subject")
public class SubjectController {
	
	@Autowired
	SubjectService subjectService;
	
	//Add Subject Details
	@PostMapping(path="/addSubject") 
	public ResponseEntity<SubjectEntity> addSubject(@Valid @RequestBody SubjectEntity se) throws DuplicateRecordException 
	{
		SubjectEntity se1 = subjectService.addSubject(se);
		return new ResponseEntity<SubjectEntity>(se1,HttpStatus.OK);
	}
	
	//Update Subject Details By using Student ID
	@PutMapping(path="/updateSubjectById/{subjectId}")
	public ResponseEntity<SubjectEntity> updateSubjectById(@Valid @PathVariable int subjectId, @Valid @RequestBody SubjectEntity fe)
	      throws SubjectNotFoundException
	{
		SubjectEntity se = subjectService.updateSubjectById(subjectId, fe);
		ResponseEntity re = new ResponseEntity<SubjectEntity>(se, HttpStatus.OK);
		return re;
	}
	
	//Retrieve Subject Details By using Subject ID
	@GetMapping(path="/getSubjectById/{subjectId}") 
	public ResponseEntity <SubjectEntity> getSubjectById(@PathVariable int subjectId) throws SubjectNotFoundException
	{
		SubjectEntity se = subjectService.getSubjectById(subjectId);
		return new ResponseEntity<SubjectEntity>(se, HttpStatus.OK);
	}
	
	//Retrieve All Details of Subjects
	@GetMapping(path="/getAllSubjects")
	public ResponseEntity<List<SubjectEntity>> getAllSubjects() throws RecordNotFoundException
	{		
		List<SubjectEntity> se = subjectService.getAllSubjects();
		ResponseEntity re = new ResponseEntity<List<SubjectEntity>>(se, HttpStatus.OK);
		return re;
		
	}	
	
	//Retrieve List of Subjects
    @GetMapping(path="/getSubjectsByName/{subjectName}") 
	 public ResponseEntity<List<SubjectEntity>> findSubjectByName(@PathVariable String subjectName)
	         throws RecordNotFoundException
     {
		  List<SubjectEntity> se=subjectService.findSubjectByName(subjectName);
		  ResponseEntity<List<SubjectEntity>> re=new ResponseEntity<List<SubjectEntity>>(se,HttpStatus.FOUND);
		  return re;
	 
	  }
	 
    //Delete subjects details by subject id
	@DeleteMapping(path="/deleteSubject/{subjectId}")
	public ResponseEntity<String> deleteSubById(@Valid @PathVariable int subjectId) throws RecordNotFoundException
	{
		subjectService.deleteSubById(subjectId);
		return new ResponseEntity<String>("Deleted",HttpStatus.OK);
	}
	
	//Add Subject details with respect to Faculty Id & Course Id
	@PostMapping(path="/addSubjectwithFC/{facultyId}/{courseId}") 
	public ResponseEntity<SubjectEntity> addSubjectwithFC(@Valid @RequestBody SubjectEntity entity, @Valid @PathVariable int facultyId,@Valid @PathVariable int courseId) throws FacultyIdNotFoundException,CourseIdNotFoundException, DuplicateRecordException
	{
		SubjectEntity se1 = subjectService.addSubjectwithFC(entity,facultyId,courseId);
		
		return new ResponseEntity<SubjectEntity>(se1,HttpStatus.OK);
	}
	
	//Retrieve Subject details by semester
	@GetMapping(path="/getSubjectsBySemester/{subjectSemester}") 
	public ResponseEntity<List<SubjectEntity>> findSubjectBySemester(String subjectSemester) 
			throws RecordNotFoundException
	 { 
		  List<SubjectEntity>se=subjectService.findSubjectBySemester(subjectSemester); 
		  ResponseEntity re=new ResponseEntity<List<SubjectEntity>>(se,HttpStatus.FOUND); 
		  return re; 
	  }
	
}