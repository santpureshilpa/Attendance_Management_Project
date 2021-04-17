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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.FacultyEntity;
import com.capgemini.entity.SubjectEntity;
import com.capgemini.exception.FacultyNotFoundException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.services.FacultyService;

@RestController
@RequestMapping("/Faculty")
public class FacultyController {
	
	@Autowired
	FacultyService facultyServices;
	
	@PostMapping(path="/addFaculty")
	public ResponseEntity<FacultyEntity> addFaculty(@Valid @RequestBody FacultyEntity se)
	{
		FacultyEntity se1 = facultyServices.addFaculty(se);
		
		return new ResponseEntity<FacultyEntity>(se1,HttpStatus.CREATED);
	}
	
	@GetMapping(path="/getFacultyById/{facultyId}")
	public ResponseEntity<FacultyEntity> getFacultyById(@Valid @PathVariable int facultyId) throws FacultyNotFoundException
	{
		FacultyEntity fe = facultyServices.getFacultyById(facultyId);
		return new ResponseEntity<FacultyEntity>(fe, HttpStatus.FOUND);
	}
	
	
	  @GetMapping(path="/getFacultyByName/{facultyName}") public
	  ResponseEntity<List<FacultyEntity>> findFacultyByName(@PathVariable String
	  facultyName) { List<FacultyEntity>
	  fe=facultyServices.findByfacultyName(facultyName); return new
	  ResponseEntity<List<FacultyEntity>>(fe,HttpStatus.OK);
	  
	  }
	 
	
	@DeleteMapping(path="/deleteFacultyById/{facultyId}")
	public ResponseEntity<String> deleteFacultyById(@Valid @PathVariable int facultyId) throws RecordNotFoundException
	{
		facultyServices.deleteFacultyById(facultyId);
		return new ResponseEntity<String>("Deleted by Id from Database", HttpStatus.OK);
	}
	
	@GetMapping(path="/getAllFaculties")
	public ResponseEntity<List<FacultyEntity>> getAllFaculty()
	{
		
		List<FacultyEntity> fe = facultyServices.getAllFaculty();
		return new ResponseEntity<List<FacultyEntity>>(fe, HttpStatus.OK);
		
	}
	
	@PutMapping(path="/updateFacultyById/{facultyId}")
	public ResponseEntity<FacultyEntity> updateFacultyById(@Valid @PathVariable int facultyId, @Valid @RequestBody FacultyEntity se) throws FacultyNotFoundException
	{
		FacultyEntity fe = facultyServices.updateFacultyById(facultyId, se);
		return new ResponseEntity<FacultyEntity>(fe, HttpStatus.ACCEPTED);
	}
}