package com.sachin.collaborationbackendsach;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sachin.project2.dao.C_ForumDAO;
import com.sachin.project2.domain.C_Forum;

public class C_ForumDAOTestCase {
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static C_ForumDAO c_forumDAO;
	@Autowired
	private static C_Forum c_forum;
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sachin.project2");
		context.refresh();

		c_forumDAO=(C_ForumDAO) context.getBean("c_forumDAO");

		c_forum = (C_Forum) context.getBean("c_forum");
		

	}
	@Test
	public void saveForumTestCase()
	{
		c_forum.setForum_name("java");
		c_forum.setLogin_name("sachin@gmail.com");
		c_forum.setForum_description("javva is a programming language used to develop applications and do many more.");
		Assert.assertEquals("saveForumTestCase", true,c_forumDAO.save(c_forum));
	}
@Test
public void getAllForums()
{
	Assert.assertEquals(4,c_forumDAO.list().size());
}

}
