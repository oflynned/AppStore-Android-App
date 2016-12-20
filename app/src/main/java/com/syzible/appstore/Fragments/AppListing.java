package com.syzible.appstore.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.syzible.appstore.Helpers.System;
import com.syzible.appstore.Network.NetworkCallback;
import com.syzible.appstore.Network.ReqFile;
import com.syzible.appstore.Objects.App;
import com.syzible.appstore.R;

import java.io.File;

/**
 * Created by ed on 16/12/2016
 */

public class AppListing extends Fragment implements NetworkCallback<File> {
    private App app;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.app_listing, container, false);

        ImageView appIcon = (ImageView) view.findViewById(R.id.app_listing_icon);
        appIcon.setImageBitmap(app.getIcon());

        TextView title = (TextView) view.findViewById(R.id.app_listing_title);
        title.setText(app.getTitle());

        TextView developer = (TextView) view.findViewById(R.id.app_listing_developer);
        developer.setText(app.getPublisherName());

        Button installButton = (Button) view.findViewById(R.id.app_listing_action);
        installButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ReqFile(AppListing.this, app, getContext()).execute();
            }
        });

        return view;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    @Override
    public void onSuccess(File object) {
        Toast.makeText(getContext(), "File grabbed", Toast.LENGTH_SHORT).show();
        System.installApk(app, getContext());
    }

    @Override
    public void onFailure() {
        Toast.makeText(getContext(), "Install failed?", Toast.LENGTH_SHORT).show();
    }
}
