package com.example.webapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webapp.entity.Account;
import com.example.webapp.entity.Diary;
import com.example.webapp.entity.Disease;
import com.example.webapp.entity.Group;
import com.example.webapp.repository.AccountMapper;
import com.example.webapp.service.AccountService;
import com.example.webapp.utility.LoginAccount;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
	
	private final AccountMapper accountMapper;
	
	@Override
	public void update(Account account) {
		accountMapper.update(account);
	}
	@Override
	public void updateNickname(Account account) {
		accountMapper.updateNickname(account);
	}

	@Override
	public void insertDiary(Diary diary) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public Account getNickname(Integer id) {
		return accountMapper.getNickname(id);
	}

	@Override
	public List<Disease> findDiseases(Integer id) {
		return accountMapper.findDiseases(id);
	}

	@Override
	public Account findShare() {
		Integer id = LoginAccount.attribute ? LoginAccount.id : LoginAccount.followId;
		return accountMapper.findShare(id);
	}

	@Override
	public void updateMyShare(Account account) {
		account.setId(LoginAccount.id);
		accountMapper.updateMyShare(account);
	}
	@Override
	public void updateNewFollower(Group group) {
		Account account = new Account();
		account.setGroupId(group.getId());
		account.setFollowId(group.getAccountId());
		account.setId(LoginAccount.id);
		accountMapper.updateNewFollower(account);
	}
	@Override
	public Account findMyInfo(String address) {
		return accountMapper.findMyInfo(address);
	}
	@Override
	public void updateAttribute() {
		Account account = new Account();
		account.setId(LoginAccount.id);
		account.setAttribute(LoginAccount.attribute);
		accountMapper.updateAttribute(account);
	}


}
