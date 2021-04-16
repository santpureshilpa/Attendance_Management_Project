package com.capgemini.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.AttendanceEntity;
import com.capgemini.repository.AttendanceRepository;

@Service
public class AttendanceServiceImpl implements AttendanceService{
	
	List<AttendanceEntity> le;
	
	@Autowired
	AttendanceRepository attendanceRepository;

	@Override
	public AttendanceEntity addAttendance(AttendanceEntity entity)
	{
		return attendanceRepository.save(entity);	
	}

	/*
	 * @Override public AttendanceEntity updateAttendance(AttendanceEntity entity) {
	 * int id = entity.getAttendanceId(); AttendanceEntity ae = (AttendanceEntity)
	 * arepo.findById(id).orElse(null); //ae.setDate(entity.getDate());
	 * ae.setSemester(entity.getSemester()); ae.setStatus(entity.getStatus());
	 * arepo.save(ae); return ae; }
	 */

	@Override
	public String deleteAllAttendance() {
		attendanceRepository.deleteAll();
        return "Deleted All The Record";
	}

	@Override
	public List<AttendanceEntity> getAttendance() {
		le = new ArrayList<>();
		le = attendanceRepository.findAll();
		return le;
	}

	@Override
	public AttendanceEntity getAttendanceById(int attendanceId) {
		
		//AttendanceEntity e = arepo.findByAttendanceId(attendanceId);
		AttendanceEntity e = attendanceRepository.findById(attendanceId).orElse(null);
		 return e;
	}
	
	@Override
	public AttendanceEntity updateAttendanceById(int attendanceId, AttendanceEntity entity) {
		AttendanceEntity ae = attendanceRepository.findById(attendanceId).orElse(null);
	    ae.setSemester(entity.getSemester());
	    ae.setStatus(entity.getStatus());
	    attendanceRepository.save(ae);
	    return ae;
	}

	@Override
	public String deleteById(int attendanceId) {
		attendanceRepository.deleteById(attendanceId);
		return "DELETED BY ID";
	}

	@Override
	public String deleteAttendance(AttendanceEntity ae) {
		
		attendanceRepository.delete(ae);
		
		return "Deleted";
	}

}
