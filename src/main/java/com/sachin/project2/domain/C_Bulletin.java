package com.sachin.project2.domain;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component("c_bulletin")
@Entity
@Table
public class C_Bulletin {
	@Id
	private int bulletin_id	;
	private String bulletin_title;
	private String bulletin_description;
	private Blob bulletin_image;
	private Date bulletin_date;
	public int getBulletin_id() {
		return bulletin_id;
	}
	public void setBulletin_id(int bulletin_id) {
		this.bulletin_id = bulletin_id;
	}
	public String getBulletin_title() {
		return bulletin_title;
	}
	public void setBulletin_title(String bulletin_title) {
		this.bulletin_title = bulletin_title;
	}
	public String getBulletin_description() {
		return bulletin_description;
	}
	public void setBulletin_description(String bulletin_description) {
		this.bulletin_description = bulletin_description;
	}
	public Blob getBulletin_image() {
		return bulletin_image;
	}
	public void setBulletin_image(Blob bulletin_image) {
		this.bulletin_image = bulletin_image;
	}
	public Date getBulletin_date() {
		return bulletin_date;
	}
	public void setBulletin_date(Date bulletin_date) {
		this.bulletin_date = bulletin_date;
	}

}
