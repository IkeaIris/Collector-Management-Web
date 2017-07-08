package com.cauc.devManage.userInfoManage.entity;

public class UserInfo {
	private int No;
	private int User_ID;
	private String User_Name;
	private String User_Dept;
	private int User_Role;
	private String Role_Name;
	private char IS_DEL;
	
	public int getNo() {
		return No;
	}
	public void setNo(int no) {
		No = no;
	}
	public int getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(int user_ID) {
		System.out.println(user_ID);
		User_ID = user_ID;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	public String getUser_Dept() {
		return User_Dept;
	}
	public void setUser_Dept(String user_Dept) {
		User_Dept = user_Dept;
	}
	public String getRole_Name() {
		return Role_Name;
	}
	public void setRole_Name(String role_Name) {
		Role_Name = role_Name;
	}
	public char getIS_DEL() {
		System.out.println(IS_DEL);
		return IS_DEL;
	}
	public void setIS_DEL(char iS_DEL) {
		IS_DEL = iS_DEL;
	}
	public int getUser_Role() {
		return User_Role;
	}
	public void setUser_Role(int user_Role) {
		User_Role = user_Role;
	}
}
