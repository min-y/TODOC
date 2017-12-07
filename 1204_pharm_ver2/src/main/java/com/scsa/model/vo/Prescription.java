package com.scsa.model.vo;

import java.io.Serializable;
import java.util.List;

public class Prescription implements Serializable{
	private String preCode;
	private int insuranceType;
	private String issueDate;
	private String issueNo;
	private String hosCode;
	private String patName;
	private String patSocialNo;
	private String hosName;
	private String hosTel;
	private String sickCode;
	private String docName;
	private String docCode;
	private int valDay;
	private List<PrescriptionMedicineList> prescriptionMedicineList;
	
	public Prescription() {
		super();
	}

	public Prescription(String preCode, int insuranceType, String issueDate, String issueNo, String hosCode,
			String patName, String patSocialNo, String hosName, String hosTel, String sickCode, String docName,
			String docCode, int valDay, List<PrescriptionMedicineList> prescriptionMedicineList) {
		super();
		this.preCode = preCode;
		this.insuranceType = insuranceType;
		this.issueDate = issueDate;
		this.issueNo = issueNo;
		this.hosCode = hosCode;
		this.patName = patName;
		this.patSocialNo = patSocialNo;
		this.hosName = hosName;
		this.hosTel = hosTel;
		this.sickCode = sickCode;
		this.docName = docName;
		this.docCode = docCode;
		this.valDay = valDay;
		this.prescriptionMedicineList = prescriptionMedicineList;
	}

	public String getPreCode() {
		return preCode;
	}

	public void setPreCode(String preCode) {
		this.preCode = preCode;
	}

	public int getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(int insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public String getHosCode() {
		return hosCode;
	}

	public void setHosCode(String hosCode) {
		this.hosCode = hosCode;
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

	public String getHosName() {
		return hosName;
	}

	public void setHosName(String hosName) {
		this.hosName = hosName;
	}

	public String getHosTel() {
		return hosTel;
	}

	public void setHosTel(String hosTel) {
		this.hosTel = hosTel;
	}

	public String getSickCode() {
		return sickCode;
	}

	public void setSickCode(String sickCode) {
		this.sickCode = sickCode;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocCode() {
		return docCode;
	}

	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}

	public int getValDay() {
		return valDay;
	}

	public void setValDay(int valDay) {
		this.valDay = valDay;
	}

	public List<PrescriptionMedicineList> getPrescriptionMedicineList() {
		return prescriptionMedicineList;
	}

	public void setPrescriptionMedicineList(List<PrescriptionMedicineList> prescriptionMedicineList) {
		this.prescriptionMedicineList = prescriptionMedicineList;
	}

	@Override
	public String toString() {
		return "Prescription [preCode=" + preCode + ", insuranceType=" + insuranceType + ", issueDate=" + issueDate
				+ ", issueNo=" + issueNo + ", hosCode=" + hosCode + ", patName=" + patName + ", patSocialNo="
				+ patSocialNo + ", hosName=" + hosName + ", hosTel=" + hosTel + ", sickCode=" + sickCode + ", docName="
				+ docName + ", docCode=" + docCode + ", valDay=" + valDay + ", prescriptionMedicineList="
				+ prescriptionMedicineList + "]";
	}
	

	
}
