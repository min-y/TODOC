package com.scsa.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.scsa.model.vo.Patient;

public class PatientDAOImpl implements PatientDAO {
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Patient> selectPatientList() {
		return sqlSession.selectList("Patient.selectPatientList");
	}

	@Override
	public List<Patient> selectPatientListByDate(Map<String, Object> conditions) {
		return sqlSession.selectList("Patient.selectPatientListByDate", conditions);
	}

}
