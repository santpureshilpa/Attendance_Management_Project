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
	public StudentEntity getStudentById(int studentId) throws StudentNotFoundException {
		
		Supplier<StudentNotFoundException> supplier=()->new StudentNotFoundException("no Student found with this id");
		StudentEntity entity=studentRepository.findById(studentId).orElseThrow(supplier);
		return entity;
	}

	@Override
	public List<StudentEntity> getStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public StudentEntity addStudent(StudentEntity entity) {
		
		return studentRepository.save(entity);
	}

	@Override
	public StudentEntity updateStudent(StudentEntity entity) {
		
		int Id=entity.getId();
	
		StudentEntity se = studentRepository.findById(Id).orElse(null);
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
	public String deleteStudent(int studentId) throws RecordNotFoundException {
		Supplier<StudentNotFoundException> supplier=()->new StudentNotFoundException("This Student_id is not present");
		StudentEntity studententity=studentRepository.findById(studentId).orElse(null);
		studentRepository.delete(studententity); 
		return "deleted successfully";
	}

	@Override
	public String deleteRecord(StudentEntity e) {
		studentRepository.deleteAll();
		return "deleted successfully";
	}

}
