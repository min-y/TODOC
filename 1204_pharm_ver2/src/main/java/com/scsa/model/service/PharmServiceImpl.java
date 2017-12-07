package com.scsa.model.service;

import java.util.List;
import java.util.Map;

import com.scsa.model.dao.PharmDAO;
import com.scsa.model.vo.PharmTodayList;
import com.scsa.model.vo.Pharmacy;
import com.scsa.model.vo.PrescriptionHistory;

public class PharmServiceImpl implements PharmService {
	private PharmDAO pharmDAO;

	public void setPharmDAO(PharmDAO pharmDAO) {
		this.pharmDAO = pharmDAO;
	}

	@Override
	public boolean login(String pharmCode, String pharmPassword) {
		return pharmDAO.login(pharmCode, pharmPassword);
	}

	@Override
	public Pharmacy findPharm(String pharmCode) {
		return pharmDAO.findPharm(pharmCode);
	}
	
	@Override
	public PharmTodayList findPharmTodayListByPreCode(String preCode) {
		return pharmDAO.findPharmTodayListByPreCode(preCode);
	}
	
	@Override
	public List<PharmTodayList> findWaitList(String pharmCode) {
		return pharmDAO.findWaitList(pharmCode);
	}

	@Override
	public List<PharmTodayList> findAcceptList(String pharmCode) {
		return pharmDAO.findAcceptList(pharmCode);
	}

	@Override
	public List<PrescriptionHistory> findDoneList(String pharmCode) {
		return pharmDAO.findDoneList(pharmCode);
	}
	
	@Override
	public PrescriptionHistory findDoneDetail(String preCode) {
		return pharmDAO.findDoneDetail(preCode);
	}

	@Override
	public boolean updateWaitList(String pharmCode, String preCode) {
		return pharmDAO.updateWaitList(pharmCode,preCode);
	}

	@Override
	public boolean deleteWaitList(String pharmCode, String preCode) {
		return pharmDAO.deleteWaitList(pharmCode,preCode);
	}

	@Override
	public boolean addPrescriptionHistory(PrescriptionHistory prescriptionHistory) {
		return pharmDAO.insertPrescriptionHistory(prescriptionHistory);
	}

	@Override
	public List<PrescriptionHistory> findDoneListWithCondition(Map<String, Object> conditions) {
		return pharmDAO.findDoneListWithCondition(conditions);
	}


	

}
