package com.example.webapp.service;

import java.util.List;

import com.example.webapp.entity.Medicine;

public interface MedicineService {

	List<Medicine> select();

	void insert(Medicine medicine);
	
}
