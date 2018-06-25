package com.sachin.project2.daoimple;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sachin.project2.dao.C_ProfilePictureDAO;
import com.sachin.project2.domain.C_ProfilePicture;

@Repository("c_profilepictureDAO")
@Transactional
public class C_ProfilePictureDAOImple implements C_ProfilePictureDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}


	public boolean save(C_ProfilePicture c_profilepicture) {
		try {
			getCurrentSession().saveOrUpdate(c_profilepicture);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public C_ProfilePicture get(String profile_username) {
		
	C_ProfilePicture c_profilepicture =	(C_ProfilePicture)getCurrentSession().get(C_ProfilePicture.class,profile_username);
	return c_profilepicture;
	}
	

}
