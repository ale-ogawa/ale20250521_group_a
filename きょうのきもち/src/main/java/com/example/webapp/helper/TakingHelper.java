package com.example.webapp.helper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.webapp.entity.Taking;
import com.example.webapp.form.TakingForm;
import com.example.webapp.utility.LoginAccount;

public class TakingHelper {
	
	//Form>>>Entityに変換
	public static List<Taking> convert(TakingForm form, Integer takingId) {
		List<Taking> takings = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		for (String s : form.getDose()) {
			if(s != null && !s.isEmpty()) {
				tmp.add(Integer.parseInt(s));
			}
		}
		for(int i = 0; i < form.getMedicineIds().size(); i++) {
			Taking taking = new Taking();
			taking.setTakingId(takingId);
			taking.setMedicineId(Integer.parseInt(form.getMedicineIds().get(i)));
			taking.setDose(tmp.get(i));
			takings.add(taking);
		}
		return takings;
	}
	
	public static Taking set() {
		Taking taking = new Taking();
		taking.setAccountId(LoginAccount.id);
		taking.setTime(LocalDateTime.now());
		return taking;
	}


}
