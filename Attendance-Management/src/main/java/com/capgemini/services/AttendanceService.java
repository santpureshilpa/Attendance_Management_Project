package com.capgemini.services;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.capgemini.entity.AttendanceEntity;
import com.capgemini.entity.SubjectEntity;

public interface AttendanceService {
	
	public AttendanceEntity addAttendance(AttendanceEntity entity);
	
	public String deleteAllAttendance();
	
	public List<AttendanceEntity> getAttendance();
	
	public AttendanceEntity getAttendanceById(int attendanceId);
	
	public AttendanceEntity updateAttendanceById(int attendanceId,AttendanceEntity entity);
	
	public String deleteById(int attendanceId);

	public String deleteAttendance(AttendanceEntity ae);
	
	AttendanceEntity findAttendanceBySemester(String semester);

	List<AttendanceEntity> findAttendanceByStatus(String status);
	}

