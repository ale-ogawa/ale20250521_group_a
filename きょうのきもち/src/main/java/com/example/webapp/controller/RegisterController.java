package com.example.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.webapp.entity.Account;
import com.example.webapp.form.UserForm;
import com.example.webapp.repository.AccountMapper;
import com.example.webapp.service.DiseaseService;

@Controller
public class RegisterController {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private DiseaseService diseaseService;

    // ==============================
    // ✅ 登録画面の表示
    // ==============================
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    // ==============================
    // ✅ フォーム送信処理
    // ==============================
    @PostMapping("/register")
    public String submitRegisterForm(@ModelAttribute("userForm") UserForm userForm, Model model) {

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
        account.setNickname(userForm.getNickname());
        account.setAttribute(true); // 固定値（患者）
        account.setAddress(null);
        account.setPassword(null);
        account.setGroupId(null);
        account.setFollowId(null);

        // INSERT実行（useGeneratedKeys=true でIDが自動取得）
        accountMapper.insert(account);

        // ==============================
        // ✅ 疾患登録処理（choicesテーブル + diseasesテーブル）
        // ==============================
        if (userForm.getDisorders() != null) {
            for (String disorder : userForm.getDisorders()) {
                // 「その他」は除外して、既存疾患のみ登録
                if (!"その他".equals(disorder)) {
                    diseaseService.registerChoice(account.getId(), disorder);
                }
            }
        }

        // 「その他」入力あり → diseases + choices に登録
        if (userForm.getOther() != null && !userForm.getOther().isBlank()) {
            diseaseService.registerOtherDisease(account.getId(), userForm.getOther());
        }

        // ==============================
        // ✅ 登録完了ページへ遷移
        // ==============================
        return "test"; // 完了画面（HTML名は任意）
    }
}
