package com.cauc.devManage.userManage.entity;

import java.security.MessageDigest;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class User {
	private int User_No;
	private int User_ID;
	private int User_Role;
	private String HashedPwd;
	public int getUser_No() {
		return User_No;
	}
	public void setUser_No(int user_No) {
		User_No = user_No;
	}
	public int getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}
	public int getUser_Role() {
		return User_Role;
	}
	public void setUser_Role(int user_Role) {
		User_Role = user_Role;
	}
	public String getHashedPwd() {
		return HashedPwd;
	}
	public void setHashedPwd(String hashedPwd) throws Exception{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		HashedPwd = new HexBinaryAdapter().marshal(md.digest(hashedPwd.getBytes()));
	}
	
}
