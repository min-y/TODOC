package com.scsa.model.vo;

import java.io.Serializable;

public class Medicine implements Serializable{

	String medCode;
	String medName;
	String medCompany;
	int specailMed;
	int medType;
	String medTypeName;
	
	
	public Medicine() {
		super();
	}
	
	
	public Medicine(String medCode, String medName, String medCompany, int specailMed, int medType,
			String medTypeName) {
		super();
		this.medCode = medCode;
		this.medName = medName;
		this.medCompany = medCompany;
		this.specailMed = specailMed;
		this.medType = medType;
		this.medTypeName = medTypeName;
	}


	public String getMedCode() {
		return medCode;
	}


	public void setMedCode(String medCode) {
		this.medCode = medCode;
	}


	public String getMedName() {
		return medName;
	}


	public void setMedName(String medName) {
		this.medName = medName;
	}


	public String getMedCompany() {
		return medCompany;
	}


	public void setMedCompany(String medCompany) {
		this.medCompany = medCompany;
	}


	public int getSpecailMed() {
		return specailMed;
	}


	public void setSpecailMed(int specailMed) {
		this.specailMed = specailMed;
	}


	public int getMedType() {
		return medType;
	}


	public void setMedType(int medType) {
		this.medType = medType;
	}


	public String getMedTypeName() {
		return medTypeName;
	}


	public void setMedTypeName(String medTypeName) {
		this.medTypeName = medTypeName;
	}

	@Override
	public String toString() {
		return "Medicine [medCode=" + medCode + ", medName=" + medName + ", medCompany=" + medCompany + ", specailMed="
				+ specailMed + ", medType=" + medType + ", medTypeName=" + medTypeName + "]";
	}

}
