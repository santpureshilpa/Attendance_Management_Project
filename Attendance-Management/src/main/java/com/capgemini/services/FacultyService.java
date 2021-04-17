package com.capgemini.services;

import java.util.List;

import com.capgemini.entity.FacultyEntity;
import com.capgemini.exception.FacultyNotFoundException;
import com.capgemini.exception.RecordNotFoundException;

public interface FacultyService {
	
	public FacultyEntity addFaculty(FacultyEntity entity);

	public FacultyEntity getFacultyById(int facultyId) throws FacultyNotFoundException;

	public String deleteFacultyById(int facultyId) throws RecordNotFoundException;

	public List<FacultyEntity> getAllFaculty();

	FacultyEntity updateFacultyById(int facultyId, FacultyEntity se) throws FacultyNotFoundException;

	List<FacultyEntity> findByfacultyName(String facultyName);

	
}