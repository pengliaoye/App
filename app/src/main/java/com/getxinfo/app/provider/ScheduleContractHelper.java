package com.getxinfo.app.provider;

import android.net.Uri;

/**
 * Created by pgy on 2016/4/27.
 */
public class ScheduleContractHelper {

    private static final String QUERY_PARAMETER_CALLER_IS_SYNC_ADAPTER = "callerIsSyncAdapter";

    public static Uri setUriAsCalledFromSyncAdapter(Uri uri) {
        return uri.buildUpon().appendQueryParameter(QUERY_PARAMETER_CALLER_IS_SYNC_ADAPTER, "true").build();
    }

}
