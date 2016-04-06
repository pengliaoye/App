package com.getxinfo.app.welcome;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.getxinfo.app.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pgy on 2016/4/1.
 */
public class WelcomeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState
        );
        this.setContentView(R.layout.activity_welcome);

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

    interface WelcomeActivityContent {
        public boolean shouldDisplay(Context context);
    }

}