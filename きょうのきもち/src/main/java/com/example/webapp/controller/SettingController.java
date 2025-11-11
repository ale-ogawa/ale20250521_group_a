package com.example.webapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webapp.entity.Account;
import com.example.webapp.entity.Disease;
import com.example.webapp.form.UserForm;
import com.example.webapp.service.AccountService;
import com.example.webapp.service.DiseaseService;
import com.example.webapp.utility.LoginAccount;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/setting")
@RequiredArgsConstructor
public class SettingController {
	
	private final AccountService accountService;
	private final DiseaseService diseaseService;

	@GetMapping
	public String setting() {
		return "setting";
	}
	
	Account account;
	List<Disease> diseases;
	List<Integer> myDiseaseIds;
	
	@GetMapping("/user")
	public String showUserSetting(Model model) {
		account = accountService.getNickname(LoginAccount.id);
		diseases = accountService.findDiseases(LoginAccount.id);
		model.addAttribute("account", account);
		model.addAttribute("diseases", diseases);
		model.addAttribute("attribute", LoginAccount.attribute);
		return "user";
	}
	
	@GetMapping("/user/edit")
	public String showEdit(Model model, UserForm userForm) {
		List<Disease> allDiseases = diseaseService.findAllDiseases();
		myDiseaseIds = diseaseService.makeIdsList(diseases);
		model.addAttribute("account", account);
		model.addAttribute("myDiseaseIds", myDiseaseIds);
		model.addAttribute("allDiseases", allDiseases);
		model.addAttribute("attribute", LoginAccount.attribute);
		return "user_edit";
	}
	
	@PostMapping("/user/edit")
	public String edit(Model model, UserForm userForm) {
		boolean hasError = false;

        // --- ニックネームのバリデーション ---
        String nicknameError = userForm.validateNickname();
        if (nicknameError != null) {
            model.addAttribute("errorNickname", nicknameError);
            hasError = true;
        }

        // --- 「その他」入力欄のバリデーション ---
        String otherError = userForm.validateOther();
        if (otherError != null) {
            model.addAttribute("errorOther", otherError);
            hasError = true;
        }

        // ✅ エラーがある場合：同じ画面に戻す
        if (hasError) {
            model.addAttribute("userForm", userForm);
            return "register";
        }

        // ==============================
        // ✅ アカウント登録処理
        // ==============================
        Account account = new Account();
        account.setId(LoginAccount.id);
        account.setNickname(userForm.getNickname());
        accountService.updateNickname(account);
        
        if(userForm.getOther() != null) {
        	Disease disease = diseaseService.insertNewDisease(userForm.getOther());
        	userForm.getDisorders().removeLast();
        	userForm.getDisorders().add(disease.getId());
        }
        if(LoginAccount.attribute) {
	        diseaseService.clearChoice(myDiseaseIds);
	        diseaseService.registerChoice(userForm.getDisorders());
        }
		return "redirect:/setting/user";
	}

}