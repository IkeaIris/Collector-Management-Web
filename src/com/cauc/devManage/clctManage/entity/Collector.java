package com.cauc.devManage.clctManage.entity;

public class Collector {

	private int Clct_NO;
	private String Clct_ID;
	private String State_Detail;
	private String Dept_Name;
	private String Clct_Mark;
	private boolean Is_Del;
	
	public int getClct_NO() {
		return Clct_NO;
	}
	public void setClct_NO(int clct_NO) {
		Clct_NO = clct_NO;
	}
	public String getClct_ID() {
		return Clct_ID;
	}
	public void setClct_ID(String clct_ID) {
		Clct_ID = clct_ID;
	}
	public String getState_Detail() {
		return State_Detail;
	}
	public void setState_Detail(String state_Detail) {
		State_Detail = state_Detail;
	}
	public String getDept_Name() {
		return Dept_Name;
	}
	public void setDept_Name(String dept_Name) {
		Dept_Name = dept_Name;
	}
	public String getClct_Mark() {
		return Clct_Mark;
	}
	public void setClct_Mark(String clct_Mark) {
		Clct_Mark = clct_Mark;
	}
	public boolean isIs_Del() {
		return Is_Del;
	}
	public void setIs_Del(boolean is_Del) {
		Is_Del = is_Del;
	}
}
