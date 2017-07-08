package com.cauc.devManage.clctData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cauc.devManage.clctData.dao.ClctDataMapper;
import com.cauc.devManage.clctData.entity.ClctData;
import com.cauc.devManage.clctData.entity.ClctDataTable;

@Service
public class ClctDataServiceImpl implements ClctDataService {
	@Autowired
	private ClctDataMapper dao;
	
	@Override
	public List<ClctData> getClctDataList(ClctDataTable p) {
		return dao.getClctDataList(p);
	}
}
