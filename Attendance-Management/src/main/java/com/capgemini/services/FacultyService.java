package com.capgemini.services;

import java.util.List;

import com.capgemini.entity.FacultyEntity;
import com.capgemini.exception.FacultyIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;

public interface FacultyService {
	
	//For adding the details of the faculty 
	public FacultyEntity addFaculty(FacultyEntity entity);
	
    //To get the faculty by facultyID
	public FacultyEntity getFacultyById(int facultyId) throws FacultyIdNotFoundException;

	//To delete the faculty by facultyID
	public String deleteFacultyById(int facultyId) throws RecordNotFoundException;

	//To get the list of all the faculty in the database
	public List<FacultyEntity> getAllFaculty() throws RecordNotFoundException;

	//To update the faculty by facultyID
	FacultyEntity updateFacultyById(int facultyId, FacultyEntity se) throws FacultyIdNotFoundException;
	
	//To get the list of faculty by using faculty name
	List<FacultyEntity> findByfacultyName(String facultyName) throws RecordNotFoundException;

	public boolean getFacultyExistById(int facultyId);

	
}