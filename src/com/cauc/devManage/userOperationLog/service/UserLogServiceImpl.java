package com.cauc.devManage.userOperationLog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cauc.devManage.userOperationLog.dao.UserLogMapper;
import com.cauc.devManage.userOperationLog.entity.UserLogInformation;

@Service
public class UserLogServiceImpl implements UserLogService{

	@Autowired
	private UserLogMapper dao;
	
	@Override
	public List<UserLogInformation> getUserLogList(UserLogInformation ULI) {
		// TODO Auto-generated method stub
		return dao.getUserLogList(ULI);
	}

	@Override
	public void insertUserLog(UserLogInformation ULI) {
		// TODO Auto-generated method stub
		dao.insertUserLog(ULI);
	}

	@Override
	public int getUserLogListTotal(UserLogInformation ULI) {
		// TODO Auto-generated method stub
		return dao.getUserLogListTotal(ULI);
	}

}
