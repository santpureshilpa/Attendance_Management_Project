package com.capgemini.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.FacultyEntity;
import com.capgemini.exception.FacultyNotFoundException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService {
		
	@Autowired
	FacultyRepository facultyRepository;
	
	@Override
	public FacultyEntity addFaculty(FacultyEntity entity)
	{
		FacultyEntity fe = (FacultyEntity) facultyRepository.save(entity);
		return fe;
	}

	@Override
	public FacultyEntity getFacultyById(int facultyId) throws FacultyNotFoundException{
		
		Supplier<FacultyNotFoundException> supplier=()->new FacultyNotFoundException("This Faculty is not present");
		FacultyEntity fe = facultyRepository.findById(facultyId).orElseThrow(supplier);
		
		return fe;
	}

	@Override
	public String deleteFacultyById(int facultyId) throws RecordNotFoundException{
		Supplier<RecordNotFoundException> supplier=()->new RecordNotFoundException("No such Record Found");
		facultyRepository.findById(facultyId).orElseThrow(supplier);
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
	public FacultyEntity updateFacultyById(int facultyId, FacultyEntity se) throws FacultyNotFoundException{
		
		Supplier<FacultyNotFoundException> supplier=()->new FacultyNotFoundException("This Faculty is not present");
		FacultyEntity fe = facultyRepository.findById(facultyId).orElseThrow(supplier);
		fe.setFacultyName(se.getFacultyName());
		facultyRepository.save(fe);
		return fe;
	}
	
	

    
}
