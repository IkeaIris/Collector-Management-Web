package com.cauc.devManage.clctData.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cauc.devManage.clctData.entity.ClctData;
import com.cauc.devManage.clctData.entity.ClctDataTable;

@Repository
public interface ClctDataMapper {
	public List<ClctData> getClctDataList(ClctDataTable p);
}
