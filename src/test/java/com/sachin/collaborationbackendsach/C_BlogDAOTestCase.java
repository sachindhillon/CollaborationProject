package com.sachin.collaborationbackendsach;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sachin.project2.dao.C_BlogDAO;
import com.sachin.project2.dao.C_JobDAO;
import com.sachin.project2.domain.C_Blog;
import com.sachin.project2.domain.C_Blog_Comment;
import com.sachin.project2.domain.C_Job;
import com.sachin.project2.domain.C_Job_Application;

public class C_BlogDAOTestCase {
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static C_BlogDAO c_blogDAO;
	@Autowired
	private static C_Blog c_blog;
	@Autowired
	private static C_Blog_Comment c_blog_comment;
	

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sachin.project2");
		context.refresh();

		c_blogDAO=(C_BlogDAO) context.getBean("c_blogDAO");

		c_blog = (C_Blog) context.getBean("c_blog");
		c_blog_comment = (C_Blog_Comment) context.getBean("c_blog_comment");

	}
	@Test
	public void saveBlogTestCase()
	{
		c_blog.setBlog_title("java");
		c_blog.setLogin_name("sachin@gmail.com");
		c_blog.setBlog_description("javva is a programming language used to develop applications and do many more.");
		Assert.assertEquals("saveBlogTestCase", true,c_blogDAO.save(c_blog));
	}

	@Test
	public void updateBlogTestCase()
	{
		c_blog=c_blogDAO.get(101);
		c_blog.setBlog_likes(1);
		Assert.assertEquals("updateBlogTestCase", true,c_blogDAO.update(c_blog));
	}
	
	@Test
	public void getBlogSuccessTestCase()
	{
		Assert.assertNotNull(c_blogDAO.get(101));
	}
	
	@Test
	public void getBlogFailureTestCase()
	{
		C_Blog c_blog=c_blogDAO.get(101);
		System.out.println(c_blog.getBlog_id());
		System.out.println(c_blog.getBlog_description());
		Assert.assertNotNull(c_blogDAO.get(102));
	}
	
	@Test
	public void getAllBlogs()
	{
		Assert.assertEquals(4,c_blogDAO.list().size());
	}
	
	//to comment on a particular blog
	@Test
	public void commentOnBlogTestCase()
	{
		c_blog_comment.setLogin_name("sachin@gmail.com");
		c_blog_comment.setBlog_id(101);
		c_blog_comment.setComments("you can do it better");
		Assert.assertEquals("commentOnBlogtestCase",true,c_blogDAO.save(c_blog_comment));
	}
	
	@Test
	public void commentListOnParticularBlog()
	{
		Assert.assertEquals(3,c_blogDAO.list(101).size());
	}
}
