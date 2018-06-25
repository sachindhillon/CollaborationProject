package com.sachin.project2.domain;

public class Message {
	private int id;
	private String message;

	//getter and setter methods

	public Message()
	{}
	public Message(int id,String message)
	{
	this.id=id;
	this.message=message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
