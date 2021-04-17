package com.capgemini.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Faculties")
public class FacultyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="faculties_generations")
	@SequenceGenerator(name="faculties_generations", sequenceName = "faculties_sequences", allocationSize=1)
	private int facultyId;
	
    @Column(name = "faculty_user_name") 
	@NotEmpty
	@Size(min=5, max = 30, message = "Not a valid name")
    private String facultyName;

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
		return "FacultyEntity [facultyId=" + facultyId + ", facultyName=" + facultyName + "]";
	}	
}