package com.cauc.devManage.userOperationLog.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cauc.devManage.userOperationLog.entity.UserLogInformation;

@Repository
public interface UserLogService {
	
	public List<UserLogInformation> getUserLogList(UserLogInformation ULI);

	public void insertUserLog(UserLogInformation ULI);
	
	public int getUserLogListTotal(UserLogInformation ULI);
	
}