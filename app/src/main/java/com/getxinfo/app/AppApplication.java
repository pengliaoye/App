package com.getxinfo.app;

import android.app.Application;
import android.content.Intent;

import com.crashlytics.android.Crashlytics;
import com.getxinfo.app.util.AnalyticsHelper;
import com.google.android.gms.security.ProviderInstaller;

import io.fabric.sdk.android.Fabric;

import static com.getxinfo.app.util.LogUtils.LOGE;
import static com.getxinfo.app.util.LogUtils.LOGW;
import static com.getxinfo.app.util.LogUtils.makeLogTag;


/**
 * Created by pgy on 2016/1/31.
 */
public class AppApplication extends Application {

    private static final String TAG = makeLogTag(AppApplication.class);

    /*private UGClient client;

    public AppApplication(){
        this.client = client;
    }

    public UGClient getClient() {
        return client;
    }

    public void setClient(UGClient client) {
        this.client = client;
    }*/

    @Override
    public void onCreate() {
        super.onCreate();
        AnalyticsHelper.prepareAnalytics(getApplicationContext());
        Fabric.with(this, new Crashlytics());

        // Ensure an updated security provider is installed into the system when a new one is
        // available via Google Play services.
        try {
            ProviderInstaller.installIfNeededAsync(getApplicationContext(),
                    new ProviderInstaller.ProviderInstallListener() {
                        @Override
                        public void onProviderInstalled() {
                            LOGW(TAG, "New security provider installed.");
                        }

                        @Override
                        public void onProviderInstallFailed(int errorCode, Intent intent) {
                            LOGE(TAG, "New security provider install failed.");
                            // No notification shown there is no user intervention needed.
                        }
                    });
        } catch (Exception ignorable) {
            LOGE(TAG, "Unknown issue trying to install a new security provider.", ignorable);
        }
    }
}
