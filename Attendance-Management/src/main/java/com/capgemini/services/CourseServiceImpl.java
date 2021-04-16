package com.capgemini.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.CourseEntity;
import com.capgemini.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	List<CourseEntity> le;

	@Override
	public CourseEntity addCourse(CourseEntity entity) {
		CourseEntity ce = (CourseEntity) courseRepository.save(entity);		
		return ce;
	}

	@Override
	public String deleteByCourseId(int courseId) {
		courseRepository.deleteById(courseId);
	    return "Deleted By Course Id";
	}

	@Override
	public List<CourseEntity> getCourse() {
		le = new ArrayList<>();
		le = courseRepository.findAll();
		
		return le;
	}

	@Override
	public CourseEntity getCourseById(int courseId) {
		CourseEntity ce = courseRepository.findById(courseId).orElse(null);
		return ce;
	}
	
	@Override
	public CourseEntity updateByCourseId(int courseId, CourseEntity entity) {
		CourseEntity ce = courseRepository.findById(courseId).orElse(null);
		ce.setCourseName(entity.getCourseName());
		ce.setDescription(entity.getDescription());
		courseRepository.save(ce);
		return ce;
	}

	@Override
	public String deleteAllCourse() {
		courseRepository.deleteAll();
	    return "Deleted";
	}

	
	
	
	

}
