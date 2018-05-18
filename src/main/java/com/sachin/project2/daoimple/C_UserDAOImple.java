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

	public boolean delete(String user_email) {
		try {	
						// before delete, first check whether the record
						C_User c_user = getUser(user_email);
						//existing or not
						//if the record does not exist, simply return false;
						if(c_user==null)
						{
							return false;
						}
						//if the record exist, the delete
			
			sessionFactory.getCurrentSession().delete(c_user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public C_User getUser(String user_email) {
		return sessionFactory.getCurrentSession().get(C_User.class, user_email);
	}

	public List<C_User> userList() {
		return sessionFactory.getCurrentSession().createQuery("from C_User").list();
	}

	public C_User validateUser(String user_email, String user_password) {
		C_User c_user;
		c_user = (C_User) sessionFactory.getCurrentSession().createCriteria(C_User.class)
				.add(Restrictions.eq("user_email", user_email))
				.add(Restrictions.eq("user_password", user_password)).uniqueResult();
		return c_user;
	}

}
