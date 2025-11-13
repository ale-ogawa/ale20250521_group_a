package com.example.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private DiseaseService diseaseService;

    // ==============================
    // ✅ 登録画面の表示
    // ==============================
    @GetMapping
    public String showRegisterForm(Model model, UserForm userForm) {
    	List<Disease> diseases = diseaseService.findAllDiseases();
        model.addAttribute("diseases", diseases);
        model.addAttribute("attribute", LoginAccount.attribute);
        return "register";
    }
    
    // ==============================
    // ✅ フォーム送信処理
    // ==============================
    @PostMapping
    public String submitRegisterForm(Model model, UserForm userForm) {

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
        account.setAttribute(LoginAccount.attribute); // 固定値（患者）
        accountService.update(account);
        
        if(userForm.getOther() != null) {
        	Disease disease = diseaseService.insertNewDisease(userForm.getOther());
        	userForm.getDisorders().removeLast();
        	userForm.getDisorders().add(disease.getId());
        }
        if(LoginAccount.attribute) {
        	diseaseService.registerChoice(userForm.getDisorders());
        }
        
        return "register_complete"; // 完了画面（HTML名は任意）
    }
}
