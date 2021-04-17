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

import com.capgemini.entity.AttendanceEntity;
import com.capgemini.exception.AttendanceIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.services.AttendanceService;

@RestController
@RequestMapping("/Attendance")
public class AttendanceController {

	@Autowired
	AttendanceService attendanceService;
	
	@PostMapping(path="/addAttendance")
	public ResponseEntity<AttendanceEntity> addAttend(@Valid @RequestBody AttendanceEntity ae)
	{
		return new ResponseEntity<AttendanceEntity>(attendanceService.addAttendance(ae),HttpStatus.CREATED);
	}

	@PutMapping(path="/updateAttendance/{attendanceId}") 
	public ResponseEntity<AttendanceEntity> updateAttendById(@Valid @PathVariable int attendanceId,@Valid @RequestBody AttendanceEntity entity)throws AttendanceIdNotFoundException
	{
		return new ResponseEntity<AttendanceEntity>(attendanceService.updateAttendanceById(attendanceId,entity),HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path="/getAllAttendance")
	public ResponseEntity<List<AttendanceEntity>> getAttendance() throws RecordNotFoundException{
	   return new ResponseEntity<List<AttendanceEntity>>(attendanceService.getAttendance(),HttpStatus.FOUND);
	}
	
	@GetMapping(path="/getAttendanceById/{attendanceId}")
	public ResponseEntity<AttendanceEntity> getAttendanceById(@Valid @PathVariable int attendanceId) throws AttendanceIdNotFoundException
	{
		return new ResponseEntity<AttendanceEntity>(attendanceService.getAttendanceById(attendanceId),HttpStatus.FOUND);
	}
	
	@DeleteMapping(path="/deleteAttendanceById/{attendanceId}") 
	public String deleteAttendanceById(@Valid @PathVariable int attendanceId) throws RecordNotFoundException
	{
		return attendanceService.deleteById(attendanceId);	
	}
}