package com.sachin.collaborationbackendsach;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sachin.project2.dao.C_UserDAO;
import com.sachin.project2.domain.C_User;

public class C_UserDAOTestcase {

private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static C_UserDAO c_userDAO;
	
	@Autowired
	private static C_User c_user;
	
	//we need create instance of AnnotationConfigApplicationContext
	//only once
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.sachin.project2");
		context.refresh();
		
		c_userDAO = (C_UserDAO) context.getBean("c_userDAO");
		
		c_user = (C_User) context.getBean("c_user");
		
	}
	
	@Test
	public void addUserTestCase()
	{
		c_user.setUser_email("sac@gmail.com");
		c_user.setUsername("sac");
		c_user.setDetails(" cute");
		c_user.setUser_password("sac@123");
		c_user.setMobile("1234567890");
		//boolean actual = c_userdao.save(c_user);
		Assert.assertEquals("Add C_User Test Case" , true  , c_userDAO.save(c_user));
		
	}
	
	@Test
	public void updateUserTestCase()
	{
		//c_user = new C_User();
		//c_user.setEmailID("jivan@gmail.com");
		
		
		c_user = c_userDAO.getUser("jivan@gmail.com");
		
		c_user.setMobile("77777777");
		
		boolean actual = c_userDAO.update(c_user);
		
	    Assert.assertEquals("Update C_User", true, actual );
		
		
		
		
		
		
	}
	
	
	
	@Test
	public void getUserTestCase()
	{
		
		Assert.assertNotNull("Get C_User Test Cases", c_userDAO.getUser("jivan@gmail.com"));
	}
	
	//delete test case
	
	//get all c_user test cases
	
	//validate test
	
	
	
	
	@Test
	public void validateUserTestCase()
	{
	 Assert.assertNotNull("Validate Testcase",c_userDAO.validateUser("jaya@gmail.com", "jaya@1234"));
	}
	
	@Test
	public void deleteUserTestCase()
	{
	boolean actual=	   c_userDAO.delete("jivan@gmail.com");
	Assert.assertEquals(true, actual);
	}
	@Test
	public void getAllUsers()
	{
		int actualSize = c_userDAO.userList().size();
		Assert.assertEquals(6, actualSize);
	}

}
