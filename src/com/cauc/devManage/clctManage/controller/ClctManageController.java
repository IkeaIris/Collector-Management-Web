package com.cauc.devManage.clctManage.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cauc.devManage.clctManage.entity.Collector;
import com.cauc.devManage.clctManage.service.ClctManageServiceImpl;
import com.cauc.devManage.util.StatusConst;

@Controller
@RequestMapping("/clctManage")
public class ClctManageController {
	
	@Autowired
	private ClctManageServiceImpl service;
	
	@ResponseBody
	@RequestMapping(value = "/getCollectorList")
	public Object getCollectorList(Collector collector,HttpServletRequest request,HttpServletResponse response) 
			throws UnsupportedEncodingException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data=new HashMap<String, Object>();
		try {
			List<Collector> collectorList=service.getCollectorList(collector);
			data.put("number", collectorList.size());
			data.put("collectorList", collectorList);
			data.put("status",StatusConst.SUCCESS);
		}
		catch(Exception e) {
			e.printStackTrace();
			data.put("data", null);
			data.put("status",StatusConst.ERROR);
		}
		return data;
	}
	@ResponseBody
	@RequestMapping(value = "/searchCollectorList")
	public Object searchCollectorList(Collector collector,HttpServletResponse response) 
			throws UnsupportedEncodingException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data=new HashMap<String, Object>();
		try {
			List<Collector> collectorList=service.getCollectorList(collector);
			data.put("number", collectorList.size());
			data.put("collectorList", collectorList);
			data.put("status",StatusConst.SUCCESS);
		}
		catch(Exception e) {
			e.printStackTrace();
			data.put("data", null);
			data.put("status",StatusConst.ERROR);
		}
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertCollector")
	public Object insertCollector(Collector collector,HttpServletResponse response) 
			throws UnsupportedEncodingException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data=new HashMap<String, Object>();
		try {
			service.insertCollector(collector);
			
			data.put("status",StatusConst.SUCCESS);
		}
		catch(Exception e) {
			e.printStackTrace();
			data.put("status",StatusConst.ERROR);
		}
		return data;
	}
	@ResponseBody
	@RequestMapping(value = "/updateCollector")
	public Object updateCollector(Collector collector,HttpServletResponse response) throws UnsupportedEncodingException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data=new HashMap<String, Object>();
		try {
			service.updateCollector(collector);
			data.put("status",StatusConst.SUCCESS);
		}
		catch(Exception e) {
			e.printStackTrace();
			data.put("status",StatusConst.ERROR);
		}
		return data;
	}
	@ResponseBody
	@RequestMapping(value = "/deleteCollector")
	public Object deleteCollector(Collector collector,HttpServletResponse response) throws UnsupportedEncodingException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data=new HashMap<String, Object>();
		try {
			service.deleteCollector(collector);
			data.put("status",StatusConst.SUCCESS);
		}
		catch(Exception e) {
			e.printStackTrace();
			data.put("status",StatusConst.ERROR);
		}
		return data;
	}
	@ResponseBody
	@RequestMapping(value = "/deleteCollectorUndone")
	public Object deleteCollectorUndone(Collector collector,HttpServletResponse response) throws UnsupportedEncodingException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data=new HashMap<String, Object>();
		try {
			service.deleteCollectorUndone(collector);
			data.put("status",StatusConst.SUCCESS);
		}
		catch(Exception e) {
			e.printStackTrace();
			data.put("status",StatusConst.ERROR);
		}
		return data;
	}
	@ResponseBody
	@RequestMapping(value = "/reuseCollector")
	public Object reuseCollector(Collector collector,HttpServletResponse response) throws UnsupportedEncodingException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data=new HashMap<String, Object>();
		try {
			service.reuseCollector(collector);
			data.put("status",StatusConst.SUCCESS);
		}
		catch(Exception e) {
			e.printStackTrace();
			data.put("status",StatusConst.ERROR);
		}
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getCollectorTrashList")
	public Object getCollectorTrashList(Collector collector,HttpServletResponse response) 
			throws UnsupportedEncodingException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data=new HashMap<String, Object>();
		try {
			List<Collector> collectorTrashList=service.getCollectorTrashList(collector);
			data.put("number", collectorTrashList.size());
			data.put("collectorTrashList", collectorTrashList);
			data.put("status",StatusConst.SUCCESS);
		}
		catch(Exception e) {
			e.printStackTrace();
			data.put("data", null);
			data.put("status",StatusConst.ERROR);
		}
		return data;
	}
}
