package com.getxinfo.app;

import android.app.Application;

import org.apache.usergrid.android.sdk.UGClient;

/**
 * Created by pgy on 2016/1/31.
 */
public class AppApplication extends Application {

    private UGClient client;

    public AppApplication(){
        this.client = client;
    }

    public UGClient getClient() {
        return client;
    }

    public void setClient(UGClient client) {
        this.client = client;
    }
}
