package com.sachin.project2.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table
public class C_ProfilePicture {
	@Id
	private String login_name;
	private byte[] profile_pic;
	
	
	
	public byte[] getProfile_pic() {
		return profile_pic;
	}
	public void setProfile_pic(byte[] profile_pic) {
		this.profile_pic = profile_pic;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	
	

}
