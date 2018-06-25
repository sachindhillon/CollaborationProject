package com.sachin.project2.daoimple;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sachin.project2.dao.C_BlogDAO;
import com.sachin.project2.dao.C_UserDAO;
import com.sachin.project2.domain.C_Blog;
import com.sachin.project2.domain.C_Blog_Comment;

@Repository("c_blogDAO")
@Transactional
public class C_BlogDAOImple implements C_BlogDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private C_UserDAO c_userDAO;
	@Autowired
	private C_Blog c_blog;

	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	//get the highest value of blog id from the database if id exists else return 100
	private int getMaxBlogID() {
		int maxValue = 100;
		try {
			maxValue = (Integer) getCurrentSession().createQuery("select max(blog_id) from C_Blog").uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return 100;
		}

		return maxValue;
	}
	
//get the highest value of blog_comment id from the database if id exists else return 100
	private int commentId() {
		int maxValue = 100;
		try {
			maxValue = (Integer) getCurrentSession().createQuery("select max(blogComment_id) from C_Blog_Comment").uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return 100;
		}

		return (maxValue+1);
	}
	// to add a blog
	public boolean save(C_Blog c_blog) {
		
		try {
			c_blog.setBlog_created_date(new Date(System.currentTimeMillis()));
			c_blog.setBlog_id(getMaxBlogID()+1);
			c_blog.setBlog_status('N');
			c_blog.setBlog_likes(0);
			c_blog.setBlog_unlikes(0);
			getCurrentSession().save(c_blog);
			return true;
		} catch (Exception e) {
		
			e.printStackTrace();
			return false;
		}
		
	}
	// to update the blog
	public boolean update(C_Blog c_blog) {

		try {
			getCurrentSession().update(c_blog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	// to get a particular blog
	public C_Blog get(int blog_id) {
	
		return (C_Blog) getCurrentSession().createCriteria(C_Blog.class).add(Restrictions.eq("blog_id",blog_id)).uniqueResult();
	}

	// to get the list of all blogs
	public List<C_Blog> list() {
	
		return getCurrentSession().createQuery("from C_Blog").list();
	}

	//to add a blog_comment 
	public Boolean save(C_Blog_Comment c_blog_comment) {
	try {
		
		c_blog_comment.setCommented_date(new Date(System.currentTimeMillis()));
		c_blog_comment.setBlogComment_id(commentId());
		getCurrentSession().save(c_blog_comment);
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}

	}

	// to delete a particular blog
	public boolean delete(int blog_id) {
		try {
			getCurrentSession().delete(get(blog_id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	// to get list of blogs based on status
	public List<C_Blog> list(char blog_status)
	{
		return getCurrentSession().createCriteria(C_Blog.class).add(Restrictions.eq("blog_status", blog_status)).list();
	}

	// to get all comments on particular blog
	public List<C_Blog_Comment> list(int blog_id) {
		return getCurrentSession().createCriteria(C_Blog_Comment.class).add(Restrictions.eq("blog_id", blog_id)).list();
	}

}
