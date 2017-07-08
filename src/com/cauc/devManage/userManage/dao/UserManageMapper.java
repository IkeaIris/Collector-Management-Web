package com.cauc.devManage.userManage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cauc.devManage.userManage.entity.User;

@Repository
public interface UserManageMapper {
	
	public List<User> getUserList(User user);
	
	public void getUser(User user);
	
	public void insertUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
}
