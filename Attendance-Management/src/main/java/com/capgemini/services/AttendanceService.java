package com.capgemini.services;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.capgemini.entity.AttendanceEntity;

public interface AttendanceService {
	
	public AttendanceEntity addAttendance(AttendanceEntity entity);
	
	public String deleteAllAttendance();
	
	public List<AttendanceEntity> getAttendance();
	
	public AttendanceEntity getAttendanceById(int attendanceId);
	
	public AttendanceEntity updateAttendanceById(int attendanceId,AttendanceEntity entity);
	
	public String deleteById(int attendanceId);

	public String deleteAttendance(AttendanceEntity ae);
	}

