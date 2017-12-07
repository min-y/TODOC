package com.scsa.model.service;

import java.util.List;

import com.scsa.model.dao.DoctorDAO;
import com.scsa.model.vo.Doctor;

public class DoctorServiceImpl implements DoctorService {
	
	private DoctorDAO doctorDao=null;
	
	public void setDoctorDao(DoctorDAO doctorDao) {
		this.doctorDao = doctorDao;
	}

	@Override
	public boolean createDoctor(Doctor doctor) {
		return doctorDao.createDoctor(doctor);
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		return doctorDao.updateDoctor(doctor);
	}

	@Override
	public boolean deleteDoctor(String docCode) {
		return doctorDao.deleteDoctor(docCode);
	}

	@Override
	public List<Doctor> searchDoctorList(String hosCode) {
		return doctorDao.searchDoctorList(hosCode);
	}
}
