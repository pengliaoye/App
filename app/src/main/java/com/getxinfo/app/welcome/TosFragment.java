package com.getxinfo.app.welcome;

import android.content.Context;

import com.getxinfo.app.settings.SettingsUtils;

import static com.getxinfo.app.util.LogUtils.makeLogTag;

/**
 * Created by pgy on 2016/4/1.
 */
public class TosFragment implements WelcomeActivity.WelcomeActivityContent{

    private static final String TAG = makeLogTag(TosFragment.class);

    @Override
    public boolean shouldDisplay(Context context) {
        return !SettingsUtils.isTosAccepted(context);
    }
}
