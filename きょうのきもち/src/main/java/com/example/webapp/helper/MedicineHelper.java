package com.example.webapp.helper;

import com.example.webapp.entity.Medicine;
import com.example.webapp.form.MedicineForm;

public class MedicineHelper {
	
	//Form>>>Entityに変換
	public static Medicine convert(MedicineForm form) {
		Medicine medicine = new Medicine();
		medicine.setName(form.getName());
		medicine.setEffect(form.getEffect());
		medicine.setQuantity(form.getQuantity());
		medicine.setSideEffect(form.getSideEffect());
		return medicine;
	}

}
