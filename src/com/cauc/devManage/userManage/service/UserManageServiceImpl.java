package com.cauc.devManage.userManage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cauc.devManage.userManage.dao.UserManageMapper;
import com.cauc.devManage.userManage.entity.User;

@Service
public class UserManageServiceImpl implements UserManageService{

	@Autowired
	private UserManageMapper dao; 	
	
	@Override
	public List<User> getUserList(User user) {
		return dao.getUserList(user);
	}

	@Override
	public void getUser(User user) {
		dao.getUser(user);
	}

	@Override
	public void insertUser(User user) {
		dao.insertUser(user);
	}

	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		dao.deleteUser(user);
	}



}
