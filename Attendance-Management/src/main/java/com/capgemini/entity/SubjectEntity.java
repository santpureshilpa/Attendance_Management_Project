
package com.capgemini.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="Subjects")
public class SubjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="subjects_generations")
	@SequenceGenerator(name="subjects_generations", sequenceName = "subjects_sequences", allocationSize=1)	
	private int subjectId;
	
	@Column(name="subject_name")
	@NotEmpty
	@Size(max = 15, message = "Not a valid subject name")
	private String subjectName;
	
	@NotEmpty
	private String subject_semester;
	
	@NotEmpty
	@Size(max = 50)
	private String description;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="courseId")
	private CourseEntity Course;

	public CourseEntity getCourse() {
		return Course;
	}

	public void setCourse(CourseEntity course) {
		Course = course;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubject_semester() {
		return subject_semester;
	}

	public void setSubject_semester(String subject_semester) {
		this.subject_semester = subject_semester;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SubjectEntity(int subjectId,
			@NotEmpty @Size(max = 15, message = "Not a valid subject name") String subjectName,
			@NotEmpty String subject_semester, @NotEmpty @Size(max = 50) String description, CourseEntity course) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subject_semester = subject_semester;
		this.description = description;
		Course = course;
	}

	public SubjectEntity() {
		super();
	}

	@Override
	public String toString() {
		return "SubjectEntity [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subject_semester="
				+ subject_semester + ", description=" + description + ", Course=" + Course + "]";
	}

	
	
}