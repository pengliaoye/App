package com.getxinfo.app.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static com.getxinfo.app.util.LogUtils.makeLogTag;

/**
 * Created by pgy on 2016/3/10.
 */
public class SettingsUtils {

    private static final String TAG = makeLogTag(SettingsUtils.class);

    private static final String CONFERENCE_YEAR_PREF_POSTFIX = "_2015";

    public static final String PREF_TOS_ACCEPTED = "pref_tos_accepted" +
            CONFERENCE_YEAR_PREF_POSTFIX;

    private static final String PREF_CONDUCT_ACCEPTED = "pref_conduct_accepted" +
            CONFERENCE_YEAR_PREF_POSTFIX;

    public static final String PREF_ANSWERED_LOCAL_OR_REMOTE = "pref_answered_local_or_remote" +
            CONFERENCE_YEAR_PREF_POSTFIX;

    public static boolean isTosAccepted(final Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(PREF_TOS_ACCEPTED, false);
    }

    public static boolean isConductAccepted(final Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(PREF_CONDUCT_ACCEPTED, false);
    }

    public static boolean hasAnsweredLocalOrRemote(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(PREF_ANSWERED_LOCAL_OR_REMOTE, false);
    }

}
