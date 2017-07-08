package com.cauc.devManage.userOperationLog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cauc.devManage.userOperationLog.entity.UserLogInformation;



@Repository
public interface UserLogMapper {
	
	public List<UserLogInformation> getUserLogList(UserLogInformation ULI);

	public void insertUserLog(UserLogInformation ULI);
	
	public int getUserLogListTotal(UserLogInformation ULI);
	
}
