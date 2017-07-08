package com.cauc.devManage.clctDataSolver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cauc.devManage.clctDataSolver.dao.ClctDataSolverMapper;
import com.cauc.devManage.clctDataSolver.entity.CollectorSimple;

@Service
public class ClctDataSolverServiceImpl implements ClctDataSolverService{
	
	@Autowired
	private ClctDataSolverMapper dao;

	@Override
	public void createDataTableByClctId(CollectorSimple cs) {
		dao.createDataTableByClctId(cs);
	}

	@Override
	public void dropDataTableByClctNo(CollectorSimple cs) {
		dao.dropDataTableByClctNo(cs);
	}

}
