package com.scsa.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.scsa.model.vo.PharmTodayList;
import com.scsa.model.vo.Pharmacy;
import com.scsa.model.vo.Prescription;
import com.scsa.model.vo.PrescriptionHistory;

public class PharmDAOImpl implements PharmDAO {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean login(String pharmCode, String pharmPassword) {
		Pharmacy pharm=new Pharmacy(pharmCode, pharmPassword);
		return sqlSession.selectOne("pharmacy.loginPharm", pharm)!=null;
	}

	@Override
	public Pharmacy findPharm(String pharmCode) {
		return sqlSession.selectOne("pharmacy.selectPharm", pharmCode);
	}
	
	@Override
	public PharmTodayList findPharmTodayListByPreCode(String preCode) {
		return sqlSession.selectOne("pharmTodayList.findPharmTodayListByPreCodewithMedicineList", preCode);
	}

	@Override
	public List<PharmTodayList> findWaitList(String pharmCode) {
		return sqlSession.selectList("pharmTodayList.selectWaitList",pharmCode);
	}

	@Override
	public List<PharmTodayList> findAcceptList(String pharmCode) {
		return sqlSession.selectList("pharmTodayList.selectAcceptList",pharmCode);
	}

	@Override
	public List<PrescriptionHistory> findDoneList(String pharmCode) {
		return sqlSession.selectList("prescriptionHistory.selectDoneList",pharmCode);
	}
	
	@Override
	public PrescriptionHistory findDoneDetail(String preCode) {
		return sqlSession.selectOne("prescriptionHistory.selectDoneDetailwithMedicineList",preCode);
	}

	@Override
	public boolean updateWaitList(String pharmCode, String preCode) {
		return sqlSession.update("pharmTodayList.updateWaitList", preCode)>0;
	}

	@Override
	public boolean deleteWaitList(String pharmCode, String preCode) {
		return sqlSession.delete("pharmTodayList.deleteTodayList", preCode)>0;
	}

	@Override
	public boolean insertPrescriptionHistory(PrescriptionHistory prescriptionHistory) {
		return sqlSession.insert("pharmTodayList.insertPrescriptionHistory", prescriptionHistory)>0;
	}

	@Override
	public List<PrescriptionHistory> findDoneListWithCondition(Map<String, Object> conditions) {
		return sqlSession.selectList("prescriptionHistory.selectDoneListWithMultiCondition",conditions);
	}


}
