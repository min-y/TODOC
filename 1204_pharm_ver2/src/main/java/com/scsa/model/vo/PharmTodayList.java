package com.scsa.model.vo;

import java.io.Serializable;

public class PharmTodayList implements Serializable{
	
	String pharmCode;
	String preCode;
	String accDate;
	int amount;
	int preStatus;
	Prescription prescription;
	
	public PharmTodayList() {
		super();
	}

	public PharmTodayList(String pharmCode, String preCode, String accDate, int amount, int preStatus,
			Prescription prescription) {
		super();
		this.pharmCode = pharmCode;
		this.preCode = preCode;
		this.accDate = accDate;
		this.amount = amount;
		this.preStatus = preStatus;
		this.prescription = prescription;
	}

	public String getPharmCode() {
		return pharmCode;
	}

	public void setPharmCode(String pharmCode) {
		this.pharmCode = pharmCode;
	}

	public String getPreCode() {
		return preCode;
	}

	public void setPreCode(String preCode) {
		this.preCode = preCode;
	}

	public String getAccDate() {
		return accDate;
	}

	public void setAccDate(String accDate) {
		this.accDate = accDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPreStatus() {
		return preStatus;
	}

	public void setPreStatus(int preStatus) {
		this.preStatus = preStatus;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	@Override
	public String toString() {
		return "PharmTodayList [pharmCode=" + pharmCode + ", preCode=" + preCode + ", accDate=" + accDate + ", amount="
				+ amount + ", preStatus=" + preStatus + ", prescription=" + prescription + "]";
	}
	
	
}
