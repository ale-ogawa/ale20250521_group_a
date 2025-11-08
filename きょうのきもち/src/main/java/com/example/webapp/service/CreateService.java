package com.example.webapp.service;

import org.springframework.stereotype.Service;

import com.example.webapp.entity.Create;

@Service
public interface CreateService {

	void insert(Create create);

}
