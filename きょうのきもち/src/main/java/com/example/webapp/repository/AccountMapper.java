package com.example.webapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.webapp.entity.Account;
import com.example.webapp.entity.Choice;
import com.example.webapp.entity.Disease;
import com.example.webapp.entity.Group;

@Mapper
public interface AccountMapper {

    // accountsテーブルへ新規登録
    void update(Account account);
    void updateNickname(Account account);

	void insertNewDisease(Disease disease);

	Account getNickname(Integer id);

	List<Disease> findDiseases(Integer accountId);

	Account findShare(Integer id);

	void updateMyShare(Account account);

	void clearChoice(Choice choice);
	
	void updateNewFollower(Group group);
	
	Account findMyInfo(String address);

}