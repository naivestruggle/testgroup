package com.hc.travelers.custombean;

import java.io.Serializable;

import com.hc.travelers.bean.Users;

final public class CustomUsers extends Users implements Serializable{
	private String userPassword2;

	public String getUserPassword2() {
		return userPassword2;
	}

	public void setUserPassword2(String userPassword2) {
		this.userPassword2 = userPassword2;
	}

	@Override
	public String toString() {
		return "CustomUsers [userPassword2=" + userPassword2 + ", getUserPassword2()=" + getUserPassword2() + "]";
	}
	
}
