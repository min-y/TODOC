package com.scsa.model.vo;

public class Doctor {
	private String docCode;
	private String hosCode;
	private String docName;
	private String docPart;
	private String docImage;

	public Doctor() {
		super();
	}

	

	public Doctor(String docCode, String hosCode, String docName, String docPart, String docImage) {
		super();
		this.docCode = docCode;
		this.hosCode = hosCode;
		this.docName = docName;
		this.docPart = docPart;
		this.docImage = docImage;
	}



	public String getDocCode() {
		return docCode;
	}

	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}

	public String getHosCode() {
		return hosCode;
	}

	public void setHosCode(String hosCode) {
		this.hosCode = hosCode;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocPart() {
		return docPart;
	}

	public void setDocPart(String docPart) {
		this.docPart = docPart;
	}
	
	
	
	public String getDocImage() {
		return docImage;
	}



	public void setDocImage(String docImage) {
		this.docImage = docImage;
	}



	@Override
	public String toString() {
		return "Doctor [docCode=" + docCode + ", hosCode=" + hosCode + ", docName=" + docName + ", docPart=" + docPart
				+ ", docImage=" + docImage + "]";
	}
	
	

}
