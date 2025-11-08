package com.example.webapp.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.Data;

@Data
public class CreateForm {
	//id
	@NotBlank(message = "メールアドレスを入力してください")
	private String address;
	
	//パスワード（半角数字6桁）
	 @NotBlank(message = "パスワードを入力してください")
	    @Pattern(regexp = "^[0-9]{6}$", message = "パスワードは半角数字6桁で入力してください")
	    private String password;
	//再入力パスワード
	 @NotBlank(message = "確認用パスワードを入力してください")
	    @Pattern(regexp = "^[0-9]{6}$", message = "パスワードは半角数字6桁で入力してください")
	    private String confirmPassword;
}

