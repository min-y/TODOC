package com.scsa.model.service;

import java.util.List;
import java.util.Map;

import com.scsa.model.vo.PharmTodayList;
import com.scsa.model.vo.Pharmacy;
import com.scsa.model.vo.PrescriptionHistory;

public interface PharmService {
	public boolean login(String pharmCode, String pharmPassword);
	public Pharmacy findPharm(String pharmCode);
	public PharmTodayList findPharmTodayListByPreCode(String preCode);
	public List<PharmTodayList> findWaitList(String pharmCode);
	public List<PharmTodayList> findAcceptList(String pharmCode);
	public boolean updateWaitList(String pharmCode,String preCode);
	public boolean deleteWaitList(String pharmCode,String preCode);
	public boolean addPrescriptionHistory(PrescriptionHistory prescriptionHistory);
	public List<PrescriptionHistory> findDoneList(String pharmCode);
	public PrescriptionHistory findDoneDetail(String preCode);
	public List<PrescriptionHistory> findDoneListWithCondition(Map<String,Object> conditions);
}
