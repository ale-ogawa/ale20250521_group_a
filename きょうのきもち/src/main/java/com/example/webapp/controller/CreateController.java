package com.example.webapp.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webapp.entity.Create;
import com.example.webapp.form.CreateForm;
import com.example.webapp.helper.CreateHelper;
import com.example.webapp.service.CreateService;
import com.example.webapp.utility.LoginAccount;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/create")
public class CreateController {

	private final CreateService createService;

	@GetMapping
	public String showCreateForm(CreateForm createForm) {
		return "create";
	}

	// 確認画面へ
	@PostMapping("/confirm")
	public String confirm(
			@Valid CreateForm form, BindingResult bindingResult, Model model) {

		// まず入力チェック（桁数など）が通ってから一致チェックする
		if (!bindingResult.hasFieldErrors("password") &&
				!bindingResult.hasFieldErrors("confirmPassword")) {

			// パスワード一致チェック
			if (!form.getPassword().equals(form.getConfirmPassword())) {
				bindingResult.rejectValue("confirmPassword", "error.confirmPassword", "パスワードが一致しません");
			}
		}

		// 入力エラーがある場合は再表示
		if (bindingResult.hasErrors()) {
			return "create";
		}

		model.addAttribute("createForm", form);
		return "confirm"; // 確認画面に遷移（confirm.htmlを想定）
	}

	//登録完了
	@PostMapping("/complete")
	public String complete(CreateForm form) {
		Create create = CreateHelper.convert(form);
		createService.insert(create);
		LoginAccount.id = create.getId();
		LoginAccount.attribute = true;
		return "complete";
	}

}
