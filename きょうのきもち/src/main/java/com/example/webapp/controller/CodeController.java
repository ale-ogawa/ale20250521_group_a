package com.example.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.webapp.entity.Group;
import com.example.webapp.form.CodeForm;
import com.example.webapp.service.AccountService;
import com.example.webapp.service.GroupService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CodeController {

	private final GroupService groupService;
	private final AccountService accountService;
	
    // 招待コード入力画面を表示（初回アクセス時）
    @GetMapping("/code")
    public String showCodeForm(Model model) {
        model.addAttribute("codeForm", new CodeForm());
        return "code";
    }

    // 招待コード送信処理
    @PostMapping("/verifyCode")
    public String verifyCode(Model model, CodeForm codeForm) {

    	//DBからコードが一致するレコードを取得
    	Group group = groupService.findByCode(codeForm.getCode());
    	//nullならreturn "code";
    	if (group == null) {
    		model.addAttribute("error", "招待コードが違います");
    		return "code"; // ❌ redirectしない → 無限ループ防止
    	}
    	//not nullならアカウントテーブルにfollow_idとgroup_idを登録
    	accountService.updateNewFollower(group);

        return "redirect:/register";
    }
}
