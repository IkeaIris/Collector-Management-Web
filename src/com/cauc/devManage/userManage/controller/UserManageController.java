package com.cauc.devManage.userManage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cauc.devManage.userManage.entity.User;
import com.cauc.devManage.userManage.service.UserManageServiceImpl;
import com.cauc.devManage.util.StatusConst;

@Controller
@RequestMapping("/userManage")
public class UserManageController {

	@Autowired
	private UserManageServiceImpl service;
	
	@ResponseBody
	@RequestMapping(value = "/getUserList")
	public Object getUserList(User user, HttpServletResponse response) throws Exception{
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data = new HashMap<>();
		try {
			List<User> userList = service.getUserList(user);
			data.put("number", userList.size());
			data.put("userList", userList);
			data.put("status", StatusConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("data", null);
			data.put("status", StatusConst.ERROR);
		}
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertUser")
	public Object insertUser(User user, HttpServletResponse response) throws Exception{
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data = new HashMap<>();
		try {
			service.insertUser(user);
			data.put("status", StatusConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("status", StatusConst.ERROR);
		}
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateUser")
	public Object updateUser(User user, HttpServletResponse response) throws Exception{
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data = new HashMap<>();
		try {
			service.updateUser(user);
			data.put("status", StatusConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("status", StatusConst.ERROR);
		}
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteUser")
	public Object deleteUser(User user, HttpServletResponse response) throws Exception{
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> data = new HashMap<>();
		try {
			service.deleteUser(user);
			data.put("status", StatusConst.SUCCESS); 
		} catch (Exception e) {
			e.printStackTrace();
			data.put("status", StatusConst.ERROR);
		}
		return data;
	}
}
