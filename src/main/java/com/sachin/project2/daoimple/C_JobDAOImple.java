package com.sachin.project2.daoimple;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sachin.project2.dao.C_JobDAO;
import com.sachin.project2.dao.C_UserDAO;
import com.sachin.project2.domain.C_Job;
import com.sachin.project2.domain.C_Job_Application;

@Repository("c_jobDAO")
@Transactional
public class C_JobDAOImple implements C_JobDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private C_UserDAO c_userDAO;
	@Autowired
	private C_Job_Application c_job_application;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * return max c_Job id of all the records if the records are exist else return
	 * 100
	 * 
	 * @return
	 */
	private int getMaxJobID() {
		int maxValue = 100;
		try {
			maxValue = (Integer) getCurrentSession().createQuery("select max(job_id) from C_Job").uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return 100;
		}

		return maxValue;
	}
	// get the highest value of job application id from the database if id exists else return 100
	private int getMaxJobapplicationID() {
		int maxValue = 100;
		try {
			maxValue = (Integer) getCurrentSession().createQuery("select max(jobApp_Id) from C_Job_Application")
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return 100;
		}
		return maxValue;
	}

	//to create a job
	public boolean save(C_Job c_Job) {
		try {
			c_Job.setJob_id(getMaxJobID() + 1);
			c_Job.setJob_posted_date(new Date(System.currentTimeMillis()));
			c_Job.setJob_status('N');
			getCurrentSession().save(c_Job);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//to update the job
	public boolean update(C_Job c_Job) {
		try {
			getCurrentSession().update(c_Job);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//get a job based on job_id
	public C_Job get(int jobID) {
		return (C_Job) getCurrentSession().createCriteria(C_Job.class).add(Restrictions.eq("job_id", jobID)).uniqueResult();
	}

	//to get all the jobs
	public List<C_Job> list() {
		return getCurrentSession().createQuery("from C_Job").list();
	}

	//to get list of jobs based on status of job
	public List<C_Job> list(char status) {
		return getCurrentSession().createCriteria(C_Job.class).add(Restrictions.eq("job_status", status)).list();

	}

	public boolean save(C_Job_Application jobApplication) {
		try {
			/*if (!isJobOpened(jobApplication.getJob_id())) {
				return false;
			}
			// if you already applied, you can not apply again
			if (get(jobApplication.getJobApp_email(), jobApplication.getJob_id())==null) {
				return false;
			}

			// if user does not exist, you can not apply

			if (c_userDAO.getUser(jobApplication.getJobApp_email()) == null) {
				return false;
			}

			// if the c_Job does not exist, you can not apply
			if (get(jobApplication.getJob_id()) == null) {
				return false;
			}*/

			jobApplication.setJobApp_Id(getMaxJobapplicationID() + 1);
			jobApplication.setJobApp_status('N');
			jobApplication.setApplied_date(new Date(System.currentTimeMillis()));
			getCurrentSession().save(jobApplication);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//to update details of job application
	public boolean update(C_Job_Application jobApplication) {
		try {
			getCurrentSession().update(jobApplication);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//to get list of job applications with particular job_id
	public List<C_Job_Application> list(int jobID) {
		return getCurrentSession().createCriteria(C_Job_Application.class).add(Restrictions.eq("job_id", jobID)).list();

	}
	//to get list of job applications based on job_id and status of job Application
	public List<C_Job_Application> list(int jobID, char status) {
		return getCurrentSession().createCriteria(C_Job_Application.class).add(Restrictions.eq("job_id", jobID))
				.add(Restrictions.eq("jobApp_status", status)).list();

	}

	/**
	 * This method will return true, if the c_Job with id exist and status is open.
	 * else return false.
	 */
	public boolean isJobOpened(int id) {
		C_Job c_Job = (C_Job)sessionFactory.getCurrentSession().createCriteria(C_Job.class).add(Restrictions.eq("job_id", id))
				.uniqueResult();
		if (c_Job != null && c_Job.getJob_status() == 'N') {
			return true;
		}
		return false;
	}

	/**
	 * This method will return application if the c_Job already applied with this emailid.
	 * else, return false
	 */

	//get a job application based on emailid and job_id
	public C_Job_Application get(String login_name, int jobID) {

		// select * from C_Job_Application where emailID = ? and jobID = ?
		return (C_Job_Application)getCurrentSession()
				.createCriteria(C_Job_Application.class).add(Restrictions.eq("login_name", login_name))
				.add(Restrictions.eq("job_id", jobID)).uniqueResult();

	}

	//get list of job applications based on email_id
	public List<C_Job_Application> jobApplicationList(String login_name) {
		 return getCurrentSession().createCriteria(C_Job_Application.class).add(Restrictions.eq("login_name", login_name)).list();
	}

	//delete a job using job_id
	public boolean deleteJob(int jobid) {
		try {
			getCurrentSession().delete(get(jobid));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<C_Job_Application> applicationlist() {
		return getCurrentSession().createQuery("from C_Job_Application").list();
	}

	public C_Job_Application getApplication(int id) {
		// TODO Auto-generated method stub
		return (C_Job_Application) getCurrentSession().createCriteria(C_Job_Application.class).add(Restrictions.eq("jobApp_Id",id)).uniqueResult();
	}
}
