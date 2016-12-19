package com.syzible.appstore.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.syzible.appstore.Objects.App;
import com.syzible.appstore.R;

/**
 * Created by ed on 18/12/2016
 */

public class AppAdapter extends CardAdapter<App> {
    public AppAdapter(OnViewHolderClick onViewHolderClick) {
        super(onViewHolderClick);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        return LayoutInflater.from(context).inflate(R.layout.app_card, viewGroup, false);
    }

    @Override
    protected void bindView(App app, ViewHolder viewHolder) {
        assert app != null;

        // details
        TextView title = (TextView) viewHolder.getView(R.id.app_title);
        title.setText(app.getTitle());
    }
}
