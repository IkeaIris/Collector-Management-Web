package com.cauc.devManage.clctDataSolver.service;

import com.cauc.devManage.clctDataSolver.entity.CollectorSimple;

public interface ClctDataSolverService {
	public void createDataTableByClctId(CollectorSimple cs);
	public void dropDataTableByClctNo(CollectorSimple cs);
}
