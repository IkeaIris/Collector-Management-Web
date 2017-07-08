package com.cauc.devManage.userInfoManage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cauc.devManage.userInfoManage.entity.UserInfo;

@Repository
public interface UserInfoManageMapper {
	
	public List<UserInfo> getUserInfoList(UserInfo uInfo);
	
	public Object getUserInfo(UserInfo uInfo);
	
	public Object insertUserInfo(UserInfo uInfo);
	
	public Object updateUserInfo(UserInfo uInfo);
	
	public Object deleteUserInfo(UserInfo uInfo);
}
