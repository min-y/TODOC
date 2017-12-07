package com.scsa.model.vo;

public class TreatmentHistory {
	private String treatCode;
	private String hosCode;
	private String docCode;
	private String patCode;
	private String treatDate;
	private String preCode;
	private String recCode;
	private String recFile;

	private String patName;
	private String docName;

	public TreatmentHistory() {
		super();
	}

	public TreatmentHistory(String treatCode, String hosCode, String docCode, String patCode) {
		super();
		this.treatCode = treatCode;
		this.hosCode = hosCode;
		this.docCode = docCode;
		this.patCode = patCode;
	}
	
	

	public TreatmentHistory(String treatCode, String hosCode, String treatDate, String preCode, String recCode,
			String patName, String docName) {
		super();
		this.treatCode = treatCode;
		this.hosCode = hosCode;
		this.treatDate = treatDate;
		this.preCode = preCode;
		this.recCode = recCode;
		this.patName = patName;
		this.docName = docName;
	}

	public TreatmentHistory(String treatCode, String hosCode, String docCode, String patCode, String treatDate,
			String preCode, String recCode, String recFile) {
		super();
		this.treatCode = treatCode;
		this.hosCode = hosCode;
		this.docCode = docCode;
		this.patCode = patCode;
		this.treatDate = treatDate;
		this.preCode = preCode;
		this.recCode = recCode;
		this.recFile = recFile;
	}
	
	
	
	public TreatmentHistory(String treatCode, String hosCode, String docCode, String patCode, String treatDate,
			String preCode, String recCode, String recFile, String patName, String docName) {
		super();
		this.treatCode = treatCode;
		this.hosCode = hosCode;
		this.docCode = docCode;
		this.patCode = patCode;
		this.treatDate = treatDate;
		this.preCode = preCode;
		this.recCode = recCode;
		this.recFile = recFile;
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

	public String getDocCode() {
		return docCode;
	}

	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}

	public String getPatCode() {
		return patCode;
	}

	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}

	public String getTreatDate() {
		return treatDate;
	}

	public void setTreatDate(String treatDate) {
		this.treatDate = treatDate;
	}

	public String getPreCode() {
		return preCode;
	}

	public void setPreCode(String preCode) {
		this.preCode = preCode;
	}

	public String getRecCode() {
		return recCode;
	}

	public void setRecCode(String recCode) {
		this.recCode = recCode;
	}

	public String getRecFile() {
		return recFile;
	}

	public void setRecFile(String recFile) {
		this.recFile = recFile;
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
		return "TreatmentHistory [treatCode=" + treatCode + ", hosCode=" + hosCode + ", docCode=" + docCode
				+ ", patCode=" + patCode + ", treatDate=" + treatDate + ", preCode=" + preCode + ", recCode=" + recCode
				+ ", recFile=" + recFile + ", patName=" + patName + ", docName=" + docName + "]";
	}

}
