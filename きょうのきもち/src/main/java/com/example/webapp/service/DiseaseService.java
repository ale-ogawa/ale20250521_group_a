package com.example.webapp.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.webapp.entity.Choice;
import com.example.webapp.entity.Disease;
import com.example.webapp.repository.AccountMapper;
import com.example.webapp.repository.DiseaseMapper;
import com.example.webapp.utility.LoginAccount;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiseaseService {

    private final DiseaseMapper diseaseMapper;
    private final AccountMapper accountMapper;
    
    public List<Disease> findAllDiseases() {
    	return diseaseMapper.findAllDiseases();
    }
    
    public void registerChoice(List<Integer> diseaseIds) {
    	Choice choice = new Choice();
    	choice.setAccountId(LoginAccount.id);
    	choice.setDiseaseIds(diseaseIds);
    	diseaseMapper.insertChoice(choice);
    }

	public Disease insertNewDisease(String diseaseName) {
		Disease disease = new Disease();
		disease.setName(diseaseName);
		accountMapper.insertNewDisease(disease);
		return disease;
	}

	public List<Integer> makeIdsList(List<Disease> diseases) {
		List<Integer> ids = new ArrayList<>();
		for(Disease disease: diseases) {
			ids.add(disease.getId());
		}
		return ids;
	}

	public void clearChoice(List<Integer> myDiseaseIds) {
		Choice choice = new Choice();
		choice.setAccountId(LoginAccount.id);
		choice.setDiseaseIds(myDiseaseIds);
		accountMapper.clearChoice(choice);
	}
    
    

}

