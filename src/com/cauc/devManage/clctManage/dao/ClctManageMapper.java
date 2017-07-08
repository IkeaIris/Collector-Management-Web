package com.cauc.devManage.clctManage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cauc.devManage.clctManage.entity.Collector;
@Repository
public interface ClctManageMapper {
	public List<Collector> getCollectorList(Collector p);
	public List<Collector> searchCollectorList(Collector p);
	public void insertCollector(Collector p);
	public void updateCollector(Collector p);
	public void deleteCollector(Collector p);
	public void deleteCollectorUndone(Collector p);
	public void reuseCollector(Collector p);
	public List<Collector> getCollectorTrashList(Collector p);
}