package com.scsa.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.scsa.model.vo.Treatment;
import com.scsa.model.vo.TreatmentHistory;

public class TreatmentDAOImpl implements TreatmentDAO {
	
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public boolean insertTreatment(Treatment treatment) {
		return sqlSession.insert("Treatment.insertTreatment", treatment)>0;
	}

	@Override
	public boolean updateTreatment(String treatCode) {
		return sqlSession.update("Treatment.updateTreatment", treatCode)>0;
	}

	@Override
	public boolean deleteTreatment(String treatCode) {
		return sqlSession.delete("Treatment.deleteTreatment", treatCode)>0;
	}

	@Override
	public List<Treatment> selectTreatmentList(String hosCode) {
		return sqlSession.selectList("Treatment.selectTreatmentList",hosCode);
		
	}

	@Override
	public List<Treatment> selectTreatmentListByDoctor(String docCode) {
		return sqlSession.selectList("Treatment.selectTreatmentListByDoctor",docCode);
	}

	@Override
	public boolean insertToHistory(TreatmentHistory treatmentHistory) {
		return sqlSession.insert("Treatment.insertToHistory", treatmentHistory)>0;
	}

	@Override
	public List<TreatmentHistory> selectHistoryList(String hosCode) {
		return sqlSession.selectList("Treatment.selectHistoryList", hosCode);
	}

	@Override
	public List<TreatmentHistory> selectHistoryListWithMultiCondition(Map<String, Object> conditions) {
		return sqlSession.selectList("Treatment.selectHistoryListWithMultiCondition", conditions);
	}

	@Override
	public List<TreatmentHistory> selectNextTreatmentList(String hosCode) {
		return sqlSession.selectList("Treatment.selectNextTreatmentList", hosCode);
	}

}
