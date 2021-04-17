package com.capgemini.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.SubjectEntity;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity,Integer>
{

SubjectEntity findBysubjectNameIgnoreCase(String subjectName);


	
	
}