package com.capgemini.entity;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



@Entity
@Table(name = "Attendance")
public class AttendanceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="attendances_generations")
	@SequenceGenerator(name="attendances_generations",sequenceName="attendances_sequences",allocationSize=1)
	private int attendanceId;

    @NotEmpty(message="Please Enter Valid Semester")
	private String semester;
	
    @NotNull
    private LocalDate currentDate;
	
    @NotEmpty(message="Please Enter Valid Status (Present/Absent)")
    @Pattern(regexp="(absent|Absent|present|Present)", message="Please enter valid Status")
	private String status;
    
    
    //Getters and Setters
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
	}

}


