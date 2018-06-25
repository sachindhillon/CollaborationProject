package com.sachin.project2.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sachin.project2.domain.C_Forum;
import com.sachin.project2.domain.C_Forum_Discussion;

public interface C_ForumDAO {
	public boolean save(C_Forum c_forum);
	public boolean update(C_Forum c_forum);
	public C_Forum get(int forum_id);
	public List<C_Forum>    list();
	public List<C_Forum> list(char forum_status);
	public boolean delete(int forum_id);
	
	//admin can accept/reject the c_forum
	//we can use update(C_Forum c_forum) method.
	
	//comment on a particular c_forum
	
	//one to many ->  N number of user can comment on
	// a particular c_forum.
	public Boolean save(C_Forum_Discussion c_forum_discussion);
	
	public List<C_Forum_Discussion> list(int forum_id);

}
