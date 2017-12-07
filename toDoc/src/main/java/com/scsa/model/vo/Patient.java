package com.scsa.model.vo;

public class Patient {
	private String hosCode;
	private String patCode;
	private String patName;
	private String patSocialNo;
	private String patGender;
	private String patAddress;
	private String patTel;

	public Patient() {
		super();
	}
		
	public Patient(String patName) {
		super();
		this.patName = patName;
	}

	public Patient(String hosCode, String patCode, String patName, String patSocialNo, String patGender,
			String patAddress, String patTel) {
		super();
		this.hosCode = hosCode;
		this.patCode = patCode;
		this.patName = patName;
		this.patSocialNo = patSocialNo;
		this.patGender = patGender;
		this.patAddress = patAddress;
		this.patTel = patTel;
	}

	public String getHosCode() {
		return hosCode;
	}

	public void setHosCode(String hosCode) {
		this.hosCode = hosCode;
	}

	public String getPatCode() {
		return patCode;
	}

	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}

	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public String getPatSocialNo() {
		return patSocialNo;
	}

	public void setPatSocialNo(String patSocialNo) {
		this.patSocialNo = patSocialNo;
	}

	public String getPatGender() {
		return patGender;
	}

	public void setPatGender(String patGender) {
		this.patGender = patGender;
	}

	public String getPatAddress() {
		return patAddress;
	}

	public void setPatAddress(String patAddress) {
		this.patAddress = patAddress;
	}

	public String getPatTel() {
		return patTel;
	}

	public void setPatTel(String patTel) {
		this.patTel = patTel;
	}

	@Override
	public String toString() {
		return "Patient [hosCode=" + hosCode + ", patCode=" + patCode + ", patName=" + patName + ", patSocialNo="
				+ patSocialNo + ", patGender=" + patGender + ", patAddress=" + patAddress + ", patTel=" + patTel + "]";
	}

}
