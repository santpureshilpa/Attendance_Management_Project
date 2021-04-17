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
import com.capgemini.exception.DuplicateRecordException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.SubjectNotFoundException;
import com.capgemini.services.SubjectService;

@RestController
@RequestMapping("/Subject")
public class SubjectController {
	
	@Autowired
	SubjectService subjectService;
	
	@PostMapping(path="/addSubject") 
	public ResponseEntity<SubjectEntity> addSubject(@Valid @RequestBody SubjectEntity se) throws DuplicateRecordException 
	{
		SubjectEntity se1 = subjectService.addSubject(se);
		
		return new ResponseEntity<SubjectEntity>(se1,HttpStatus.OK);
	}
	
	@DeleteMapping(path="/deleteSubject")
	public String deleteSubject(@Valid @RequestBody SubjectEntity se)
	{
		String s1 = subjectService.deleteSubject(se);
		
		return s1;
	}
	@PutMapping(path="/updateSubjectById/{subjectId}")
	public ResponseEntity<SubjectEntity> updateSubjectById(@Valid @PathVariable int subjectId, @Valid @RequestBody SubjectEntity fe)
	throws SubjectNotFoundException
	{
		SubjectEntity se = subjectService.updateSubjectById(subjectId, fe);
		ResponseEntity re = new ResponseEntity<SubjectEntity>(se, HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getSubjectById/{subjectId}") 
	public ResponseEntity <SubjectEntity> getSubjectById(@Valid @PathVariable int subjectId) throws SubjectNotFoundException
	{
		SubjectEntity se = subjectService.getSubjectById(subjectId);
		ResponseEntity re = new ResponseEntity<SubjectEntity>(se, HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getAllSubjects")
	public ResponseEntity<List<SubjectEntity>> getAllSubjects()
	{		
		List<SubjectEntity> se = subjectService.getAllSubjects();
		ResponseEntity re = new ResponseEntity<List<SubjectEntity>>(se, HttpStatus.OK);
		return re;
		
	}

	
	  @GetMapping(path="/getSubjectsByName/{subjectName}") 
	  public ResponseEntity<SubjectEntity> findSubjectByName(@PathVariable String subjectName)
	 {
		  SubjectEntity se=subjectService.findSubjectByName(subjectName);
		  ResponseEntity<SubjectEntity> re=new ResponseEntity<SubjectEntity>(se,HttpStatus.FOUND);
		  return re;
	  
	  
	  }
	 
	@DeleteMapping(path="/deleteSubject/{subjectId}")
	public ResponseEntity<String> deleteSubById(@Valid @PathVariable int subjectId) throws RecordNotFoundException
	{
		subjectService.deleteSubById(subjectId);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
}
