package com.sachin.project2.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;



@Component("c_forum")
@Entity
@Table
public class C_Forum extends BaseDomain {
	@Id
	private int forum_id;
	private String login_name;
	private String forum_name;
	private String forum_description;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	private Date forum_created_date;
	private int forum_likes;
	private int forum_unlikes;
	private Character forum_status;
	public int getForum_id() {
		return forum_id;
	}
	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}

	public String getForum_name() {
		return forum_name;
	}
	public void setForum_name(String forum_name) {
		this.forum_name = forum_name;
	}
	public String getForum_description() {
		return forum_description;
	}
	public void setForum_description(String forum_description) {
		this.forum_description = forum_description;
	}
	public Date getForum_created_date() {
		return forum_created_date;
	}
	public void setForum_created_date(Date forum_created_date) {
		this.forum_created_date = forum_created_date;
	}
	public int getForum_likes() {
		return forum_likes;
	}
	public void setForum_likes(int forum_likes) {
		this.forum_likes = forum_likes;
	}
	public int getForum_unlikes() {
		return forum_unlikes;
	}
	public void setForum_unlikes(int forum_unlikes) {
		this.forum_unlikes = forum_unlikes;
	}
	public Character getForum_status() {
		return forum_status;
	}
	public void setForum_status(Character forum_status) {
		this.forum_status = forum_status;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

}
