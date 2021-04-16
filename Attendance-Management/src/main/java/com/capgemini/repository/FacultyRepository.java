package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entity.FacultyEntity;

public interface FacultyRepository extends JpaRepository<FacultyEntity,Integer> {
	
}
