package com.capgemini.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Faculties")
public class FacultyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int facultyId;
	
    @Column(name = "faculty_user_name") 
    @NotEmpty
	@Size(min = 10, max = 50, message = "Please Enter Valid Course Description")
	private String facultyName;
    
    
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<SubjectEntity> subList;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<StudentEntity> stdList;
    

	public List<SubjectEntity> getSubList() {
		return subList;
	}

	public void setSubList(List<SubjectEntity> subList) {
		this.subList = subList;
	}

	public List<StudentEntity> getStdList() {
		return stdList;
	}

	public void setStdList(List<StudentEntity> stdList) {
		this.stdList = stdList;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	@Override
	public String toString() {
		return "FacultyEntity [facultyId=" + facultyId + ", facultyName=" + facultyName + ", subList=" + subList
				+ ", stdList=" + stdList + "]";
	}




	
	
	
}