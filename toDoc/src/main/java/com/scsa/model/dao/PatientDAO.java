package com.scsa.model.dao;

import java.util.List;
import java.util.Map;

import com.scsa.model.vo.Patient;

public interface PatientDAO {
	
	public List<Patient> selectPatientList();
	public List<Patient> selectPatientListByDate(Map<String, Object> conditions);
}
