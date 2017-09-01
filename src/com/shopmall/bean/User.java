package com.shopmall.bean;
public class User {

	private int userId;
	private String username;
	private String password;
	private String name;
	private String gender;
	private String IDCard;
	private String birthday;
	private String addressId;
	private String cellphone;
	private String Email;
	private int menbership_point;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public int getMenbership_point() {
		return menbership_point;
	}
	public void setMenbership_point(int menbership_point) {
		this.menbership_point = menbership_point;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public User(int userId,String username, String password, String name, String gender, String iDCard, String birthday,
			String addressId, String cellphone, String email,int menbership_point) {
		super();
		this.userId=userId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.IDCard = iDCard;
		this.birthday = birthday;
		this.addressId = addressId;
		this.cellphone = cellphone;
		this.Email = email;
		this.menbership_point = menbership_point;
	}
	
	public User(String account, String password){
		this.username=account;
		this.password=password;
	}
	public User() {
		super();
	}
	
}
