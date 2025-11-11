package com.example.webapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webapp.entity.Account;
import com.example.webapp.entity.Group;
import com.example.webapp.form.GroupForm;
import com.example.webapp.repository.GroupMapper;
import com.example.webapp.service.GroupService;
import com.example.webapp.utility.LoginAccount;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
	
	private final GroupMapper groupMapper;

	@Override
	public List<Account> selectAccounts() {
		return groupMapper.selectAccounts(LoginAccount.id);
	}

	@Override
	public List<Group> selectGroups() {
		return groupMapper.selectGroups(LoginAccount.id);
	}

	@Override
	public void insertGroup(Group group) {
		groupMapper.insertGroup(group);
	}

	@Override
	public void delete(Integer id) {
		groupMapper.delete(id);
	}

	@Override
	public void updateGroup(GroupForm form) {
		groupMapper.update(form);
	}

	@Override
	public Group findByCode(Integer code) {
		return groupMapper.findByCode(code);
	}

	@Override
	public void changeName(GroupForm form) {
		groupMapper.changeName(form);
	}

}
