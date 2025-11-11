package com.example.webapp.form;


import java.util.List;

import lombok.Data;

@Data
public class UserForm {

    private String nickname;        // ニックネーム
    private List<Integer> disorders; // チェックボックスの値（複数）
    private String other;           // 「その他」の入力欄


    // ==============================
    // ✅ 入力チェック（Controllerで利用）
    // ==============================

    /** ニックネームのバリデーション */
    public String validateNickname() {
        if (nickname == null || nickname.isEmpty()) {
            return "ニックネームを入力してください。";
        }
        if (nickname.length() > 10) {
            return "ニックネームは10文字以内で入力してください。";
        }
        return null; // エラーなし
    }

    /** 「その他」欄のバリデーション */
    public String validateOther() {
        if (other != null && other.length() > 30) {
            return "その他は30文字以内で入力してください。";
        }
        return null; // エラーなし
    }
}
