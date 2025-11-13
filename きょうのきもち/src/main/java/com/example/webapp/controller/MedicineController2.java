package com.example.webapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webapp.entity.Medicine;
import com.example.webapp.entity.Taking;
import com.example.webapp.form.MedicineForm;
import com.example.webapp.form.TakingForm;
import com.example.webapp.helper.MedicineHelper;
import com.example.webapp.helper.TakingHelper;
import com.example.webapp.service.MedicineService;
import com.example.webapp.service.TakingService;
import com.example.webapp.utility.LoginAccount;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/medicine")
@RequiredArgsConstructor
public class MedicineController2 {
	
	private final MedicineService medicineService;
	private final TakingService takingService;
	Integer takingId;
	boolean medicineSelected;
	boolean takingSelected = true;

	@GetMapping
    public String medicine(Model model, MedicineForm medicineForm, TakingForm takingForm) {
		List<Medicine> medicines = medicineService.select();
		model.addAttribute("medicines", medicines);
		model.addAttribute("attribute", LoginAccount.attribute);
		
		if(takingId != null) {
			List<Taking> takenMedicines = takingService.selectTaken(takingId);
			model.addAttribute("takenMedicines", takenMedicines);
		}
		model.addAttribute("medicines", medicines);
		
		List<Taking> takenMedicinesAll = takingService.selectTakenAll();
		model.addAttribute("takenMedicinesAll", takenMedicinesAll);
		model.addAttribute("medicineSelected", medicineSelected);
		model.addAttribute("takingSelected", takingSelected);
		model.addAttribute("attribute", LoginAccount.attribute);
        return "medicine2";
    }
	
	@PostMapping
	public String medicine(MedicineForm medicineForm, TakingForm takingForm) {
		if(medicineForm.getName() != null) {
			Medicine medicine = MedicineHelper.convert(medicineForm);
			medicineService.insert(medicine);
			medicineSelected = true;
			takingSelected = false;
		}
		
		if(takingForm.getMedicineIds() != null) {
			Taking taking = TakingHelper.set();
			takingService.insertTaking(taking);
			takingId = taking.getTakingId();
			List<Taking> takings = TakingHelper.convert(takingForm, takingId);
			for(Taking t: takings) {
				takingService.insert(t);
			}
			medicineSelected = false;
			takingSelected = true;
		}
		
		return "redirect:/medicine";
	}


}
