package com.scsa.model.service;

import java.util.List;

import com.scsa.model.dao.HospitalDAO;
import com.scsa.model.vo.Hospital;
import com.scsa.model.vo.HospitalTimeTable;

public class HospitalServiceImpl implements HospitalService {

	private HospitalDAO hospitalDao = null;

	public void setHospitalDao(HospitalDAO hospitalDao) {
		this.hospitalDao = hospitalDao;
	}

	@Override
	public boolean updateHospital(Hospital hospital) {
		return hospitalDao.updateHospital(hospital);
	}

	@Override
	public boolean login(String hosCode, String hosPassword) {
		return hospitalDao.login(hosCode, hosPassword);
	}

	@Override
	public Hospital selectHospital(String hosCode) {
		return hospitalDao.selectHospital(hosCode);
	}

	@Override
	public List<HospitalTimeTable> selectHospitalTimeTable(String hoscode) {
		return hospitalDao.selectHospitalTimeTable(hoscode);
	}

	@Override
	public boolean updateHospitalTimeTable(HospitalTimeTable hospitalTime) {
		return hospitalDao.updateHospitalTimeTable(hospitalTime);
	}

}
