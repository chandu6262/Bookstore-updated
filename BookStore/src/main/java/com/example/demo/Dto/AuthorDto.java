package com.example.demo.Dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorDto {
	@JsonProperty(value = "author_id") 
private int author_id;
	
	@JsonProperty(value = "author_name") 
	private String author_name;
	
	@JsonProperty(value = "date_of_birth") 
	private Date date_of_birth;

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
}
