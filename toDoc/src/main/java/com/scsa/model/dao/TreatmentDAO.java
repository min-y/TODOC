package com.scsa.model.dao;

import java.util.List;
import java.util.Map;

import com.scsa.model.vo.Treatment;
import com.scsa.model.vo.TreatmentHistory;

public interface TreatmentDAO {
	public boolean insertTreatment(Treatment treatment);
	public boolean updateTreatment(String treatCode);
	public boolean deleteTreatment(String treatCode);
	public boolean insertToHistory(TreatmentHistory treatmentHistory);
	public List<Treatment> selectTreatmentList(String hosCode);
	public List<Treatment> selectTreatmentListByDoctor(String docCode);
	public List<TreatmentHistory> selectHistoryList(String hosCode);
	public List<TreatmentHistory> selectNextTreatmentList(String hosCode);
	public List<TreatmentHistory> selectHistoryListWithMultiCondition(Map<String, Object> conditions);
	
//	public Treatment selectTreatment();
}
