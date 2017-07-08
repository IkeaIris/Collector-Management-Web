package com.cauc.devManage.userOperationLog.entity;

import java.sql.Timestamp;

public class UserLogInformation {
	
	private int Log_No;
	private Timestamp Operation_Timestamp;
	private String Table_Name;
	private String User_ID;
	private long IP;
	private int Operation_Type;
	private String Column_Name;
	private String Old_Value;
	private String New_Value;
	private Timestamp Time_Start;
	private Timestamp Time_End;
	
	public Timestamp getTime_Start() {
		return Time_Start;
	}
	public void setTime_Start(Timestamp time_Start) {
		Time_Start = time_Start;
	}
	public Timestamp getTime_End() {
		return Time_End;
	}
	public void setTime_End(Timestamp time_End) {
		Time_End = time_End;
	}
	public long getIP() {
		return IP;
	}
	public void setIP(long iP) {
		IP = iP;
	}
	public void setOperation_Timestamp(Timestamp operation_Timestamp) {
		Operation_Timestamp = operation_Timestamp;
	}
	public int getLog_No() {
		return Log_No;
	}
	public void setLog_No(int log_No) {
		Log_No = log_No;
	}

	public Timestamp getOperation_Timestamp() {
		return Operation_Timestamp;
	}
	public void setOperation_Timestamp(String operation_Timestamp) {
		Operation_Timestamp = Timestamp.valueOf(operation_Timestamp);
	}
	public String getTable_Name() {
		return Table_Name;
	}
	public void setTable_Name(String table_Name) {
		Table_Name = table_Name;
	}
	public String getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(String user_ID) {
		User_ID = user_ID;
	}
	
	public void setOperation_Type(int operation_Type) {
		Operation_Type = operation_Type;
	}
	public int getOperation_Type() {
		return Operation_Type;
	}
	public String getColumn_Name() {
		return Column_Name;
	}
	public void setColumn_Name(String column_Name) {
		Column_Name = column_Name;
	}
	public String getOld_Value() {
		return Old_Value;
	}
	public void setOld_Value(String old_Value) {
		Old_Value = old_Value;
	}
	public String getNew_Value() {
		return New_Value;
	}
	public void setNew_Value(String new_Value) {
		New_Value = new_Value;
	}
	
	
}
