package com.cauc.devManage.userInfoManage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cauc.devManage.userInfoManage.dao.UserInfoManageMapper;
import com.cauc.devManage.userInfoManage.entity.UserInfo;

@Service
public class UserInfoManageServiceImpl implements UserInfoManageService{

	@Autowired
	private UserInfoManageMapper dao; 	

	@Override
	public List<UserInfo> getUserInfoList(UserInfo uInfo) {
		// TODO Auto-generated method stub
		return dao.getUserInfoList(uInfo);
	}

	@Override
	public void getUserInfo(UserInfo uInfo) {
		// TODO Auto-generated method stub
		dao.getUserInfo(uInfo);
	}

	@Override
	public void updateUserInfo(UserInfo uInfo) {
		// TODO Auto-generated method stub
		dao.updateUserInfo(uInfo);
	}

	@Override
	public void deleteUserInfo(UserInfo uInfo) {
		// TODO Auto-generated method stub
		dao.deleteUserInfo(uInfo);
	}

	@Override
	public void insertUserInfo(UserInfo uInfo) {
		// TODO Auto-generated method stub
		dao.insertUserInfo(uInfo);
	}



}
