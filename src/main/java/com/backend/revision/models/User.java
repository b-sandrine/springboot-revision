package com.backend.revision.models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="names")
	private String fullnames;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nationalId")
	private long NID;
	
	@Column(name ="phonenumber")
	private String phoneNumber;
	
	@Column(name="address")
	private String address;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String fullnames, String email, long nID, String phoneNumber, String address, String username,
			String password) {
		super();
		this.fullnames = fullnames;
		this.email = email;
		this.NID = nID;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.username = username;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullnames() {
		return fullnames;
	}

	public void setFullnames(String fullnames) {
		this.fullnames = fullnames;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getNID() {
		return NID;
	}

	public void setNID(long nID) {
		NID = nID;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	
}
