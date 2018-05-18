package com.sachin.project2.dao;

import java.util.List;

import com.sachin.project2.domain.C_Blog;

public interface C_BlogDAO {

	public boolean save(C_Blog c_blog);
	public boolean update(C_Blog c_blog);
	public C_Blog get(int id);
	public List<C_Blog>    list();
	
	//adming can accept/reject the c_blog
	//we can use update(C_Blog c_blog) method.
	
	//comment on a particular c_blog
	
	//one to many ->  N number of user can comment on
	// a particular c_blog.
}
