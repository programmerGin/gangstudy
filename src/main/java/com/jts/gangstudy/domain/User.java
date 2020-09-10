package com.jts.gangstudy.domain;



public class User {
	private Integer user_no;
	private String name;
	private String phone;
	private String id;
	private String pw;
	private String email;
	private String bod;
	private char gender;
	private Integer rate;
	private double points;
	private String note;
	
	
	public boolean isMatchPassword(String pw){
		boolean isMatch=false;
		if(this.pw.equals(pw)) {
			isMatch=true;
		}
		return isMatch;
	}
	
	
	
	@Override
	public String toString() {
		return "User [user_no=" + user_no + ", name=" + name + ", phone=" + phone + ", id=" + id + ", pw=" + pw
				+ ", email=" + email + ", bod=" + bod + ", gender=" + gender + ", rate=" + rate + ", points=" + points
				+ ", note=" + note + "]";
	}


	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(Integer user_no, String name, String phone, String id, String pw, String email, String bod, char gender,
			Integer rate, double points, String note) {
		super();
		this.user_no = user_no;
		this.name = name;
		this.phone = phone;
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.bod = bod;
		this.gender = gender;
		this.rate = rate;
		this.points = points;
		this.note = note;
	}


	public Integer getUser_no() {
		return user_no;
	}


	public void setUser_no(Integer user_no) {
		this.user_no = user_no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getBod() {
		return bod;
	}


	public void setBod(String bod) {
		this.bod = bod;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public Integer getRate() {
		return rate;
	}


	public void setRate(Integer rate) {
		this.rate = rate;
	}


	public double getPoints() {
		return points;
	}


	public void setPoints(double points) {
		this.points = points;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}
	

	
	
	
	
	
	
	
	
	
}