package com.getxinfo.app.welcome;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.getxinfo.app.R;
import com.getxinfo.app.settings.SettingsUtils;

import static com.getxinfo.app.util.LogUtils.LOGD;
import static com.getxinfo.app.util.LogUtils.makeLogTag;

/**
 * Created by pgy on 2016/4/1.
 */
public class ConductFragment extends WelcomeFragment implements WelcomeActivity.WelcomeActivityContent{

    private static final String TAG = makeLogTag(ConductFragment.class);

    @Override
    public boolean shouldDisplay(Context context) {
        return !SettingsUtils.isConductAccepted(context);
    }

    @Override
    protected View.OnClickListener getPositiveListener() {
        return new WelcomeFragmentOnClickListener(mActivity) {
            @Override
            public void onClick(View v) {
                // Ensure we don't run this fragment again
                LOGD(TAG, "Marking code of conduct flag.");
                SettingsUtils.markConductAccepted(mActivity, true);
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
                LOGD(TAG, "Need to accept Code of Conduct.");
                doFinish();
            }
        };
    }

    @Override
    protected String getPositiveText() {
        return getResourceString(R.string.accept);
    }

    @Override
    protected String getNegativeText() {
        return getResourceString(R.string.decline);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.welcome_conduct_fragment, container, false);
    }
}
