package com.sachin.project2.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component("c_job_application")
@Entity
@Table
public class C_Job_Application extends BaseDomain implements Serializable {
	@Id
	private int jobApp_Id;
	private String login_name;
	private String jobapp_title;
	private String emailid;
	private int job_id;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	private Date applied_date;
	private Character jobApp_status;
	private String reason;
	public int getJobApp_Id() {
		return jobApp_Id;
	}
	public void setJobApp_Id(int jobApp_Id) {
		this.jobApp_Id = jobApp_Id;
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
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getJobapp_title() {
		return jobapp_title;
	}
	public void setJobapp_title(String jobapp_title) {
		this.jobapp_title = jobapp_title;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
}
