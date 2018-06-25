package com.sachin.project2.daoimple;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sachin.project2.dao.C_UserDAO;
import com.sachin.project2.domain.C_User;

@Repository("c_userDAO")
@Transactional
public class C_UserDAOImple implements C_UserDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private C_User c_user;
	
	//create a new user
	public boolean save(C_User c_user) {
		
		try {
			if(c_user.getRole() == null || c_user.getRole()==' ')
			{
				c_user.setRole('S');
			}
			c_user.setStatus('N');
			
			sessionFactory.getCurrentSession().save(c_user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	//update a user
	public boolean update(C_User c_user) {
		try {
			sessionFactory.getCurrentSession().update(c_user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	//delete a user
	public boolean delete(String login_name) {
		try {	
						// before delete, first check whether the record
						C_User c_user = getUser(login_name);
						//existing or not
						//if the record does not exist, simply return false;
						if(c_user==null)
						{
							return false;
						}
						//if the record exist, the delete
						//method return true if deleted
						//else false
			sessionFactory.getCurrentSession().delete(c_user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	// to get a particular user based on email id
	public C_User getUser(String login_name) {
		return sessionFactory.getCurrentSession().get(C_User.class, login_name);
	}

	// get list of all users
	public List<C_User> userList() {
		return sessionFactory.getCurrentSession().createQuery("from C_User").list();
	}

	// to validate user if email id and password are right
	//return user if credentials are right
	//else return null
	public C_User validateUser(String user_email, String user_password) {
		C_User c_user;
		c_user = (C_User) sessionFactory.getCurrentSession().createCriteria(C_User.class)
				.add(Restrictions.eq("user_email", user_email))
				.add(Restrictions.eq("user_password", user_password)).uniqueResult();
		return c_user;
	}

	public C_User get(String login_name) {
		
		return sessionFactory.getCurrentSession().get(C_User.class,login_name);
	}

}
