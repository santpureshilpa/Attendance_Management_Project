package com.capgemini.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.FacultyEntity;
import com.capgemini.exception.FacultyIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService {
		
	@Autowired
	FacultyRepository facultyRepository;
	
	//To add faculty in the database
	@Override
	public FacultyEntity addFaculty(FacultyEntity entity)
	{
		FacultyEntity fe = (FacultyEntity) facultyRepository.save(entity);
		return fe;
	}

	//To get faculty using faculty ID
	@Override
	public FacultyEntity getFacultyById(int facultyId) throws FacultyIdNotFoundException
	{
		Supplier<FacultyIdNotFoundException> supplier=()->new FacultyIdNotFoundException("This Faculty is not present");
		FacultyEntity fe = facultyRepository.findById(facultyId).orElseThrow(supplier);
		return fe;
	}

	//To delete the details of faculty using faculty ID
	@Override
	public String deleteFacultyById(int facultyId) throws RecordNotFoundException
	{
		Supplier<RecordNotFoundException> supplier=()->new RecordNotFoundException("No such Record Found");
		facultyRepository.findById(facultyId).orElseThrow(supplier);
		facultyRepository.deleteById(facultyId);
		return "Deleted by Id";	
	}

	//To get the list of all faculty in the database
	@Override
	public List<FacultyEntity> getAllFaculty() throws RecordNotFoundException
	{
		List<FacultyEntity> fe = new ArrayList<FacultyEntity>();
		fe = facultyRepository.findAll();		
		if(fe.isEmpty())
			throw new RecordNotFoundException("Record Not In The Database");
		return fe;
	}

	//To update the faculty using faculty ID
	@Override
	public FacultyEntity updateFacultyById(int facultyId, FacultyEntity se) throws FacultyIdNotFoundException
	{
		Supplier<FacultyIdNotFoundException> supplier=()->new FacultyIdNotFoundException("Given Id Is Not Present");
		FacultyEntity fe = facultyRepository.findById(facultyId).orElseThrow(supplier);
		fe.setFacultyName(se.getFacultyName());		
		facultyRepository.save(fe);
		return fe;
	}
	
	//To get the faculty using faculty name
	  @Override 
	  public List<FacultyEntity> findByfacultyName(String facultyName) throws RecordNotFoundException
	  {
		  List<FacultyEntity> fe = facultyRepository.findByfacultyNameIgnoreCaseContains(facultyName);
		  if(fe.isEmpty())
			  throw new RecordNotFoundException("Record Not In The Database");
		  return fe;
      }
	  
    
	@Override
	public boolean getFacultyExistById(int facultyId) 
	{
		return facultyRepository.existsById(facultyId);
	}
	   
}