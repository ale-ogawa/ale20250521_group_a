package com.example.webapp.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.webapp.entity.Account;

@Mapper
public interface LoginMapper {
	
	Account selectByAddress(String address);

}
