package com.scsa.model.vo;

public class Hospital {
	private String hosCode;
	private String hosPassword;
	private String hosName;
	private double hosLongitude;
	private double hosLatitude;
	private String hosAddress;
	private String hosType;
	private String hosTel;
	private String hosInfo;
	private String hosImage;

	public Hospital() {
		super();
	}

	public Hospital(String hosCode, String hosPassword) {
		super();
		this.hosCode = hosCode;
		this.hosPassword = hosPassword;
	}

	public Hospital(String hosCode, String hosPassword, String hosName, double hosLongitude, double hosLatitude,
			String hosAddress, String hosType, String hosTel, String hosInfo, String hosImage) {
		super();
		this.hosCode = hosCode;
		this.hosPassword = hosPassword;
		this.hosName = hosName;
		this.hosLongitude = hosLongitude;
		this.hosLatitude = hosLatitude;
		this.hosAddress = hosAddress;
		this.hosType = hosType;
		this.hosTel = hosTel;
		this.hosInfo = hosInfo;
		this.hosImage = hosImage;
	}

	public String getHosCode() {
		return hosCode;
	}

	public void setHosCode(String hosCode) {
		this.hosCode = hosCode;
	}

	public String getHosPassword() {
		return hosPassword;
	}

	public void setHosPassword(String hosPassword) {
		this.hosPassword = hosPassword;
	}

	public String getHosName() {
		return hosName;
	}

	public void setHosName(String hosName) {
		this.hosName = hosName;
	}

	public double getHosLongitude() {
		return hosLongitude;
	}

	public void setHosLongitude(double hosLongitude) {
		this.hosLongitude = hosLongitude;
	}

	public double getHosLatitude() {
		return hosLatitude;
	}

	public void setHosLatitude(double hosLatitude) {
		this.hosLatitude = hosLatitude;
	}

	public String getHosAddress() {
		return hosAddress;
	}

	public void setHosAddress(String hosAddress) {
		this.hosAddress = hosAddress;
	}

	public String getHosType() {
		return hosType;
	}

	public void setHosType(String hosType) {
		this.hosType = hosType;
	}

	public String getHosTel() {
		return hosTel;
	}

	public void setHosTel(String hosTel) {
		this.hosTel = hosTel;
	}

	public String getHosInfo() {
		return hosInfo;
	}

	public void setHosInfo(String hosInfo) {
		this.hosInfo = hosInfo;
	}

	public String getHosImage() {
		return hosImage;
	}

	public void setHosImage(String hosImage) {
		this.hosImage = hosImage;
	}

	@Override
	public String toString() {
		return "Hospital [hosCode=" + hosCode + ", hosPassword=" + hosPassword + ", hosName=" + hosName
				+ ", hosLongitude=" + hosLongitude + ", hosLatitude=" + hosLatitude + ", hosAddress=" + hosAddress
				+ ", hosType=" + hosType + ", hosTel=" + hosTel + ", hosInfo=" + hosInfo + ", hosImage=" + hosImage
				+ "]";
	}

}
