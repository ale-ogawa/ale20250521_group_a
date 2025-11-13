package com.example.webapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webapp.entity.Account;
import com.example.webapp.entity.Disease;
import com.example.webapp.service.AccountService;
import com.example.webapp.utility.LoginAccount;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/info")
@RequiredArgsConstructor
public class InformationController {
	
	private final AccountService accountService;
	
	@GetMapping
    public String info() {
        return "information";
    }
	
	@GetMapping("/disease")
	public String disease(Model model) {
		Account account;
		List<Disease> diseases;
		if(LoginAccount.attribute) {
			account = accountService.getNickname(LoginAccount.id);
			diseases = accountService.findDiseases(LoginAccount.id);
		}else {
			account = accountService.getNickname(LoginAccount.followId);
			diseases = accountService.findDiseases(LoginAccount.followId);
		}
		model.addAttribute("account", account);
		model.addAttribute("diseases", diseases);
		return "disease";
	}
	
	@GetMapping("/share")
	public String share(Model model, Account account) {
		account = accountService.findShare();
		model.addAttribute("account", account);
		model.addAttribute("attribute", LoginAccount.attribute);
		return "share";
	}
	
	@PostMapping("/share")
	public String share(Account account) {
		accountService.updateMyShare(account);
		return "redirect:/info/share";
	}

}