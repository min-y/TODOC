package com.scsa.model.vo;

public class Treatment {
	private String treatCode;
	private String hosCode;
	private String patCode;
	private String treatTime;
	private String docCode;
	private int treatStatus;
	
	private String patName;
	private String docName;

	public Treatment() {
		super();
	}

	public Treatment(String treatCode, String hosCode, String patCode, String treatTime, String docCode,
			int treatStatus, String patName, String docName) {
		super();
		this.treatCode = treatCode;
		this.hosCode = hosCode;
		this.patCode = patCode;
		this.treatTime = treatTime;
		this.docCode = docCode;
		this.treatStatus = treatStatus;
		this.patName = patName;
		this.docName = docName;
	}

	public String getTreatCode() {
		return treatCode;
	}

	public void setTreatCode(String treatCode) {
		this.treatCode = treatCode;
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

	public String getTreatTime() {
		return treatTime;
	}

	public void setTreatTime(String treatTime) {
		this.treatTime = treatTime;
	}

	public String getDocCode() {
		return docCode;
	}

	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}

	public int getTreatStatus() {
		return treatStatus;
	}

	public void setTreatStatus(int treatStatus) {
		this.treatStatus = treatStatus;
	}

	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	@Override
	public String toString() {
		return "Treatment [treatCode=" + treatCode + ", hosCode=" + hosCode + ", patCode=" + patCode + ", treatTime="
				+ treatTime + ", docCode=" + docCode + ", treatStatus=" + treatStatus + ", patName=" + patName
				+ ", docName=" + docName + "]";
	}

}
