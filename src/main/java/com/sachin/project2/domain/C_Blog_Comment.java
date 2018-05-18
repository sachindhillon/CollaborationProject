package com.sachin.project2.domain;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.Id;

public class C_Blog_Comment extends BaseDomain implements Serializable {
	@Id
	private int blogComment_id;
	private String emailID;
	private int  blog_id;
	private Clob comments;
	private Date commented_date;
	public int getBlogComment_id() {
		return blogComment_id;
	}
	public void setBlogComment_id(int blogComment_id) {
		this.blogComment_id = blogComment_id;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public int getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}
	public Clob getComments() {
		return comments;
	}
	public void setComments(Clob comments) {
		this.comments = comments;
	}
	public Date getCommented_date() {
		return commented_date;
	}
	public void setCommented_date(Date commented_date) {
		this.commented_date = commented_date;
	}


}
