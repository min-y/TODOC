package com.scsa.model.vo;

public class HospitalTimeTable extends Hospital {
	private String hosCode;
	private int hosDay;
	private String hosOpen;
	private String hosClose;
	private String hosLunchStart;
	private String hosLunchEnd;

	public HospitalTimeTable() {
		super();
	}

	public HospitalTimeTable(String hosCode, int hosDay, String hosOpen, String hosClose, String hosLunchStart,
			String hosLunchEnd) {
		super();
		this.hosCode = hosCode;
		this.hosDay = hosDay;
		this.hosOpen = hosOpen;
		this.hosClose = hosClose;
		this.hosLunchStart = hosLunchStart;
		this.hosLunchEnd = hosLunchEnd;
	}

	public HospitalTimeTable(String hosCode, int hosDay) {
		super();
		this.hosCode = hosCode;
		this.hosDay = hosDay;
	}

	public String getHosCode() {
		return hosCode;
	}

	public void setHosCode(String hosCode) {
		this.hosCode = hosCode;
	}

	public int getHosDay() {
		return hosDay;
	}

	public void setHosDay(int hosDay) {
		this.hosDay = hosDay;
	}

	public String getHosOpen() {
		return hosOpen;
	}

	public void setHosOpen(String hosOpen) {
		this.hosOpen = hosOpen;
	}

	public String getHosClose() {
		return hosClose;
	}

	public void setHosClose(String hosClose) {
		this.hosClose = hosClose;
	}

	public String getHosLunchStart() {
		return hosLunchStart;
	}

	public void setHosLunchStart(String hosLunchStart) {
		this.hosLunchStart = hosLunchStart;
	}

	public String getHosLunchEnd() {
		return hosLunchEnd;
	}

	public void setHosLunchEnd(String hosLunchEnd) {
		this.hosLunchEnd = hosLunchEnd;
	}

	@Override
	public String toString() {
		return "HospitalTimeTable [hosCode=" + hosCode + ", hosDay=" + hosDay + ", hosOpen=" + hosOpen + ", hosclose="
				+ hosClose + ", hosLunchStart=" + hosLunchStart + ", hosLunchEnd=" + hosLunchEnd + "]";
	}

}
