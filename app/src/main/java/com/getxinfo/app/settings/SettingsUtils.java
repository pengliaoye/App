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

    /**
     * Boolean preference indicating that the user will be attending the conference.
     */
    public static final String PREF_ATTENDEE_AT_VENUE = "pref_attendee_at_venue" +
            CONFERENCE_YEAR_PREF_POSTFIX;

    public static final String PREF_TOS_ACCEPTED = "pref_tos_accepted" +
            CONFERENCE_YEAR_PREF_POSTFIX;

    private static final String PREF_CONDUCT_ACCEPTED = "pref_conduct_accepted" +
            CONFERENCE_YEAR_PREF_POSTFIX;

    public static final String PREF_ANSWERED_LOCAL_OR_REMOTE = "pref_answered_local_or_remote" +
            CONFERENCE_YEAR_PREF_POSTFIX;

    /**
     * Set the attendee preference indicating whether they'll be attending Google I/O on site.
     *
     * @param context  Context to be used to edit the {@link android.content.SharedPreferences}.
     * @param newValue New value that will be set.
     */
    public static void setAttendeeAtVenue(final Context context, final boolean newValue) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean(PREF_ATTENDEE_AT_VENUE, newValue).apply();
    }

    public static boolean isTosAccepted(final Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(PREF_TOS_ACCEPTED, false);
    }

    public static boolean isConductAccepted(final Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(PREF_CONDUCT_ACCEPTED, false);
    }

    /**
     * Mark {@code newValue whether} the user has accepted the TOS so the app doesn't ask again.
     *
     * @param context Context to be used to edit the {@link android.content.SharedPreferences}.
     * @param newValue New value that will be set.
     */
    public static void markTosAccepted(final Context context, boolean newValue) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean(PREF_TOS_ACCEPTED, newValue).apply();
    }

    /**
     * Mark {@code newValue whether} the user has accepted the Code of Conduct so the app doesn't ask again.
     *
     * @param context Context to be used to edit the {@link android.content.SharedPreferences}.
     * @param newValue New value that will be set.
     */
    public static void markConductAccepted(final Context context, boolean newValue) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean(PREF_CONDUCT_ACCEPTED, newValue).apply();
    }

    public static boolean hasAnsweredLocalOrRemote(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(PREF_ANSWERED_LOCAL_OR_REMOTE, false);
    }

    /**
     * Mark that the user answered whether they're a local or remote I/O attendee.
     *
     * @param context  Context to be used to edit the {@link android.content.SharedPreferences}.
     * @param newValue New value that will be set.
     */
    public static void markAnsweredLocalOrRemote(final Context context, boolean newValue) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean(PREF_ANSWERED_LOCAL_OR_REMOTE, newValue).apply();
    }

}
