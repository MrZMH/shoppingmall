package com.shopmall.bean;

public class Admin {
	
	private int userId;
	private String userName;
	private String password;
	private String cellphone;
	private String name;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Admin(String userName, String password, String cellphone, String name) {
		super();
		this.userName = userName;
		this.password = password;
		this.cellphone = cellphone;
		this.name = name;
	}
	public Admin() {
		super();
	}

}
