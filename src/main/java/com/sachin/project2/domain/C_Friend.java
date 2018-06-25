package com.sachin.project2.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component("c_friend")
@Entity
@Table
public class C_Friend extends BaseDomain{
	@Id
	private int friend_id;
	private String login_name;
	private String friend_name;
	private Character status;
	public int getFriend_id() {
		return friend_id;
	}
	public void setFriend_id(int friend_id) {
		this.friend_id = friend_id;
	}

	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}

	public String getFriend_name() {
		return friend_name;
	}
	public void setFriend_name(String friend_name) {
		this.friend_name = friend_name;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	
	

}
