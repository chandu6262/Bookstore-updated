package com.example.demo.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDto {

	@JsonProperty(value = "book_id") 
	private int book_id;
	
	@JsonProperty(value = "book_name") 
	private String book_name;
	
	@JsonProperty(value = "price") 
	private float price;

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
