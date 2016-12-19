package com.syzible.appstore.UI;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.syzible.appstore.Objects.Developer;

/**
 * Created by ed on 18/12/2016
 */

public class DeveloperAdapter extends CardAdapter<Developer> {
    public DeveloperAdapter(OnViewHolderClick onViewHolderClick) {
        super(onViewHolderClick);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        return null;
    }

    @Override
    protected void bindView(Developer item, ViewHolder viewHolder) {

    }
}
