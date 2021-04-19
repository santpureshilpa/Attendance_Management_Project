package com.capgemini.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.SubjectEntity;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity,Integer>
{
	//This Query will generate the list of Subject details by checking the subject name & ignoring case
	List<SubjectEntity> findBysubjectNameIgnoreCaseContains(String subjectName);

	//@Query("from Subjects where subject_semester = ?1")
   List<SubjectEntity> findBysubjectSemester(String subjectSemester);

	
	
}