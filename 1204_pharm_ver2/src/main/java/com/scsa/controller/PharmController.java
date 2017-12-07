package com.scsa.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.scsa.model.service.PharmService;
import com.scsa.model.vo.PharmTodayList;
import com.scsa.model.vo.Pharmacy;
import com.scsa.model.vo.Prescription;
import com.scsa.model.vo.PrescriptionHistory;

@Controller
public class PharmController {
	private PharmService pharmService;
	@Autowired
	public void setPharmService(PharmService pharmService) {
		this.pharmService = pharmService;
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(HttpSession session
			,@RequestParam(name="pharmCode") String pharmCode
			,@RequestParam(name="pharmPassword") String pharmPassword) {
		if(pharmService.login(pharmCode, pharmPassword)){
			//session.removeAttribute("message");
			Pharmacy p=pharmService.findPharm(pharmCode);
			session.setAttribute("pharmName", p.getPharmName());
			session.setAttribute("pharmCode", pharmCode);
			return "redirect:/reservation_list.do";
		}
		//session.setAttribute("message", "로그인 실패");
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session=null;
		session=request.getSession();
		session.invalidate();
		return "redirect:/index.jsp";
	}
	
	@RequestMapping(value="recallWaitList.do", method=RequestMethod.GET)
	@ResponseBody
	public List<PharmTodayList> recallWaitList(Model model,@RequestParam(name="pharmCode") String pharmCode){
		return pharmService.findWaitList(pharmCode);
	}
	
	@RequestMapping("/reservation_list.do")
	public String reservation_list(HttpSession session, Model model) throws SQLException{
		String pharmCode = (String)session.getAttribute("pharmCode");
		List<PharmTodayList> waitList=pharmService.findWaitList(pharmCode);
		model.addAttribute("waitList",waitList);
		model.addAttribute("acceptList",pharmService.findAcceptList(pharmCode));
		session.setAttribute("waitNum",waitList.size());
		return "reservation";
	}
	
	@RequestMapping("/info_list.do")
	public String info_list(HttpSession session, Model model) throws SQLException{
		String pharmCode = (String)session.getAttribute("pharmCode");
		List<PrescriptionHistory> doneList=pharmService.findDoneList(pharmCode);
		model.addAttribute("doneList",doneList);
		return "info";
	}
	
	@RequestMapping("/wait_update.do")
	public String wait_update(HttpSession session, Model model
			, @RequestParam(name="preCode") String preCode) throws SQLException{
		String pharmCode = (String)session.getAttribute("pharmCode");
		pharmService.updateWaitList(pharmCode,preCode);
		return "redirect:/reservation_list.do";
	}
	
	@RequestMapping("/wait_delete.do")
	public String wait_delete(HttpSession session, Model model
			, @RequestParam String preCode) throws SQLException{
		try {
			String pharmCode = (String)session.getAttribute("pharmCode");
			pharmService.deleteWaitList(pharmCode,preCode);
			return "redirect:/reservation_list.do";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/reservation_list.do";
		}
	}
	
	@RequestMapping("/done_add.do")
	public String done_add(HttpSession session, Model model
			, @RequestParam String preCode) throws SQLException{
		PharmTodayList pharmTodayList = pharmService.findPharmTodayListByPreCode(preCode);
		String pharmCode = (String)session.getAttribute("pharmCode");
		int amount = pharmTodayList.getAmount();
		Prescription prescription = pharmTodayList.getPrescription();
		PrescriptionHistory prescriptionHistory = new PrescriptionHistory(pharmCode, preCode,"",amount,prescription);
		pharmService.deleteWaitList(pharmCode,preCode);
		pharmService.addPrescriptionHistory(prescriptionHistory);
		return "redirect:/reservation_list.do";
	}
	
	@RequestMapping("/search.do")
	public String search(HttpSession session, Model model
			, @RequestParam String patName, @RequestParam String date1
			, @RequestParam String date2) throws SQLException{
		String pharmCode = (String)session.getAttribute("pharmCode");
		HashMap<String, Object> conditions=new HashMap<>();
		conditions.put("pharmCode",pharmCode);
		if(patName != null && patName.trim().length() > 0){
			conditions.put("patname",patName);
		}
		if( (date1 != null && date1.trim().length() > 0 )
				&& (date2 != null && date2.trim().length() > 0 )){
			conditions.put("dateone",date1);
			conditions.put("datetwo",date2);
		}
		List<PrescriptionHistory> doneList=pharmService.findDoneListWithCondition(conditions);
		model.addAttribute("doneList",doneList);
		return "info";
	}

	@RequestMapping(value="done_detail.do", method=RequestMethod.GET)
	@ResponseBody
	public PrescriptionHistory done_detail(HttpSession session, Model model
			, @RequestParam String preCode) throws SQLException{
		System.out.println(pharmService.findDoneDetail(preCode));
		return pharmService.findDoneDetail(preCode);
	}
	
	@RequestMapping(value="today_detail.do", method=RequestMethod.GET)
	@ResponseBody
	public PharmTodayList today_detail(HttpSession session, Model model
			, @RequestParam String preCode) throws SQLException{
		return pharmService.findPharmTodayListByPreCode(preCode);
	}
	
/*	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(Exception exception){
		ModelAndView mav=new ModelAndView("error"); //view name
		mav.addObject("exception",exception);
		return mav;
	}*/
}
