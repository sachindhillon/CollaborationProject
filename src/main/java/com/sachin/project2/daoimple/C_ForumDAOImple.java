package com.sachin.project2.daoimple;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sachin.project2.dao.C_ForumDAO;
import com.sachin.project2.dao.C_UserDAO;
import com.sachin.project2.domain.C_Forum;
import com.sachin.project2.domain.C_Forum_Discussion;

@Repository("c_forumDAO")
@Transactional
public class C_ForumDAOImple implements C_ForumDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private C_UserDAO c_userDAO;
	@Autowired
	private C_Forum c_forum;

	// to get the session
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	// get the highest value of forum id from the database if id exists else return 100
	private int getMaxForumID() {
		int maxValue = 100;
		try {
			maxValue = (Integer) getCurrentSession().createQuery("select max(forum_id) from C_Forum").uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return 100;
		}

		return (maxValue+1);
	}
	
	private int getMaxForumDiscussionID() {
		int maxValue = 100;
		try {
			maxValue = (Integer) getCurrentSession().createQuery("select max(discussion_id) from C_Forum_Discussion").uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return 100;
		}

		return (maxValue+1);
	}

	// add a forum
	public boolean save(C_Forum c_forum) {
		
		try {
			c_forum.setForum_created_date(new Date(System.currentTimeMillis()));
			c_forum.setForum_id(getMaxForumID()+1);
			c_forum.setForum_status('N');
			c_forum.setForum_likes(0);
			c_forum.setForum_unlikes(0);
			getCurrentSession().save(c_forum);
			return true;
		} catch (Exception e) {
		
			e.printStackTrace();
			return false;
		}	
	}
	// for updating details of the forum
	public boolean update(C_Forum c_forum) {

		try {
			getCurrentSession().update(c_forum);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//get forum with particular forum id
	public C_Forum get(int forum_id) {
	
		return (C_Forum) getCurrentSession().createCriteria(C_Forum.class).add(Restrictions.eq("forum_id",forum_id)).uniqueResult();
	}
	
	// fetching all the forums
	public List<C_Forum> list() {
	
		return getCurrentSession().createQuery("from C_Forum").list();
	}

	
	// delete a particular forum
	public boolean delete(int forum_id) {
		try {
			getCurrentSession().delete(get(forum_id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	
	// fetch list of forums based on status of the forum
	public List<C_Forum> list(char forum_status)
	{
		return getCurrentSession().createCriteria(C_Forum.class).add(Restrictions.eq("forum_status", forum_status)).list();
	}

	public Boolean save(C_Forum_Discussion c_forum_discussion) {
		try {
			c_forum_discussion.setDiscussion_date(new Date(System.currentTimeMillis()));
			c_forum_discussion.setDiscussion_id(getMaxForumDiscussionID());
			getCurrentSession().save(c_forum_discussion);
				return true;		
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}

	public List<C_Forum_Discussion> list(int forum_id) {		
		return getCurrentSession().createCriteria(C_Forum_Discussion.class).add(Restrictions.eq("forum_id",forum_id)).list();
	}

	


}
