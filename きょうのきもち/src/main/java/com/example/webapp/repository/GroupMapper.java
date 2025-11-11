package com.example.webapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.webapp.entity.Account;
import com.example.webapp.entity.Group;
import com.example.webapp.form.GroupForm;

@Mapper
public interface GroupMapper {
	
	List<Account> selectAccounts(Integer accountId);

	List<Group> selectGroups(Integer accountId);

	void insertGroup(Group group);

	void delete(Integer id);

	void update(GroupForm form);

	Group findByCode(Integer code);

	void changeName(GroupForm form);

}
