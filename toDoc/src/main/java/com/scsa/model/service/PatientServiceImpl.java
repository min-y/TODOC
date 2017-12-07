package com.scsa.model.service;

import java.util.List;
import java.util.Map;

import com.scsa.model.dao.PatientDAO;
import com.scsa.model.vo.Patient;

public class PatientServiceImpl implements PatientService {
	
	private PatientDAO patientDao=null;	

	public void setPatientDao(PatientDAO patientDao) {
		this.patientDao = patientDao;
	}

	@Override
	public List<Patient> selectPatientList() {
		return patientDao.selectPatientList();
	}

	@Override
	public List<Patient> selectPatientListByDate(Map<String, Object> conditions) {
		return patientDao.selectPatientListByDate(conditions);
	}

}
