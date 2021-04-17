package com.capgemini.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="Students")
public class StudentEntity {
	
	@Id
	@Column(name = "roll_no")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="students_generations")
	@SequenceGenerator(name="students_generations", sequenceName = "students_sequences", allocationSize=1)	
	private int studentId;
	
	@Column(name = "first_name")
	@NotEmpty
	@Size(min=2, message="Not a valid first name")
	private String firstName;
	
	
	@Column(name = "last_name")
	@NotEmpty
	@Size(min=2, message="Not a valid last name")
	private String lastName;
	
	@Column(name = "DOB")
	private Date dateOfBirth;
	
	@NotEmpty
	@Pattern(regexp="^(?:m|M|male|Male|f|F|female|Female)$", message="Invalid Entry")
	private String gender;
	
	@Column(name = "mobile_no")
	@NotEmpty
	@Pattern(regexp="(^[6-9][0-9]{9}$)", message="Invalid Mobile Number")
	private String mobileNumber;
	
	@NotEmpty
	private String semester;
	
	@Column(name = "email_id")
	@Email(message = "invalid email")
	private String emailId;
	
	@Column(name = "father_email_id")
	@Email(message = "invalid email")
	private String fatherEmailId;
	
	@Column(name = "father_mobile_number")
	@NotEmpty
	@Pattern(regexp="(^[6-9][0-9]{9}$)", message="Invalid Mobile Number")
	private String fatherMobileNumber;
	
	@NotNull
	private int subjectId;
	
	@NotEmpty
	private String subjectName;

	public int getId() {
		return studentId;
	}

	public void setId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFatherEmailId() {
		return fatherEmailId;
	}

	public void setFatherEmailId(String fatherEmailId) {
		this.fatherEmailId = fatherEmailId;
	}

	public String getFatherMobileNumber() {
		return fatherMobileNumber;
	}

	public void setFatherMobileNumber(String fatherMobileNumber) {
		this.fatherMobileNumber = fatherMobileNumber;
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

	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", semester=" + semester
				+ ", emailId=" + emailId + ", fatherEmailId=" + fatherEmailId + ", fatherMobileNumber="
				+ fatherMobileNumber + ", subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}
	
}