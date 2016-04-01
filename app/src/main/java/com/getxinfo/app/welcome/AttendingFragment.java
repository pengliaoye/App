package com.getxinfo.app.welcome;

import android.content.Context;

import com.getxinfo.app.settings.SettingsUtils;

/**
 * Created by pgy on 2016/4/1.
 */
public class AttendingFragment implements WelcomeActivity.WelcomeActivityContent {
    @Override
    public boolean shouldDisplay(Context context) {
        return SettingsUtils.hasAnsweredLocalOrRemote(context);
    }
}
