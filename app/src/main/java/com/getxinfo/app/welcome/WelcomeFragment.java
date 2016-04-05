package com.getxinfo.app.welcome;

import android.app.Fragment;
import android.widget.Button;

/**
 * Created by pgy on 2016/4/5.
 */
public abstract class WelcomeFragment extends Fragment{

    interface WelcomeFragmentContainer {

        public Button getPositiveButton();

        public void setPositiveButtonEnabled(Boolean enabled);

        public Button getNegativeButton();

        public void setNegativeButtonEnabled(Boolean enabled);

    }

}
