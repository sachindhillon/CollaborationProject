package com.sachin.project2.dao;

import java.util.List;

import com.sachin.project2.domain.C_User;

public interface C_UserDAO {
public boolean save(C_User c_user);
	
	//update c_user details
	public boolean update(C_User c_user);
	
	public boolean delete(String user_email);
	
	//see/fetch/get the details
	
	public C_User   getUser(String user_email);
	
	//admin may fetch all the c_user details
	
	public  List<C_User>     userList();
	
	//login - validation
	
	public C_User validateUser(String user_email,  String user_password);

}
