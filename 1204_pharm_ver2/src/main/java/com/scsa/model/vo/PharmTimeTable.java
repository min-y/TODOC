package com.scsa.model.vo;

import java.io.Serializable;

public class PharmTimeTable implements Serializable{

	String pharmCode;
	int pharmDay;
	String pharmOpen;
	String pharmClose;
	
	public PharmTimeTable() {
		super();
	}

	public PharmTimeTable(String pharmCode, int pharmDay, String pharmOpen, String pharmClose) {
		super();
		this.pharmCode = pharmCode;
		this.pharmDay = pharmDay;
		this.pharmOpen = pharmOpen;
		this.pharmClose = pharmClose;
	}

	public String getPharmCode() {
		return pharmCode;
	}

	public void setPharmCode(String pharmCode) {
		this.pharmCode = pharmCode;
	}

	public int getPharmDay() {
		return pharmDay;
	}

	public void setPharmDay(int pharmDay) {
		this.pharmDay = pharmDay;
	}

	public String getPharmOpen() {
		return pharmOpen;
	}

	public void setPharmOpen(String pharmOpen) {
		this.pharmOpen = pharmOpen;
	}

	public String getPharmClose() {
		return pharmClose;
	}

	public void setPharmClose(String pharmClose) {
		this.pharmClose = pharmClose;
	}

	@Override
	public String toString() {
		return "PharmTimeTable [pharmCode=" + pharmCode + ", pharmDay=" + pharmDay + ", pharmOpen=" + pharmOpen
				+ ", pharmClose=" + pharmClose + "]";
	}
	
}
