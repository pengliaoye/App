package com.getxinfo.app.welcome;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.getxinfo.app.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.getxinfo.app.util.LogUtils.LOGD;
import static com.getxinfo.app.util.LogUtils.makeLogTag;

/**
 * Created by pgy on 2016/4/1.
 */
public class WelcomeActivity extends AppCompatActivity implements WelcomeFragment.WelcomeFragmentContainer{
    private static final String TAG = makeLogTag(WelcomeActivity.class);
    WelcomeActivityContent mContentPragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState
        );
        this.setContentView(R.layout.activity_welcome);

        mContentPragment = getCurrentFragment(this);

        // If there's no fragment to use, we're done here.
        if (mContentPragment == null) {
            finish();
        }

        // Wire up the fragment
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.welcome_content, (Fragment) mContentPragment);
        fragmentTransaction.commit();

        LOGD(TAG, "Inside Create View.");

        setupAnimation();
    }

    private void setupAnimation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ImageView iv = (ImageView) findViewById(R.id.logo);
            AnimatedVectorDrawable logoAnim = (AnimatedVectorDrawable) getDrawable(R.drawable.io_logo_white_anim);
            iv.setImageDrawable(logoAnim);
            logoAnim.start();
        }
    }

    private static WelcomeActivityContent getCurrentFragment(Context context) {
        List<WelcomeActivityContent> welcomeActivityContents = getWelcomeFragments();

        for (WelcomeActivityContent fragement : welcomeActivityContents) {
            if (fragement.shouldDisplay(context)){
                return fragement;
            }
        }

        return null;
    }

    public static boolean shouldDisplay(Context context) {
        WelcomeActivityContent fragment = getCurrentFragment(context);
        if (fragment == null) {
            return false;
        }

        return true;
    }

    private static List<WelcomeActivityContent> getWelcomeFragments() {
        return new ArrayList<WelcomeActivityContent>(Arrays.asList(
                new TosFragment(),
                new ConductFragment(),
                new AttendingFragment(),
                new AccountFragment()
        ));
    }

    @Override
    public Button getPositiveButton() {
        return (Button) findViewById(R.id.button_accept);
    }

    @Override
    public void setPositiveButtonEnabled(Boolean enabled) {
        try {
            getPositiveButton().setEnabled(enabled);
        } catch (NullPointerException e) {
            LOGD(TAG, "Positive welcome button doesn't exist to set enabled.");
        }
    }

    @Override
    public Button getNegativeButton() {
        return (Button) findViewById(R.id.button_decline);
    }

    @Override
    public void setNegativeButtonEnabled(Boolean enabled) {
        try {
            getNegativeButton().setEnabled(enabled);
        } catch (NullPointerException e) {
            LOGD(TAG, "Negative welcome button doesn't exist to set enabled.");
        }
    }

    interface WelcomeActivityContent {
        public boolean shouldDisplay(Context context);
    }

}