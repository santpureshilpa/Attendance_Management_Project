package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.entity.CourseEntity;


@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Integer>{

	CourseEntity findBycourseName(String courseName);
	
	
}
