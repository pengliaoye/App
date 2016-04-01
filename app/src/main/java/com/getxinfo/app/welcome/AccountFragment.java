package com.getxinfo.app.welcome;

import android.accounts.Account;
import android.content.Context;

import com.getxinfo.app.util.AccountUtils;

/**
 * Created by pgy on 2016/4/1.
 */
public class AccountFragment implements WelcomeActivity.WelcomeActivityContent {
    @Override
    public boolean shouldDisplay(Context context) {
        Account account = AccountUtils.getActiveAccount(context);
        if (account == null) {
            return true;
        }

        return false;
    }
}
