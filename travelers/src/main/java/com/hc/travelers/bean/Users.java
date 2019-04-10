package com.hc.travelers.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class Users {
	private Integer userId;
	private String userUsername;
	private String userPassword;
	private String userTel;
	private String userEmail;
	private Date userBirthday;
	private Integer userSex;
	private String userImgpath;
	private Integer userStatus;
	private Timestamp userCreatetime;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserUsername() {
		return userUsername;
	}
	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Date getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public Integer getUserSex() {
		return userSex;
	}
	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}
	public String getUserImgpath() {
		return userImgpath;
	}
	public void setUserImgpath(String userImgpath) {
		this.userImgpath = userImgpath;
	}
	public Integer getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	public Timestamp getUserCreatetime() {
		return userCreatetime;
	}
	public void setUserCreatetime(Timestamp userCreatetime) {
		this.userCreatetime = userCreatetime;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userUsername=" + userUsername + ", userPassword=" + userPassword
				+ ", userTel=" + userTel + ", userEmail=" + userEmail + ", userBirthday=" + userBirthday + ", userSex="
				+ userSex + ", userImgpath=" + userImgpath + ", userStatus=" + userStatus + ", userCreatetime="
				+ userCreatetime + "]";
	}
	
}
