package com.getxinfo.app.welcome;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pgy on 2016/4/1.
 */
public class WelcomeActivity extends AppCompatActivity{

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