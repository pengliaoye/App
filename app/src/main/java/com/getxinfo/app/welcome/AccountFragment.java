package com.getxinfo.app.welcome;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.getxinfo.app.R;
import com.getxinfo.app.util.AccountUtils;
import com.google.android.gms.auth.GoogleAuthUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.getxinfo.app.util.LogUtils.LOGD;
import static com.getxinfo.app.util.LogUtils.makeLogTag;

/**
 * Created by pgy on 2016/4/1.
 */
public class AccountFragment extends WelcomeFragment implements WelcomeActivity.WelcomeActivityContent {

    private static final String TAG = makeLogTag(AccountFragment.class);

    private AccountManager mAccountManager;
    private List<Account> mAccounts;

    @Override
    public boolean shouldDisplay(Context context) {
        Account account = AccountUtils.getActiveAccount(context);
        if (account == null) {
            return true;
        }

        return false;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mAccountManager = AccountManager.get(activity);
        mAccounts = new ArrayList<Account>(
                Arrays.asList(mAccountManager.getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE)));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mAccountManager = null;
        mAccounts = null;
    }

    @Override
    protected View.OnClickListener getPositiveListener() {
        return new WelcomeFragmentOnClickListener(mActivity) {
            @Override
            public void onClick(View v) {
                // Ensure we don't run this fragment again
                LOGD(TAG, "Marking attending flag.");

                doNext();
            }
        };
    }

    @Override
    protected View.OnClickListener getNegativeListener() {
        return new WelcomeFragmentOnClickListener(mActivity) {
            @Override
            public void onClick(View v) {
                // Nothing to do here
                LOGD(TAG, "User needs to select an account.");
                doFinish();
            }
        };
    }

    @Override
    protected String getPositiveText() {
        return getResourceString(R.string.ok);
    }

    @Override
    protected String getNegativeText() {
        return getResourceString(R.string.cancel);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.welcome_account_fragment, container, false);
        if (mAccounts == null) {
            LOGD(TAG, "No accounts to display.");
            return null;
        }

        return layout;
    }

}
