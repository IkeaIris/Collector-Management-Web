package com.cauc.devManage.userInfoManage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cauc.devManage.userInfoManage.entity.UserInfo;
import com.cauc.devManage.userInfoManage.service.UserInfoManageServiceImpl;
import com.cauc.devManage.util.StatusConst;

@Controller
@RequestMapping("/userInfoManage")
public class UserInfoManageController {

	@Autowired
	private UserInfoManageServiceImpl service;
	
	@ResponseBody
	@RequestMapping(value = "/getUserInfoList")
	public Object getUserInfoList(UserInfo uInfo, HttpServletResponse response) throws Exception{
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data = new HashMap<>();
		try {
			List<UserInfo> userInfoList = service.getUserInfoList(uInfo);
			data.put("number", userInfoList.size());
			data.put("userInfoList", userInfoList);
			data.put("status", StatusConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("data", null);
			data.put("status", StatusConst.ERROR);
		}
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertUserInfo")
	public Object insertUserInfo(UserInfo uInfo, HttpServletResponse response) throws Exception{
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data = new HashMap<>();
		try {
			service.insertUserInfo(uInfo);
			System.out.println(uInfo.getUser_Dept());
			data.put("status", StatusConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("status", StatusConst.ERROR);
		}
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateUserInfo")
	public Object updateUserInfo(UserInfo uInfo, HttpServletResponse response) throws Exception{
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data = new HashMap<>();
		try {
			service.updateUserInfo(uInfo);
			data.put("status", StatusConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("status", StatusConst.ERROR);
		}
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteUserInfo")
	public Object deleteUserInfo(UserInfo uInfo, HttpServletResponse response) throws Exception{
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data = new HashMap<>();
		try {
			service.deleteUserInfo(uInfo);
			data.put("status", StatusConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("status", StatusConst.ERROR);
		}
		return data;
	}
}
