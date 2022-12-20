package com.Rest.Api.Post;
//POJO Templates for user
public class UserClass {
//Class Variables
private String name;
private String email;
private String gender;
private String status;


//constructor
public UserClass(String name, String email, String gender, String status) {
	
	this.name = name;
	this.email = email;
	this.gender = gender;
	this.status = status;
}

//getter and setter methods 
public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getGender() {
	return gender;
}


public void setGender(String gender) {
	this.gender = gender;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}	



















}
