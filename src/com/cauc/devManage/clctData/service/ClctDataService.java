package com.cauc.devManage.clctData.service;

import java.util.List;

import com.cauc.devManage.clctData.entity.ClctData;
import com.cauc.devManage.clctData.entity.ClctDataTable;

public interface ClctDataService {
	public List<ClctData> getClctDataList(ClctDataTable p);
}
