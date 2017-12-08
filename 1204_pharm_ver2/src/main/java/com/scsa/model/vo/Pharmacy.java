package com.scsa.model.vo;

import java.io.Serializable;

public class Pharmacy implements Serializable{
	String pharmCode;
	String pharmPassword;
	String pharmName;
	double pharmLongitude;
	double pharmLatitude;
	String pharmAddress;
	String pharmTel;
	
	public Pharmacy() {
		super();
	}

	public Pharmacy(String pharmCode, String pharmPassword) {
		super();
		this.pharmCode = pharmCode;
		this.pharmPassword = pharmPassword;
	}

	public Pharmacy(String pharmCode, String pharmPassword, String pharmName, double pharmLongitude, double pharmLatitude,
			String pharmAddress, String pharmTel) {
		super();
		this.pharmCode = pharmCode;
		this.pharmPassword = pharmPassword;
		this.pharmName = pharmName;
		this.pharmLongitude = pharmLongitude;
		this.pharmLatitude = pharmLatitude;
		this.pharmAddress = pharmAddress;
		this.pharmTel = pharmTel;
	}


	public String getPharmCode() {
		return pharmCode;
	}

	public void setPharmCode(String pharmCode) {
		this.pharmCode = pharmCode;
	}


	public String getPharmPassword() {
		return pharmPassword;
	}

	public void setPharmPassword(String pharmPassword) {
		this.pharmPassword = pharmPassword;
	}
	
	public String getPharmName() {
		return pharmName;
	}

	public void setPharmName(String pharmName) {
		this.pharmName = pharmName;
	}

	public double getPharmLongitude() {
		return pharmLongitude;
	}

	public void setPharmLongitude(double pharmLongitude) {
		this.pharmLongitude = pharmLongitude;
	}

	public double getPharmLatitude() {
		return pharmLatitude;
	}

	public void setPharmLatitude(double pharmLatitude) {
		this.pharmLatitude = pharmLatitude;
	}

	public String getPharmAddress() {
		return pharmAddress;
	}

	public void setPharmAddress(String pharmAddress) {
		this.pharmAddress = pharmAddress;
	}

	public String getPharmTel() {
		return pharmTel;
	}

	public void setPharmTel(String pharmTel) {
		this.pharmTel = pharmTel;
	}

	@Override
	public String toString() {
		return "Pharmacy [pharmCode=" + pharmCode + ", pharmPassword=" + pharmPassword + ", pharmName=" + pharmName
				+ ", pharmLongitude=" + pharmLongitude + ", pharmLatitude=" + pharmLatitude + ", pharmAddress="
				+ pharmAddress + ", PharmTel=" + pharmTel + "]";
	}

}
