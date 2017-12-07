package com.scsa.model.dao;

import java.util.List;

import com.scsa.model.vo.Doctor;

public interface DoctorDAO {
	public boolean createDoctor(Doctor doctor);
	public boolean updateDoctor(Doctor doctor);
	public boolean deleteDoctor(String docCode);
	public List<Doctor>	searchDoctorList(String hosCode);
	//public Doctor searchDoctor(String docCode);
}
