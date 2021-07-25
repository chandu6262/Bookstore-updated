package com.example.demo.Dto;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PublisherDto {
	@JsonProperty(value = "user_id") 	
	private int publisher_id;

	@JsonProperty(value = "user_id") 
	private String publisher_name;

	@JsonProperty(value = "user_id") 
	private Date date_of_birth;

	@JsonProperty(value = "user_id") 
	private Date date_of_publishing;

	public int getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}

	public String getPublisher_name() {
		return publisher_name;
	}

	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public Date getDate_of_publishing() {
		return date_of_publishing;
	}

	public void setDate_of_publishing(Date date_of_publishing) {
		this.date_of_publishing = date_of_publishing;
	}

}
