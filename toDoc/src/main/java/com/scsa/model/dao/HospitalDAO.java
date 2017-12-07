package com.scsa.model.dao;

import java.util.List;

import com.scsa.model.vo.Hospital;
import com.scsa.model.vo.HospitalTimeTable;

public interface HospitalDAO {
	public boolean updateHospital(Hospital hospital);
	public boolean login(String hosCode, String hosPassword);
	public Hospital	selectHospital(String hoscode);
	public List<HospitalTimeTable> selectHospitalTimeTable(String hoscode);
	public boolean updateHospitalTimeTable(HospitalTimeTable hospitalTime);
}	
