package com.capgemini.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Attendances")
public class AttendanceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="attendance_seq")
	@SequenceGenerator(name="attendance_seq",sequenceName="attendnace_seq",allocationSize=1)
	private int attendanceId;

	@NotEmpty(message="Please enter valid semester")
	private String semester;
	
	private Date currentDate;
	
	@NotEmpty(message="Please Enter Valid Status (Present/Absent)")
	private String status;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private StudentEntity std;
	
	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

  public Date getCurrentDate() { return currentDate; }
	  
	  public void setCurrentDate(Date currentDate) { this.currentDate = currentDate; }
	 
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public StudentEntity getStd() {
		return std;
	}

	public void setStd(StudentEntity std) {
		this.std = std;
	}
	

	@Override
	public String toString() {
		return "AttendanceEntity [attendanceId=" + attendanceId + ", semester=" + semester + ", status=" + status
				+ ", std=" + std + "]";
	}

	
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "Attendance_Subject") private SubjectEntity subjectId;
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @Column(name = "student_roll_no") private long studentRollNo;
	 */
	
	


}