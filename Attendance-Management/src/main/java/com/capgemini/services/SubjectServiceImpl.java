package com.capgemini.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.entity.SubjectEntity;
import com.capgemini.exception.DuplicateRecordException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.StudentNotFoundException;
import com.capgemini.exception.SubjectNotFoundException;
import com.capgemini.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	SubjectRepository subjectRepository;
	
	
	@Override
	public SubjectEntity addSubject(SubjectEntity entity) throws DuplicateRecordException{
		List<SubjectEntity> sub=this.getAllSubjects();
		for(SubjectEntity subjectentity:sub)
		{
			if(subjectentity.getSubjectName().equalsIgnoreCase(entity.getSubjectName()))
			{
				throw new DuplicateRecordException("The name of Subject is already exist......Provide different SubjectName");
			}
		}
		SubjectEntity subjectentity = (SubjectEntity) subjectRepository.save(entity);		
		return subjectentity;
	}

	@Override
	public String deleteSubject(SubjectEntity entity) {
		subjectRepository.delete(entity);
		return "Deleted";
	}
	
	  @Override 
	  public String deleteSubById(int subjectId) 
	  {
		  SubjectEntity subjectentity=subjectRepository.findById(subjectId).orElse(null); 
		  subjectRepository.deleteById(subjectId);
	  return "Deleted"; }
	 
	
	
	
	@Override
	public SubjectEntity getSubjectById(int subjectId) throws SubjectNotFoundException {
		Supplier<SubjectNotFoundException> supplier=()->new SubjectNotFoundException("Subject not found with this id");
      SubjectEntity subjectentity = subjectRepository.findById(subjectId).orElseThrow(supplier);
		return subjectentity;
	}
	@Override
	public List<SubjectEntity> getAllSubjects() {
		List<SubjectEntity> subjectentity = new ArrayList<SubjectEntity>();
		subjectentity = subjectRepository.findAll();		
		return subjectentity;
	}

	@Override
	public SubjectEntity updateSubjectById(int subjectId, SubjectEntity fe) throws SubjectNotFoundException{
		Supplier<SubjectNotFoundException> supplier=()->new SubjectNotFoundException("Subject of " + subjectId + " id is not present in database");
		SubjectEntity se = subjectRepository.findById(subjectId).orElseThrow(supplier);
		se.setSubjectName(fe.getSubjectName());
		se.setSubjectSemester(fe.getSubjectSemester());
		se.setDescription(fe.getDescription());
		subjectRepository.save(se);
		return se;
	}

	@Override
	public SubjectEntity findSubjectByName(String subjectName) {
		return subjectRepository.findBysubjectNameIgnoreCase(subjectName);
	}

	
	  @Override 
	  public List<SubjectEntity> findSubjectBySemester(String subjectSemester)
	  { 
		  return subjectRepository.findBysubjectSemester(subjectSemester);
	  
	  }
	 

	
	
	


	

	

}
