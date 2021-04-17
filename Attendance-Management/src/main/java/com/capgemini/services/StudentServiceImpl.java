package com.capgemini.services;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.entity.StudentEntity;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.StudentNotFoundException;
import com.capgemini.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public StudentEntity getStudentById(int studentId) throws StudentNotFoundException{
		Supplier<StudentNotFoundException> supplier=()->new StudentNotFoundException("no Student found with this id");
		StudentEntity entity=studentRepository.findById(studentId).orElseThrow(supplier);
		return entity;
	}

	@Override
	public List<StudentEntity> getStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public StudentEntity addStudent(StudentEntity entity) {
		// TODO Auto-generated method stub
		return studentRepository.save(entity);
	}

	@Override
	public StudentEntity updateStudent(int studentId, StudentEntity entity) throws StudentNotFoundException{
		
		Supplier<StudentNotFoundException> supplier=()->new StudentNotFoundException("No such Student Found");
		StudentEntity se = studentRepository.findById(studentId).orElseThrow(supplier);
		se.setFirstName(entity.getFirstName());
		se.setLastName(entity.getLastName());
		se.setDateOfBirth(entity.getDateOfBirth());
		se.setEmailId(entity.getEmailId());
		se.setFatherEmailId(entity.getFatherEmailId());
		se.setFatherMobileNumber(entity.getFatherMobileNumber());
		se.setGender(entity.getGender());
		se.setMobileNumber(entity.getMobileNumber());
		se.setSemester(entity.getSemester());
		se.setSubjectId(entity.getSubjectId());
		se.setSubjectName(entity.getSubjectName());
		
		return studentRepository.save(se);
	}

	
	@Override
	public String deleteStudent(int studentId) throws RecordNotFoundException{
		Supplier<RecordNotFoundException> supplier=()->new RecordNotFoundException("no Student_id was found");
		StudentEntity st=studentRepository.findById(studentId).orElseThrow(supplier);
		studentRepository.delete(st); 
		return "deleted successfully";
	}

	

}