//package com.example.webapp.controller;
//
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.example.webapp.entity.Medicine;
//import com.example.webapp.entity.Taking;
//import com.example.webapp.form.MedicineForm;
//import com.example.webapp.form.TakingForm;
//import com.example.webapp.helper.MedicineHelper;
//import com.example.webapp.helper.TakingHelper;
//import com.example.webapp.service.MedicineService;
//import com.example.webapp.service.TakingService;
//import com.example.webapp.utility.LoginAccount;
//
//import lombok.RequiredArgsConstructor;
//
//@Controller
//@RequestMapping("/medicine")
//@RequiredArgsConstructor
//public class MedicineController {
//	
//	private final MedicineService medicineService;
//
//	@GetMapping
//    public String medicine(Model model, MedicineForm form) {
//		List<Medicine> medicines = medicineService.select();
//		model.addAttribute("medicines", medicines);
//		model.addAttribute("attribute", LoginAccount.attribute);
//        return "medicine";
//    }
//	
//	@PostMapping
//	public String medicine(MedicineForm form) {
//		Medicine medicine = MedicineHelper.convert(form);
//		medicineService.insert(medicine);
//		return "redirect:/medicine";
//	}
//
//	private final TakingService takingService;
//	Integer takingId;
//	
//	@GetMapping("taking")
//    public String taking(Model model, TakingForm form) {
//		List<Medicine> medicines = medicineService.select();
//		if(takingId != null) {
//			List<Taking> takenMedicines = takingService.selectTaken(takingId);
//			model.addAttribute("takenMedicines", takenMedicines);
//		}
//		model.addAttribute("medicines", medicines);
//        return "taking";
//    }
//	
//	@PostMapping("taking")
//	public String taking(TakingForm form) {
//		Taking taking = TakingHelper.set();
//		takingService.insertTaking(taking);
//		takingId = taking.getTakingId();
//		System.out.println(takingId);
//		List<Taking> takings = TakingHelper.convert(form, takingId);
//		for(Taking t: takings) {
//			takingService.insert(t);
//		}
//		return "redirect:/medicine/taking";
//	}
//
//
//}
