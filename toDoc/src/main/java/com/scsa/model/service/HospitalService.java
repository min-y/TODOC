package com.scsa.model.service;

import java.util.List;

import com.scsa.model.vo.Hospital;
import com.scsa.model.vo.HospitalTimeTable;

public interface HospitalService {
	public boolean updateHospital(Hospital hospital);
	public boolean login(String hosCode, String hosPassword);
	public Hospital	selectHospital(String hosCode);
	public List<HospitalTimeTable> selectHospitalTimeTable(String hoscode);
	public boolean updateHospitalTimeTable(HospitalTimeTable hospitalTime);
}
