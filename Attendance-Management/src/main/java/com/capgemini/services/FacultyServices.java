package com.capgemini.services;

import java.util.List;

import com.capgemini.entity.AttendanceEntity;
import com.capgemini.entity.FacultyEntity;

public interface FacultyServices {

	public FacultyEntity addFaculty(FacultyEntity entity);
	public FacultyEntity updateFaculty(FacultyEntity entity);
	public String deleteFaculty(FacultyEntity entity);
	public FacultyEntity getFacultyById(int facultyId);

	public String deleteFacultyById(int facultyId);

	public List<FacultyEntity> getAllFaculty();

	public FacultyEntity updateFacultyById(int facultyId);
	
}
