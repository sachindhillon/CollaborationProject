package com.sachin.project2.domain;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component("c_blog")
@Entity
@Table
public class C_Blog extends BaseDomain implements Serializable {
	@Id
	private int blog_id;
	private String blog_title;
	private String emailID;
	private Clob blog_description;
	private Date blog_created_date;
	private Character blog_status;
	private Character blog_remarks;
	private int blog_likes;
	private int blog_unlikes;
	public int getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}
	public String getBlog_title() {
		return blog_title;
	}
	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public Clob getBlog_description() {
		return blog_description;
	}
	public void setBlog_description(Clob blog_description) {
		this.blog_description = blog_description;
	}
	public Date getBlog_created_date() {
		return blog_created_date;
	}
	public void setBlog_created_date(Date blog_created_date) {
		this.blog_created_date = blog_created_date;
	}
	public Character getBlog_status() {
		return blog_status;
	}
	public void setBlog_status(Character blog_status) {
		this.blog_status = blog_status;
	}
	public Character getBlog_remarks() {
		return blog_remarks;
	}
	public void setBlog_remarks(Character blog_remarks) {
		this.blog_remarks = blog_remarks;
	}
	public int getBlog_likes() {
		return blog_likes;
	}
	public void setBlog_likes(int blog_likes) {
		this.blog_likes = blog_likes;
	}
	public int getBlog_unlikes() {
		return blog_unlikes;
	}
	public void setBlog_unlikes(int blog_unlikes) {
		this.blog_unlikes = blog_unlikes;
	}
	

}
