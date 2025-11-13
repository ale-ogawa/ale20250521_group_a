package com.example.webapp.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.webapp.entity.Account;
import com.example.webapp.repository.LoginMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final LoginMapper loginMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = loginMapper.selectByAddress(username);
		
		if (account != null) {
			return org.springframework.security.core.userdetails.User
	                .withUsername(account.getAddress())
	                .password(account.getPassword())
	                .roles("USER")
	                .build();
		}else {
			throw new UsernameNotFoundException(
					username + " => 指定しているユーザー名は存在しません");
		}
	}
	
}
