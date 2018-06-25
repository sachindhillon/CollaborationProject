package com.sachin.project2.dao;

import java.util.List;

import com.sachin.project2.domain.C_Blog;
import com.sachin.project2.domain.C_Blog_Comment;

public interface C_BlogDAO {

	public boolean save(C_Blog c_blog);
	public boolean update(C_Blog c_blog);
	public C_Blog get(int blog_id);
	public List<C_Blog>    list();
	public List<C_Blog> list(char blog_status);
	public boolean delete(int blog_id);
	
	//admin can accept/reject the c_blog
	//we can use update(C_Blog c_blog) method.
	
	//comment on a particular c_blog
	public Boolean save(C_Blog_Comment c_blog_comment);
	//one to many ->  N number of user can comment on
	// a particular c_blog.
	public List<C_Blog_Comment> list(int blog_id);
}
