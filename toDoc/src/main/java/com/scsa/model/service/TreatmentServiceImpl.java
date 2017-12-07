package com.scsa.model.service;

import java.util.List;
import java.util.Map;

import com.scsa.model.dao.TreatmentDAO;
import com.scsa.model.vo.Treatment;
import com.scsa.model.vo.TreatmentHistory;

public class TreatmentServiceImpl implements TreatmentService {
	
	private TreatmentDAO treatmentDao=null;
	
	public void setTreatmentDao(TreatmentDAO treatmentDao) {
		this.treatmentDao = treatmentDao;
	}

	@Override
	public boolean insertTreatment(Treatment treatment) {
		return treatmentDao.insertTreatment(treatment);
	}

	@Override
	public boolean updateTreatment(String treatCode) {
		return treatmentDao.updateTreatment(treatCode);
	}

	@Override
	public boolean deleteTreatment(String treatCode) {
		return treatmentDao.deleteTreatment(treatCode);
	}

	@Override
	public List<Treatment> selectTreatmentList(String hosCode) {
		return treatmentDao.selectTreatmentList(hosCode);
	}

	@Override
	public List<Treatment> selectTreatmentListByDoctor(String docCode) {
		return treatmentDao.selectTreatmentListByDoctor(docCode);
	}

	@Override
	public boolean insertToHistory(TreatmentHistory treatmentHistory) {
		return treatmentDao.insertToHistory(treatmentHistory);
	}

	@Override
	public List<TreatmentHistory> selectHistoryList(String hosCode) {
		return treatmentDao.selectHistoryList(hosCode);
	}

	@Override
	public List<TreatmentHistory> selectHistoryListWithMultiCondition(Map<String, Object> conditions) {
		return treatmentDao.selectHistoryListWithMultiCondition(conditions);
	}

	@Override
	public List<TreatmentHistory> selectNextTreatmentList(String hosCode) {
		return treatmentDao.selectNextTreatmentList(hosCode);
	}

}
