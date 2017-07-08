package com.cauc.devManage.functions;

import javax.servlet.http.HttpServletRequest;

import com.cauc.devManage.userOperationLog.entity.UserLogInformation;

public class CreateNewLog {

	public UserLogInformation newLogObject(String[] string){
		UserLogInformation userLogInformation = new UserLogInformation(); 
		String tableString = string[string.length - 2];
		if(tableString.equals("clctManage"))userLogInformation.setTable_Name("CollectorInfo");
		//多种情况
		
		if(string[0].contains("insert")){
			userLogInformation.setOperation_Type(1);
			userLogInformation.setColumn_Name("NO");
			userLogInformation.setNew_Value("");
			//从表中查询列数
		}
		if(string[0].contains("login"))userLogInformation.setOperation_Type(4);
		if(string[0].contains("logout"))userLogInformation.setOperation_Type(5);
		if(string[0].contains("update"))
			if(string[0].contains("is_Del")){
				userLogInformation.setOperation_Type(2);
				userLogInformation.setColumn_Name("is_Del");
				userLogInformation.setOld_Value("0");
				userLogInformation.setNew_Value("1");
			}
			else {
				userLogInformation.setOperation_Type(3);
				//其余还没想好
			}
		return null;
	}
	
	public UserLogInformation Analyseurl(HttpServletRequest request) {
		String url = "";
		url = request.getScheme() +"://" + request.getServerName()  
                        + ":" +request.getServerPort() 
                        + request.getServletPath();
		if (request.getQueryString() != null){
			url += "?" + request.getQueryString();
		}
		String s[] = url.split("/");		
		int len = s.length;
		String mV[] = s[len - 1].split("&");
		return newLogObject(mV);
	}
	
}
