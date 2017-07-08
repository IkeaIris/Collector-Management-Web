package com.cauc.devManage.clctManage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cauc.devManage.clctManage.dao.ClctManageMapper;
import com.cauc.devManage.clctManage.entity.Collector;

@Service
public class ClctManageServiceImpl implements ClctManageService {
	
	@Autowired
	private ClctManageMapper dao;
	
	@Override
	public List<Collector> getCollectorList(Collector p) {
		return dao.getCollectorList(p);
	}
	@Override
	public List<Collector> searchCollectorList(Collector p) {
		return dao.searchCollectorList(p);
	}
	@Override
	public void insertCollector(Collector p) {
		dao.insertCollector(p);
	}
	@Override
	public void updateCollector(Collector p) {
		dao.updateCollector(p);
	}
	@Override
	public void deleteCollector(Collector p) {
		dao.deleteCollector(p);
	}
	@Override
	public void deleteCollectorUndone(Collector p) {
		dao.deleteCollectorUndone(p);
	}
	public void reuseCollector(Collector p) {
		dao.reuseCollector(p);
	}
	@Override
	public List<Collector> getCollectorTrashList(Collector p) {
		return dao.getCollectorTrashList(p);
	}
}
