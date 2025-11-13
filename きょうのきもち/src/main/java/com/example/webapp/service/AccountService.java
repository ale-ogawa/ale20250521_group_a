package com.example.webapp.service;

import java.util.List;

import com.example.webapp.entity.Account;
import com.example.webapp.entity.Diary;
import com.example.webapp.entity.Disease;
import com.example.webapp.entity.Group;

public interface AccountService {
	
	void update(Account account);
	void updateNickname(Account account);

	void insertDiary(Diary diary);

	Account getNickname(Integer id);

	List<Disease> findDiseases(Integer id);

	Account findShare();

	void updateMyShare(Account account);
	
	void updateNewFollower(Group group);
	Account findMyInfo(String username);
	void updateAttribute();

}
