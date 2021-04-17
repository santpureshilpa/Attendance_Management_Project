package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.FacultyEntity;

@Repository
public interface FacultyRepository extends JpaRepository<FacultyEntity,Integer> {
	
	//@Query("from Faculties fm where fm.facultyName=?1")
	List<FacultyEntity> findByfacultyName(String facultyName);
	
}
