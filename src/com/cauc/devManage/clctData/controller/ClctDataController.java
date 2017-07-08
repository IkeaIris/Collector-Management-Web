package com.cauc.devManage.clctData.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cauc.devManage.clctData.entity.ClctData;
import com.cauc.devManage.clctData.entity.ClctDataTable;
import com.cauc.devManage.clctData.service.ClctDataServiceImpl;
import com.cauc.devManage.util.StatusConst;

@Controller
@RequestMapping("/clctData")
public class ClctDataController {
	@Autowired
	private ClctDataServiceImpl service;
	
	@ResponseBody
	@RequestMapping(value = "/getClctDataList")
	public Object getCollectorList(ClctDataTable clctData,HttpServletResponse response) throws UnsupportedEncodingException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data=new HashMap<String, Object>();
		try {
			List<ClctData> clctDataList=service.getClctDataList(clctData);
			data.put("number", clctDataList.size());
			data.put("clctDataList",clctDataList);
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
