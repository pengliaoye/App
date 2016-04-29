package com.getxinfo.app.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by pgy on 2016/4/22.
 */
public class CollectionView extends ListView{

    public CollectionView(Context context) {
        this(context, null);
    }

    public CollectionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CollectionView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

}
