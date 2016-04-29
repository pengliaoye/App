package com.getxinfo.app.explore;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.getxinfo.app.R;

/**
 * Created by pgy on 2016/4/22.
 */
public class ExploreIOFragment extends Fragment {

    /**
     * Empty view displayed when {@code mCollectionView} is empty.
     */
    private View mEmptyView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.explore_io_frag, container, false);
        mEmptyView = root.findViewById(android.R.id.empty);
        getActivity().overridePendingTransition(0, 0);

        return root;
    }
}
