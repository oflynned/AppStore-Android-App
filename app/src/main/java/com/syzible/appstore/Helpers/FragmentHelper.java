package com.syzible.appstore.Helpers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.syzible.appstore.R;

/**
 * Created by ed on 16/12/2016
 */

public class FragmentHelper {
    public static void setFragment(FragmentManager fragmentManager, Fragment fragment) {
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack(null).commit();
    }
}
