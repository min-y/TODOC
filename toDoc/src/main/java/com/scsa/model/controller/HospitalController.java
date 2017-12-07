package com.scsa.model.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scsa.model.service.DoctorService;
import com.scsa.model.service.HospitalService;
import com.scsa.model.service.TreatmentService;
import com.scsa.model.vo.Doctor;
import com.scsa.model.vo.Hospital;
import com.scsa.model.vo.HospitalTimeTable;
import com.scsa.model.vo.Treatment;
import com.scsa.model.vo.TreatmentHistory;

@Controller
public class HospitalController {
	
	private HospitalService hospitalService;
	private DoctorService doctorService;
	private TreatmentService treatmentService;
	
	@Autowired
	public void setHospitalService(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}
	
	@Autowired
	public void setDoctorService(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	@Autowired
	public void setTreatmentService(TreatmentService treatmentService) {
		this.treatmentService = treatmentService;
	}

	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(Model model, 
						@RequestParam String hosCode,
						@RequestParam String hosPassword,
						HttpSession session){
		boolean flag=hospitalService.login(hosCode, hosPassword);
		if(flag){
			Hospital hospital=hospitalService.selectHospital(hosCode);
			session.setAttribute("hospital", hospital);
			return "redirect:/showReservationList.do";				
		}else{
			session.setAttribute("errorMsg", "아이디와 비밀번호를 확인하세요.");
			return "redirect:/index.jsp";
		}
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(Model model, HttpSession session){
		session.invalidate();
		return "redirect:/index.jsp";
	}
	
	@RequestMapping(value="recallReservationList.do", method=RequestMethod.GET)
	@ResponseBody
	public List<Treatment> recallReservationList(Model model,@RequestParam(name="hosCode") String hosCode){
		return treatmentService.selectTreatmentList(hosCode);
	}
	
	@RequestMapping(value="deleteReservation.do")	
	@ResponseBody
	public boolean deleteReservation(@RequestParam(name="hosCode") String hosCode, 
									@RequestParam(name="treatCode") String treatCode){
		return treatmentService.deleteTreatment(treatCode);
	}
	
	@RequestMapping(value="updateStatus.do")	
	@ResponseBody
	public boolean updateStatus(@RequestParam(name="hosCode") String hosCode, 
								@RequestParam(name="treatCode") String treatCode){
		return treatmentService.updateTreatment(treatCode);
	}
	
	@RequestMapping(value="insertToHistory.do")	
	@ResponseBody
	public boolean insertToHistory(@RequestParam(name="hosCode") String hosCode, 
								   @RequestParam(name="treatCode") String treatCode,
								   @RequestParam(name="docCode") String docCode,
								   @RequestParam(name="patCode") String patCode){
		treatmentService.updateTreatment(treatCode);
		treatmentService.deleteTreatment(treatCode);
		TreatmentHistory treatmentHistory=new TreatmentHistory(treatCode, hosCode, docCode, patCode);
		return treatmentService.insertToHistory(treatmentHistory);
	}
	
	@RequestMapping(value="/showReservationList.do")
	public String showReservationList(Model model,HttpSession session){
		Hospital hospital=(Hospital) session.getAttribute("hospital");
		String hosCode=hospital.getHosCode();
		model.addAttribute("treatmentList", treatmentService.selectTreatmentList(hosCode));
		model.addAttribute("nexttreatmentList", treatmentService.selectNextTreatmentList(hosCode));
		model.addAttribute("doctorList", doctorService.searchDoctorList(hosCode));
		return "reservation";
	}
	
	@RequestMapping(value="/showReseravtionListByDoctor.do")
	public String showReservationListByDoctor(Model model, HttpSession session,
												@RequestParam(name="docCode") String docCode){
		Hospital hospital = (Hospital) session.getAttribute("hospital");
		String hosCode = hospital.getHosCode();
		model.addAttribute("treatmentList", treatmentService.selectTreatmentListByDoctor(docCode));
		model.addAttribute("doctorList", doctorService.searchDoctorList(hosCode));
		return "reservation";
	}

	@RequestMapping(value="/showInfo.do")
	public String showInfo(Model model, @RequestParam(name="hosCode") String hosCode){
		model.addAttribute("treatmentList", treatmentService.selectTreatmentList(hosCode));
		model.addAttribute("hospital", hospitalService.selectHospital(hosCode));
		model.addAttribute("doctors", doctorService.searchDoctorList(hosCode));
		model.addAttribute("timetables", hospitalService.selectHospitalTimeTable(hosCode));
		return "info";
	}
	
	@RequestMapping(value="/updateHospital.do")
	public String updateHospital(Model model, 
			@RequestParam(name="hosCode") String hosCode,
			@RequestParam(name="hosName") String hosName,
			@RequestParam(name="hosTel") String hosTel,
			@RequestParam(name="hosAddress") String hosAddress,
			@RequestParam(name="hosInfo") String hosInfo){
		Hospital hospital=new Hospital();
		
		hospital.setHosCode(hosCode);
		hospital.setHosName(hosName);
		hospital.setHosTel(hosTel);
		hospital.setHosAddress(hosAddress);
		hospital.setHosInfo(hosInfo);
		
		System.out.println(hospital.toString());
		
		hospitalService.updateHospital(hospital);
		return "redirect:/showInfo.do?hosCode="+hosCode;
	}
	
	@RequestMapping(value="/updateDoctor.do")
	@ResponseBody
	public boolean updateDoctor(Model model, 
			@RequestParam(name="hosCode") String hosCode,
			@RequestParam(name="docCode") String docCode,
			@RequestParam(name="docName") String docName,
			@RequestParam(name="docPart") String docPart){

		Doctor doctor=new Doctor();
		doctor.setDocCode(docCode);
		doctor.setDocName(docName);
		doctor.setDocPart(docPart);
		
		return doctorService.updateDoctor(doctor);
	}
	
	@RequestMapping(value="/updateTimeTable.do")
	@ResponseBody
	public boolean updateTimeTable(Model model, 
			@RequestParam(name="hosCode") String hosCode,
			@RequestParam(name="hosDay") int hosDay,
			@RequestParam(name="hosOpen") String hosOpen,
			@RequestParam(name="hosClose") String hosClose,
			@RequestParam(name="hosLunchStart") String hosLunchStart,
			@RequestParam(name="hosLunchEnd") String hosLunchEnd){

		HospitalTimeTable hospitalTime=new HospitalTimeTable(hosCode, hosDay, hosOpen, hosClose, hosLunchStart, hosLunchEnd);
		
		return hospitalService.updateHospitalTimeTable(hospitalTime);
	}
	
	@RequestMapping(value="/insertDoctor.do")
	public String insertDoctor(Model model, HttpSession session,
			@RequestParam(name="docName") String docName,
			@RequestParam(name="docPart") String docPart){
		
		Doctor doctor=new Doctor();
		Hospital hospital=(Hospital) session.getAttribute("hospital");
		String hosCode= hospital.getHosCode();
		doctor.setHosCode(hosCode);
		doctor.setDocName(docName);
		doctor.setDocPart(docPart);
		doctorService.createDoctor(doctor);
		
		return "redirect:/showInfo.do?hosCode="+hosCode;
	}	
	
	@RequestMapping(value="/deleteDoctor.do")
	public String delete(Model model, HttpSession session,
			@RequestParam(name="docCode") String docCode) {
		doctorService.deleteDoctor(docCode);
		Hospital hospital=(Hospital) session.getAttribute("hospital");
		String hosCode= hospital.getHosCode();
		return "redirect:/showInfo.do?hosCode="+hosCode;
	}	
	
	@RequestMapping(value="/showRecord.do")
	public String showRecord(Model model,HttpSession session){
		Hospital hospital=(Hospital) session.getAttribute("hospital");
		String hosCode=hospital.getHosCode();
		model.addAttribute("treatmentList", treatmentService.selectTreatmentList(hosCode));
		model.addAttribute("historyList", treatmentService.selectHistoryList(hosCode));
		return "record";
	}
	
	@RequestMapping(value="/searchHistory.do")
	@ResponseBody
	public List<TreatmentHistory> searchHistory(HttpSession session,
												@RequestParam(name="patName") String patName,
			                                    @RequestParam(name="date1") String date1,
			                                    @RequestParam(name="date2") String date2){
		Hospital hospital=(Hospital) session.getAttribute("hospital");
		String hosCode=hospital.getHosCode();
		HashMap<String, Object> conditions=new HashMap<String, Object>();
		conditions.put("hosCode", hosCode);		
		if(patName!=null && patName.trim().length()!=0){
			conditions.put("patName", patName);			
		}
		if(date1!=null && date1.trim().length()!=0){
			conditions.put("startDate", date1);		
		}
		if(date2!=null && date2.trim().length()!=0){	
			conditions.put("endDate", date2);
		}
		System.out.println(conditions);
		System.out.println(treatmentService.selectHistoryListWithMultiCondition(conditions));
		return treatmentService.selectHistoryListWithMultiCondition(conditions);	
	}	

}
