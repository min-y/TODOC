package com.scsa.model.vo;

public class DoctorTimeTable {
	private String docCode;
	private int docDay;
	private String hosCode;
	private String hosOpen;
	private String hosclose;

	public DoctorTimeTable() {
		super();
	}

	public DoctorTimeTable(String docCode, int docDay, String hosCode, String hosOpen, String hosclose) {
		super();
		this.docCode = docCode;
		this.docDay = docDay;
		this.hosCode = hosCode;
		this.hosOpen = hosOpen;
		this.hosclose = hosclose;
	}

	public String getDocCode() {
		return docCode;
	}

	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}

	public int getDocDay() {
		return docDay;
	}

	public void setDocDay(int docDay) {
		this.docDay = docDay;
	}

	public String getHosCode() {
		return hosCode;
	}

	public void setHosCode(String hosCode) {
		this.hosCode = hosCode;
	}

	public String getHosOpen() {
		return hosOpen;
	}

	public void setHosOpen(String hosOpen) {
		this.hosOpen = hosOpen;
	}

	public String getHosclose() {
		return hosclose;
	}

	public void setHosclose(String hosclose) {
		this.hosclose = hosclose;
	}

	@Override
	public String toString() {
		return "DoctorTimeTable [docCode=" + docCode + ", docDay=" + docDay + ", hosCode=" + hosCode + ", hosOpen="
				+ hosOpen + ", hosclose=" + hosclose + "]";
	}

}
