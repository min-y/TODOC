package com.scsa.model.service;

import java.util.List;
import java.util.Map;

import com.scsa.model.vo.Patient;

public interface PatientService {
	public List<Patient> selectPatientList();
	public List<Patient> selectPatientListByDate(Map<String, Object> conditions);
}
