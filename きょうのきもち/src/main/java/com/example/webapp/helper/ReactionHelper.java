package com.example.webapp.helper;

import com.example.webapp.entity.Reaction;
import com.example.webapp.form.ReactionForm;
import com.example.webapp.utility.LoginAccount;

public class ReactionHelper {
	
	public static Reaction convert(ReactionForm form, Integer diaryId) {
		Reaction reaction = new Reaction();
		reaction.setAccountId(LoginAccount.id);
		reaction.setDiaryId(diaryId);
		reaction.setStamp(form.getStamp());
		reaction.setComment(form.getComment());
		return reaction;
	}
	
}
