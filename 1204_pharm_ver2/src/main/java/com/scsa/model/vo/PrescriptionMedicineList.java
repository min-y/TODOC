package com.scsa.model.vo;

import java.io.Serializable;

public class PrescriptionMedicineList implements Serializable {
	private String preCode;
	private String medCode;
	private String medName;
	private int dosage;
	private int dosDay;
	
	public PrescriptionMedicineList() {
		super();
	}

	public PrescriptionMedicineList(String preCode, String medCode, String medName, int dosage, int dosDay) {
		super();
		this.preCode = preCode;
		this.medCode = medCode;
		this.medName = medName;
		this.dosage = dosage;
		this.dosDay = dosDay;
	}

	public String getPreCode() {
		return preCode;
	}

	public void setPreCode(String preCode) {
		this.preCode = preCode;
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

	public int getDosage() {
		return dosage;
	}

	public void setDosage(int dosage) {
		this.dosage = dosage;
	}

	public int getDosDay() {
		return dosDay;
	}

	public void setDosDay(int dosDay) {
		this.dosDay = dosDay;
	}

	@Override
	public String toString() {
		return "PrescriptionMedicineList [preCode=" + preCode + ", medCode=" + medCode + ", medName=" + medName
				+ ", dosage=" + dosage + ", dosDay=" + dosDay + "]";
	}
	
	
}
