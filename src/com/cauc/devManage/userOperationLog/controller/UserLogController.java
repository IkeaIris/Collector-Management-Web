package com.cauc.devManage.userOperationLog.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cauc.devManage.userOperationLog.entity.UserLogInformation;
import com.cauc.devManage.userOperationLog.service.UserLogServiceImpl;
import com.cauc.devManage.util.StatusConst;

@Controller
@RequestMapping("/userOperationLog")
public class UserLogController {
	
	@Autowired
	private UserLogServiceImpl service;
	@Autowired
	private HttpServletRequest request;
	
	@ResponseBody
	@RequestMapping(value = "/getUserLogList", method=RequestMethod.GET)
	public Object getUserLogList(UserLogInformation ULI, HttpServletResponse response) throws IOException{
		Map<String, Object>data = new HashMap<String, Object>();
		
		try{
			List<UserLogInformation>userLogList = service.getUserLogList(ULI);
			int userLogListSize = service.getUserLogListTotal(ULI);
			data.put("UserLogList", userLogList);
			data.put("UserLogListSize", userLogListSize);
			data.put("status", StatusConst.SUCCESS);
		}
		catch (Exception e) {
			e.printStackTrace();
			data.put("status", StatusConst.ERROR);
			data.put("data", null);
		}
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertUserLog", method=RequestMethod.GET)
	public Object insertUserLog(UserLogInformation ULI, HttpServletResponse response){
		Map<String, Object>data = new HashMap<String, Object>();
		ULI.setIP(getIpAddr());
		try{
			service.insertUserLog(ULI);
			data.put("status", StatusConst.SUCCESS);
		}
		catch (Exception e) {
			e.printStackTrace();
			data.put("status", StatusConst.ERROR);
		}
		return data;
	}
	
    public long getIpAddr(){  
        String ipAddress = request.getHeader("x-forwarded-for");  
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
                ipAddress = request.getHeader("Proxy-Client-IP");  
            }  
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
                ipAddress = request.getHeader("WL-Proxy-Client-IP");  
            }  
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
                ipAddress = request.getRemoteAddr();  
                if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){  
                    //根据网卡取本机配置的IP  
                    InetAddress inet=null;  
                    try {  
                        inet = InetAddress.getLocalHost();  
                    } catch (UnknownHostException e) {  
                        e.printStackTrace();  
                    }  
                    ipAddress= inet.getHostAddress();  
                }  
            }  
            //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
            if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15  
                if(ipAddress.indexOf(",")>0){  
                    ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));  
                }  
            }  
            
            String[] p4 = ipAddress.split("\\.");  
            long ipInt = 0;  
            long part = Long.valueOf(p4[0]);  
            ipInt = ipInt | (part << 24);  
            part = Long.valueOf(p4[1]);  
            ipInt = ipInt | (part << 16);  
            part = Long.valueOf(p4[2]);  
            ipInt = ipInt | (part << 8);  
            part = Long.valueOf(p4[3]);  
            ipInt = ipInt | (part);  
            return ipInt;  
    }  

}


