package com.capgemini.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.FacultyEntity;
import com.capgemini.repository.FacultyRepository;

@Service
public class FacultyServicesImpl implements FacultyServices {
	
	@Autowired
	FacultyRepository facultyRepository;
	

	@Override
	public FacultyEntity addFaculty(FacultyEntity entity) {
		FacultyEntity fe = (FacultyEntity) facultyRepository.save(entity);
		return fe;
		
	}

	@Override
	public FacultyEntity updateFaculty(FacultyEntity entity) {

		int id = entity.getFacultyId();
		FacultyEntity fe1 = (FacultyEntity) facultyRepository.findById(id).orElse(null);
		fe1.setFacultyName(entity.getFacultyName());
		facultyRepository.save(fe1);
		return fe1;
	}

	@Override
	public String deleteFaculty(FacultyEntity entity) {
		facultyRepository.delete(entity);
		return "Deleted";
	}
	
	@Override
	public FacultyEntity getFacultyById(int facultyId) {
		
		FacultyEntity fe = facultyRepository.findById(facultyId).orElse(null);
		
		return fe;
	}

	@Override
	public String deleteFacultyById(int facultyId) {
		
		FacultyEntity fe = facultyRepository.findById(facultyId).orElse(null);
		facultyRepository.deleteById(facultyId);
		return "Deleted by Id";	
	}

	@Override
	public List<FacultyEntity> getAllFaculty() {
		List<FacultyEntity> fe = new ArrayList<FacultyEntity>();
		fe = facultyRepository.findAll();		
		return fe;
	}

	@Override
	public FacultyEntity updateFacultyById(int facultyId) {
		FacultyEntity fe = facultyRepository.findById(facultyId).orElse(null);
		fe.setFacultyName(fe.getFacultyName());
		facultyRepository.save(fe);
		return fe;
	}
	
	

    
}


