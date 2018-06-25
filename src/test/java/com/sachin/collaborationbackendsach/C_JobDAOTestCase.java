package com.sachin.collaborationbackendsach;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sachin.project2.dao.C_JobDAO;
import com.sachin.project2.domain.C_Job;
import com.sachin.project2.domain.C_Job_Application;

public class C_JobDAOTestCase {
	private static AnnotationConfigApplicationContext context;

	@Autowired
	private static C_JobDAO c_jobDAO;

	@Autowired
	private static C_Job c_job;

	@Autowired
	private static C_Job_Application jobApplication;

	// we need create instance of AnnotationConfigApplicationContext
	// only once
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sachin.project2");
		context.refresh();

		c_jobDAO = (C_JobDAO) context.getBean("c_jobDAO");

		c_job = (C_Job) context.getBean("c_job");
		jobApplication = (C_Job_Application) context.getBean("c_job_application");

	}

	@Test
	public void saveJobTestCase() {

		c_job.setJob_description("This is Technical Manager c_job.");
		c_job.setNo_of_openings(3);
		c_job.setJob_qualification("M.Tech");
		c_job.setJob_salary(60000);
		c_job.setJob_title("Technical Manager");

		Assert.assertEquals("Save c_job test case", true, c_jobDAO.save(c_job));

	}

	@Test
	public void updateJobTestCaseSuccess() {
		c_job = c_jobDAO.get(101);
		c_job.setJob_status('N');
		c_job.setJob_qualification("B.Sc");

		Assert.assertEquals(true, c_jobDAO.update(c_job));
	}

	@Test
	public void updateJobTestCaseFailure() {
		c_job = c_jobDAO.get(105);

		Assert.assertNotNull(c_job);
		c_job.setJob_status('N');
		c_job.setJob_qualification("B.Sc");

		Assert.assertEquals(true, c_jobDAO.update(c_job));
	}
	
	@Test
	public void getJobSuccessTestCase()
	{
		Assert.assertNotNull( c_jobDAO.get(101));
	}
	
	@Test
	public void getJobFailureTestCase()
	{
		Assert.assertNull( c_jobDAO.get(108));
	}
	
	@Test
	public void getAllJobsTestCase()
	{
	Assert.assertEquals(4,	c_jobDAO.list().size());
	}
	
	@Test
	public void closeJobTestCase()
	{
	c_job=	c_jobDAO.get(101);
	c_job.setJob_status('C');
	 Assert.assertEquals(true ,c_jobDAO.update(c_job));
	}
	@Test
	public void isJobOpendSuccessTestCase()
	{
	   Assert.assertEquals(true,	c_jobDAO.isJobOpened(102));
	}
	
	@Test
	public void isJobOpendFailureTestCase()
	{
	   Assert.assertEquals(false,	c_jobDAO.isJobOpened(103));
	}
	
	//========================================================================//
	
	//JOB Application related test cases
	
	@Test
	public void applyForAJobSuccessTestCase()
	{
		jobApplication.setLogin_name("sac@gmail.com");
		jobApplication.setJob_id(102);
		Assert.assertEquals(true ,c_jobDAO.save(jobApplication));
	}
	
	@Test
	public void applyForAJobFailureTestCase()
	{
		jobApplication.setLogin_name("jaya@123");
		jobApplication.setJobApp_Id(101);
		Assert.assertEquals(false ,c_jobDAO.save(jobApplication));
	}
	
	@Test public void isJobAlreadyAppliedSuccessTestCase()
	{
		Assert.assertEquals(true ,c_jobDAO.get("sachin@gmail.com", 102));
	}
	
	@Test public void isJobAlreadyAppliedFailureTestCase()
	{
		Assert.assertEquals(false ,c_jobDAO.get("koffi@gmail.com", 102));
	}
}
