package com.sachin.collaborationbackendsach;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sachin.project2.dao.C_ForumDAO;
import com.sachin.project2.dao.C_FriendDAO;
import com.sachin.project2.domain.C_Forum;
import com.sachin.project2.domain.C_Friend;

public class C_FriendDAOTestCase {
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static C_FriendDAO c_friendDAO;
	
	@Autowired
	private static C_Friend c_friend;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sachin.project2");
		context.refresh();

		c_friendDAO=(C_FriendDAO) context.getBean("c_friendDAO");

		c_friend= (C_Friend) context.getBean("c_friend");
		

	}
	
	@Test
	public void sendRequest()
	{
		
		c_friend.setLogin_name("sachin");
		
		c_friend.setFriend_name("shubham");
		Assert.assertEquals("sendRequest",true,c_friendDAO.sendFriendRequest(c_friend));
	}
	
	@Test
	public void getPendingFriendsList()
	{
		Assert.assertEquals(1,c_friendDAO.pendingFriendRequest("jaskaran@gmail.com").size());
	}
	
	@Test
	public void getsuggestedFriendsList()
	{
		Assert.assertEquals(1,c_friendDAO.suggestedFriendList("sachin@gmail.com").size());
	}
	@Test
	public void getFriendsList()
	{
		Assert.assertEquals(4,c_friendDAO.friendsList("sachin@gmail.com").size());
	}
}
