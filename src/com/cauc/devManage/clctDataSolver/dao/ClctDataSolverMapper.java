package com.cauc.devManage.clctDataSolver.dao;

import org.springframework.stereotype.Repository;

import com.cauc.devManage.clctDataSolver.entity.CollectorSimple;

@Repository
public interface ClctDataSolverMapper {
	public void createDataTableByClctId(CollectorSimple cs);
	public void dropDataTableByClctNo(CollectorSimple cs);
}
