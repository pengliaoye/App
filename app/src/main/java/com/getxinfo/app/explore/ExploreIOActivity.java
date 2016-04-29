package com.getxinfo.app.explore;

import android.os.Bundle;

import com.getxinfo.app.R;
import com.getxinfo.app.ui.BaseActivity;

import static com.getxinfo.app.util.LogUtils.makeLogTag;

/**
 * Created by pgy on 2016/4/22.
 */
public class ExploreIOActivity extends BaseActivity{

    private static final String TAG = makeLogTag(ExploreIOActivity.class);

    private static final String SCREEN_LABEL = "Explore I/O";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.explore_io_act);
    }
}
