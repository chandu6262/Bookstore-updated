package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




@Entity
@Table(name = "user",uniqueConstraints = @UniqueConstraint(columnNames = {"user_id","contact","email"} ))
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	@NotNull(message = "user id is required")
	private int user_id;

	@Column(name = "password")
	@NotNull(message = "password is mandatory")
	@NotEmpty(message = "password should not be empty")
	@Size(min = 8,message = "password must be atleast 8 characters")
	private String password;

	@Column(name = "user_type")
	private String user_type;

	@Column(name = "username")
	@NotNull(message = "user name is a required field")
	@NotEmpty(message = "user name should not be empty")
	private String username;

	@Column(name = "contact")
	@NotNull(message = "contact number is required field")
	private long contact;

	@Column(name = "email")
	@NotNull(message = "email is required field")
	@NotEmpty(message = "email should not be empty")
	private String email;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "users_books",joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "book_id")})
	private List<Books> book = new ArrayList<>();

	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private List<Address> address;

	@OneToMany(targetEntity = Orders.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private List<Orders> order;

	@OneToMany(targetEntity = Rent.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private List<Rent> rent;

	@OneToMany(targetEntity = RentedBooksDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private List<RentedBooksDetails> details;


	public User() {
		super();
	}

	public User(User user) {

		this.user_id = user.user_id;
		this.password = user.password;
		this.user_type = user.user_type;
		this.username = user.username;
		this.contact = user.contact;
		this.email = user.email;
		this.roles = user.roles;
		this.book = user.book;
		this.address = user.address;
		this.order = user.order;
		this.rent = user.rent;
		this.details = user.details;
	}

	

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<Books> getBook() {
		return book;
	}

	public void setBook(List<Books> book) {
		this.book = book;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
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

