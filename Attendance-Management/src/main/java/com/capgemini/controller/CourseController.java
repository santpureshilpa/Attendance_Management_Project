package com.capgemini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.CourseEntity;
import com.capgemini.services.CourseService;


@RestController
@RequestMapping("/Course")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@PostMapping(path="/addCourse")
	public ResponseEntity<CourseEntity> addCourse(@Valid @RequestBody CourseEntity se)
	{
		CourseEntity se1 = courseService.addCourse(se);
		
		return new ResponseEntity<CourseEntity>(se1,HttpStatus.OK);
	}

		
	@PutMapping(path="/updateCourse/{courseId}")
	public ResponseEntity<CourseEntity> updateByCourseId(@Valid @PathVariable int courseId, @Valid @RequestBody CourseEntity entity)
	{
		return new ResponseEntity<CourseEntity>(courseService.updateByCourseId(courseId,entity),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/deleteByCourseId/{courseId}")
	public String deleteByCourseId(@Valid @PathVariable int courseId)
	{
	
		courseService.deleteByCourseId(courseId);
	    return "Deleted By Course Id";
	}
	
	@GetMapping(path="/getAllCourse")
	public ResponseEntity<List<CourseEntity>> getCourse()
	{
		return new ResponseEntity<List<CourseEntity>>(courseService.getCourse(),HttpStatus.OK);
	}
	
	@GetMapping(path="/getByCourseId/{courseId}")
	public ResponseEntity<CourseEntity> getCourseById(@Valid @PathVariable int courseId)
	{
		return new ResponseEntity<CourseEntity>(courseService.getCourseById(courseId),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/deleteAllCourse")
	public String deleteAllCourse()
	{
		courseService.deleteAllCourse();
		return "Deleted All The Data";
	}
}
