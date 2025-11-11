package com.example.webapp.service;

import java.util.List;

import com.example.webapp.entity.Account;
import com.example.webapp.entity.Group;
import com.example.webapp.form.GroupForm;

public interface GroupService {

	List<Account> selectAccounts();

	List<Group> selectGroups();

	void insertGroup(Group group);

	void delete(Integer id);

	void updateGroup(GroupForm form);

	Group findByCode(Integer integer);

	void changeName(GroupForm form);
}
