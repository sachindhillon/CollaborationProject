package com.sachin.project2.domain;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component("c_blog_comment")
@Entity
@Table
public class C_Blog_Comment extends BaseDomain implements Serializable {
	@Id
	private int blogComment_id;
	private String login_name;
	//private String commentUserName;
	private int  blog_id;
	private String comments;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	private Date commented_date;
	public int getBlogComment_id() {
		return blogComment_id;
	}
	public void setBlogComment_id(int blogComment_id) {
		this.blogComment_id = blogComment_id;
	}
	
	public int getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getCommented_date() {
		return commented_date;
	}
	public void setCommented_date(Date commented_date) {
		this.commented_date = commented_date;
	}
	
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	

}
