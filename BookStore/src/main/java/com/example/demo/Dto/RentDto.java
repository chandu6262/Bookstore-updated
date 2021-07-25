package com.example.demo.Dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
public class RentDto {
	@JsonProperty(value = "user_id") 
	private int rental_id;

	@JsonProperty(value = "user_id") 
	private Date issued_date;

	@JsonProperty(value = "user_id") 
	private Date returned_date;

	@JsonProperty(value = "user_id") 
	private float amount;

	public int getRental_id() {
		return rental_id;
	}

	public void setRental_id(int rental_id) {
		this.rental_id = rental_id;
	}

	public Date getIssued_date() {
		return issued_date;
	}

	public void setIssued_date(Date issued_date) {
		this.issued_date = issued_date;
	}

	public Date getReturned_date() {
		return returned_date;
	}

	public void setReturned_date(Date returned_date) {
		this.returned_date = returned_date;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
