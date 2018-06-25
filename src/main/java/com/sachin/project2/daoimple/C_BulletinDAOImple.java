package com.sachin.project2.daoimple;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sachin.project2.dao.C_BulletinDAO;
import com.sachin.project2.domain.C_Blog;
import com.sachin.project2.domain.C_Bulletin;

@Repository("c_bulletinDAO")
@Transactional
public class C_BulletinDAOImple implements C_BulletinDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private C_Bulletin c_bulletin;
	
	
	

	private int getMaxBulletinId() {
		int maxValue = 100;
		try {
			maxValue = (Integer) getCurrentSession().createQuery("select max(bulletin_id) from C_Bulletin")
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return 100;
		}
		return maxValue;
	}
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean save(C_Bulletin c_bulletin) {
		try {
			getCurrentSession().save(c_bulletin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean update(C_Bulletin c_bulletin) {
		try {
			getCurrentSession().update(c_bulletin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public C_Bulletin get(int bulletin_id) {
		return (C_Bulletin) getCurrentSession().createCriteria(C_Bulletin.class).add(Restrictions.eq("bulletin_id",bulletin_id)).uniqueResult();
	}

	public List<C_Bulletin> list() {
		return getCurrentSession().createQuery("from C_Bulletin").list();
	}

}
