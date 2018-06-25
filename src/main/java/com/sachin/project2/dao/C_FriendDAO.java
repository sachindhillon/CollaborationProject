package com.sachin.project2.dao;

import java.util.List;

import com.sachin.project2.domain.C_Friend;
import com.sachin.project2.domain.C_User;

public interface C_FriendDAO {
	public List<C_Friend> friendsList(String user_name);
	public List<C_Friend> pendingFriendRequest(String user_name);
	public List<C_User> suggestedFriendList(String user_name);
	
	public boolean sendFriendRequest(C_Friend c_friend);
	public boolean acceptFriendRequest(int friend_id);
	public boolean deleteFriendRequest(int friend_id);
	public C_Friend get(int friendid);

}
