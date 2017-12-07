package com.scsa.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.scsa.model.vo.Hospital;
import com.scsa.model.vo.HospitalTimeTable;

public class HospitalDAOImpl implements HospitalDAO {
	
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean updateHospital(Hospital hospital) {
		return sqlSession.update("Hospital.updateHospital", hospital)>0;
	}

	@Override
	public boolean login(String hosCode, String hosPassword) {
		Hospital hospital=new Hospital(hosCode, hosPassword);
		return sqlSession.selectOne("Hospital.login", hospital)!=null;
	}

	@Override
	public Hospital selectHospital(String hoscode) {
		return sqlSession.selectOne("Hospital.selectHospital", hoscode);
	}

	@Override
	public List<HospitalTimeTable> selectHospitalTimeTable(String hoscode) {
		return sqlSession.selectList("Hospital.selectHospitalTimeTable", hoscode);
	}

	@Override
	public boolean updateHospitalTimeTable(HospitalTimeTable hospitalTime) {
		return sqlSession.update("Hospital.updateHospitalTimeTable", hospitalTime)>0;
	}

}
