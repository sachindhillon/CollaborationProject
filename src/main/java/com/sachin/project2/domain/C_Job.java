package com.sachin.project2.domain;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component("c_job")
@Entity
@Table
public class C_Job extends BaseDomain implements Serializable {
	@Id
	private int job_id;	
	private String job_title;
	private String job_description;	
	private String job_qualification;
	private int job_salary;
	private Character job_status;
	private String company_name;
	private int no_of_openings;
	private String skills_required;
	private String location;
	private String contact;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	private Date job_posted_date;
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getJob_description() {
		return job_description;
	}
	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}
	public String getJob_qualification() {
		return job_qualification;
	}
	public void setJob_qualification(String job_qualification) {
		this.job_qualification = job_qualification;
	}
	public int getJob_salary() {
		return job_salary;
	}
	public void setJob_salary(int job_salary) {
		this.job_salary = job_salary;
	}
	public Character getJob_status() {
		return job_status;
	}
	public void setJob_status(Character job_status) {
		this.job_status = job_status;
	}
	public int getNo_of_openings() {
		return no_of_openings;
	}
	public void setNo_of_openings(int no_of_openings) {
		this.no_of_openings = no_of_openings;
	}
	public Date getJob_posted_date() {
		return job_posted_date;
	}
	public void setJob_posted_date(Date job_posted_date) {
		this.job_posted_date = job_posted_date;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getSkills_required() {
		return skills_required;
	}
	public void setSkills_required(String skills_required) {
		this.skills_required = skills_required;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}


}
