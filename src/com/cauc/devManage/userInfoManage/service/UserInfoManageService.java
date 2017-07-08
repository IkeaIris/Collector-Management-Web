package com.cauc.devManage.userInfoManage.service;

import java.util.List;

import com.cauc.devManage.userInfoManage.entity.UserInfo;

public interface UserInfoManageService {
	
	public List<UserInfo> getUserInfoList(UserInfo uInfo);
	
	public void getUserInfo(UserInfo uInfo);
	
	public void insertUserInfo(UserInfo uInfo);
	
	public void updateUserInfo(UserInfo uInfo);
	
	public void deleteUserInfo(UserInfo uInfo);
}