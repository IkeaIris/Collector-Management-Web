package com.cauc.devManage.clctDataSolver.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cauc.devManage.clctDataSolver.entity.CollectorSimple;
import com.cauc.devManage.clctDataSolver.service.ClctDataSolverServiceImpl;
import com.cauc.devManage.util.StatusConst;

@Controller
@RequestMapping("/clctDataSolver")
public class ClctDataSolverController {
	
	@Autowired
	private ClctDataSolverServiceImpl service;
	
	@ResponseBody
	@RequestMapping(value = "createDataTableByClctId")
	public Object createDataTableByClctId(CollectorSimple cs,HttpServletRequest request,HttpServletResponse response) 
	throws UnsupportedEncodingException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data=new HashMap<String, Object>();
		try {
			service.createDataTableByClctId(cs);
			data.put("status",StatusConst.SUCCESS);
		}
		catch(Exception e) {
			e.printStackTrace();
			data.put("status",StatusConst.ERROR);
		}
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dropDataTableByClctNo")
	public Object dropDataTableByClctNo(CollectorSimple cs,HttpServletRequest request,HttpServletResponse response) 
			throws UnsupportedEncodingException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data=new HashMap<String, Object>();
		try {
			service.dropDataTableByClctNo(cs);
			data.put("status",StatusConst.SUCCESS);
		}
		catch(Exception e) {
			e.printStackTrace();
			data.put("status",StatusConst.ERROR);
		}
		return data;
	}
}
