package com.sachin.project2.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
@Component
@Entity
@Table
public class C_Forum_Discussion extends BaseDomain{
	@Id
	private int discussion_id;
	private String login_name;
	private int  forum_id;
	private String discussion;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	private Date discussion_date;
	public int getDiscussion_id() {
		return discussion_id;
	}
	public void setDiscussion_id(int discussion_id) {
		this.discussion_id = discussion_id;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public int getForum_id() {
		return forum_id;
	}
	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}
	public String getDiscussion() {
		return discussion;
	}
	public void setDiscussion(String discussion) {
		this.discussion = discussion;
	}
	public Date getDiscussion_date() {
		return discussion_date;
	}
	public void setDiscussion_date(Date discussion_date) {
		this.discussion_date = discussion_date;
	}

}
