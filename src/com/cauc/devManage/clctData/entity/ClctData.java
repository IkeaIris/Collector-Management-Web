package com.cauc.devManage.clctData.entity;

import java.sql.Timestamp;

public class ClctData {
	private Timestamp GEN_TIMESTAMP;
	private float ENV_TEMP;
	private float ENV_HUMI;
	private float DEV_TEMP;
	private float VOLTAGE;
	private float CURRENT;
	private int STATE;
	public String getGEN_TIMESTAMP() {
		return GEN_TIMESTAMP.toString();
	}
	public void setGEN_TIMESTAMP(Timestamp gEN_TIMESTAMP) {
		GEN_TIMESTAMP = gEN_TIMESTAMP;
	}
	public float getENV_TEMP() {
		return ENV_TEMP;
	}
	public void setENV_TEMP(float eNV_TEMP) {
		ENV_TEMP = eNV_TEMP;
	}
	public float getENV_HUMI() {
		return ENV_HUMI;
	}
	public void setENV_HUMI(float eNV_HUMI) {
		ENV_HUMI = eNV_HUMI;
	}
	public float getDEV_TEMP() {
		return DEV_TEMP;
	}
	public void setDEV_TEMP(float dEV_TEMP) {
		DEV_TEMP = dEV_TEMP;
	}
	public float getVOLTAGE() {
		return VOLTAGE;
	}
	public void setVOLTAGE(float vOLTAGE) {
		VOLTAGE = vOLTAGE;
	}
	public float getCURRENT() {
		return CURRENT;
	}
	public void setCURRENT(float cURRENT) {
		CURRENT = cURRENT;
	}
	public String getSTATE() {
		switch(STATE) {
		case 1:
			return "正常";
		case 2:
			return "异常";
		default:
			return "";
		}
	}
	public void setSTATE(int sTATE) {
		STATE = sTATE;
	}
	
}
