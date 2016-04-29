package com.getxinfo.app.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.getxinfo.app.R;
import com.getxinfo.app.io.JSONHandler;
import com.getxinfo.app.settings.SettingsUtils;
import com.getxinfo.app.util.LogUtils;

import java.io.IOException;

import static com.getxinfo.app.util.LogUtils.LOGD;
import static com.getxinfo.app.util.LogUtils.LOGW;

/**
 * Created by pgy on 2016/4/26.
 */
public class DataBootstrapService extends IntentService {

    private static final String TAG = LogUtils.makeLogTag(DataBootstrapService.class);

    public static void startDataBootstrapIfNecessary(Context context) {
        if (!SettingsUtils.isDataBootstrapDone(context)) {
            LOGW(TAG, "One-time data bootstrap not done yet. Doing now.");
            context.startService(new Intent(context, DataBootstrapService.class));
        }
    }

    public DataBootstrapService() { super(TAG); }

    @Override
    protected void onHandleIntent(Intent intent) {
        Context appContext = getApplicationContext();

        if (SettingsUtils.isDataBootstrapDone(appContext)) {
            LOGD(TAG, "Data bootstrap already done.");
            return;
        }

        try {
            LOGD(TAG, "Starting data bootstrap process.");
            // Load data from bootstrap raw resource.
            String bootstrapJson = JSONHandler.parseResource(appContext, R.raw.bootstrap_data);

            // Apply the data we read to the database with the help of the ConferenceDataHandler.

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
