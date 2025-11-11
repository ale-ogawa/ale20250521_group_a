package com.example.webapp.helper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.webapp.entity.Create;
import com.example.webapp.form.CreateForm;

public class CreateHelper {
	
	//Form>>>Entityに変換
	public static Create convert(CreateForm form) {
		Create create = new Create();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(form.getPassword());
		create.setAddress(form.getAddress());
		create.setPassword(encodedPassword);
		return create;
	}

}
