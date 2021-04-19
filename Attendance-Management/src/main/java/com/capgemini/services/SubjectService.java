package com.capgemini.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.capgemini.entity.SubjectEntity;
import com.capgemini.exception.CourseIdNotFoundException;
import com.capgemini.exception.DuplicateRecordException;
import com.capgemini.exception.FacultyIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.SubjectNotFoundException;

public interface SubjectService {
	
	//To add subject in the database
    SubjectEntity addSubject(SubjectEntity entity) throws DuplicateRecordException;
	
    //To get subject by using subjectID
	SubjectEntity getSubjectById(int subjectId) throws SubjectNotFoundException;

	//To update subject using subjectID
	SubjectEntity updateSubjectById(int subjectId, SubjectEntity fe) throws SubjectNotFoundException;

	//To get the list of subjects
	List<SubjectEntity> getAllSubjects() throws RecordNotFoundException;

	//To delete the subject using subjectID
	String deleteSubById(int subjectId) throws RecordNotFoundException;

	//To get the subject by using subjectname
	List<SubjectEntity> findSubjectByName(String subjectName) throws RecordNotFoundException;
	
	//To add subject with using facultyID and courseID
	SubjectEntity addSubjectwithFC(SubjectEntity entity, int facultyId, int courseId)
			throws FacultyIdNotFoundException,CourseIdNotFoundException, DuplicateRecordException;
	                                                       
	//To get the list of subject according to semester
	List<SubjectEntity> findSubjectBySemester(String subjectSemester) throws RecordNotFoundException;

	boolean getSubjectExistById(int subjectId);

	
	

}
