package com.scsa.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.scsa.model.vo.Doctor;

public class DoctorDAOImpl implements DoctorDAO {
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean createDoctor(Doctor doctor) {
		return sqlSession.insert("Doctor.insertDoctor", doctor) > 0;
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		return sqlSession.update("Doctor.updateDoctor", doctor) > 0;
	}

	@Override
	public boolean deleteDoctor(String docCode) {
		return sqlSession.delete("Doctor.deleteDoctor", docCode) > 0;
	}

	@Override
	public List<Doctor> searchDoctorList(String hosCode) {
		return sqlSession.selectList("Doctor.selectDoctorList", hosCode);
	}

}
