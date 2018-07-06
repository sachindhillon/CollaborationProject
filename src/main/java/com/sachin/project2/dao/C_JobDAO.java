package com.sachin.project2.dao;

import java.util.List;

import com.sachin.project2.domain.C_Job;
import com.sachin.project2.domain.C_Job_Application;

public interface C_JobDAO {
	// create a new c_job
	
		public boolean save(C_Job c_job);
		
		//admin may update the c_job details
		
		public boolean update(C_Job c_job);
		
		//admin will not delete the c_job
		//once the c_job is closed, admin will change
		//status - F/C
		
		//fetch a particular c_job
		
		public  C_Job  get(int id);
		
		//fetch a particular C_Job_Application
		
		public boolean deleteJob(int jobid);
		
		//fetch all jobs
		
		public List<C_Job> list();
		
		
		//fetch all the jobs based on status
		
		public List<C_Job> list(char status);
		
		
		public boolean   isJobOpened(int id);
		
		
		
		///c_job application
		
		
		//apply for a particular c_job
		
		public  boolean    save(C_Job_Application c_job_application);
		
		//Admin can reject/accept/call for interview
		
		public  boolean    update(C_Job_Application c_job_application);
		
		//Admin want to know the list of user those applid
		//for particular c_job
		
		public  List<C_Job_Application> list(int jobID);
		
		
		//Admin want fetch all the details of particular
		//c_job based on status
		
		public  List<C_Job_Application> list(int jobID,char status);
		
		public  List<C_Job_Application> applicationlist();
		public  C_Job_Application get(String login_name, int jobID);
		
		public List<C_Job_Application> jobApplicationList(String login_name);
		
		public  C_Job_Application  getApplication(int id);
}
