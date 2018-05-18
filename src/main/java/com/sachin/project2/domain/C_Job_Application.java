package com.sachin.project2.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component("c_job_application")
@Entity
@Table
public class C_Job_Application extends BaseDomain implements Serializable {
	@Id
	private int jobApp_Id;
	private String jobApp_email;
	private int job_id;
	private Date applied_date;
	private Character jobApp_status;
	private String reason;
	public int getJobApp_Id() {
		return jobApp_Id;
	}
	public void setJobApp_Id(int jobApp_Id) {
		this.jobApp_Id = jobApp_Id;
	}
	public String getJobApp_email() {
		return jobApp_email;
	}
	public void setJobApp_email(String jobApp_email) {
		this.jobApp_email = jobApp_email;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public Date getApplied_date() {
		return applied_date;
	}
	public void setApplied_date(Date applied_date) {
		this.applied_date = applied_date;
	}
	public Character getJobApp_status() {
		return jobApp_status;
	}
	public void setJobApp_status(Character jobApp_status) {
		this.jobApp_status = jobApp_status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
