package com.cauc.devManage.userManage.service;

import java.util.List;

import com.cauc.devManage.userManage.entity.User;

public interface UserManageService {
	
	public List<User> getUserList(User user);
	
	public void getUser(User user);
	
	public void insertUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
}
