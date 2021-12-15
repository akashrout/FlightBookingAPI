package com.example.demo.entity;

public class Passenger {
	private String id;
	private String fastName;
	private String lastName;
	private String email;
	private String mobile;
	private String gender;

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(String id, String fastName, String lastName, String email, String mobile, String gender) {
		super();
		this.id = id;
		this.fastName = fastName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFastName() {
		return fastName;
	}

	public void setFastName(String fastName) {
		this.fastName = fastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", fastName=" + fastName + ", lastName=" + lastName + ", email=" + email
				+ ", mobile=" + mobile + ", gender=" + gender + "]";
	}

}
