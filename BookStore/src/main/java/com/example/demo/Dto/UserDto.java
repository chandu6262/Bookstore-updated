package com.example.demo.Dto;

import java.util.List;
import com.example.demo.Entity.Address;
import com.example.demo.Entity.Books;
import com.example.demo.Entity.Orders;
import com.example.demo.Entity.Rent;
import com.example.demo.Entity.RentedBooksDetails;
import com.example.demo.Entity.Role;


public class UserDto {

	private int user_id;
	private String user_type;
	private String username;
	private String password;
	private long contact; 
	private String email;
	
	private List<Role> roles;
	private List<Address> address;
	private List<Books> book;
	private List<Orders> order;
	private List<Rent> rent;
	private List<RentedBooksDetails> details;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public List<Books> getBook() {
		return book;
	}
	public void setBook(List<Books> book) {
		this.book = book;
	}
	public List<Orders> getOrder() {
		return order;
	}
	public void setOrder(List<Orders> order) {
		this.order = order;
	}
	public List<Rent> getRent() {
		return rent;
	}
	public void setRent(List<Rent> rent) {
		this.rent = rent;
	}
	public List<RentedBooksDetails> getDetails() {
		return details;
	}
	public void setDetails(List<RentedBooksDetails> details) {
		this.details = details;
	}
	
	
}
