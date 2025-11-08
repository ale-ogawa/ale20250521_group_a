package com.example.webapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webapp.entity.Medicine;
import com.example.webapp.repository.MedicineMapper;
import com.example.webapp.service.MedicineService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MedicineServiceImpl implements MedicineService {
	
	private final MedicineMapper medicineMapper;

	@Override
	public List<Medicine> select() {
		return medicineMapper.select();
	}

	@Override
	public void insert(Medicine medicine) {
		medicineMapper.insert(medicine);
	}

}
