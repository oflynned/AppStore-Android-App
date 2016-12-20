package com.syzible.appstore.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.syzible.appstore.Helpers.Constants;
import com.syzible.appstore.Helpers.FragmentHelper;
import com.syzible.appstore.Network.NetworkCallback;
import com.syzible.appstore.Network.ReqJSONArray;
import com.syzible.appstore.Objects.App;
import com.syzible.appstore.Objects.CardHelper;
import com.syzible.appstore.R;
import com.syzible.appstore.UI.AppAdapter;
import com.syzible.appstore.UI.OnViewHolderClick;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by ed on 16/12/2016
 */

public class Store extends Fragment implements OnViewHolderClick, SwipeRefreshLayout.OnRefreshListener {
    private ArrayList<App> apps = new ArrayList<>();
    private RecyclerView recyclerView;
    private AppAdapter adapter = new AppAdapter(this);

    private SwipeRefreshLayout refreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.content_main, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.card_holder);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_listings);
        refreshLayout.setOnRefreshListener(this);

        downloadData();

        return view;
    }

    @Override
    public void onClick(View view, int position) {
        AppListing appListing = new AppListing();
        appListing.setApp(apps.get(position));
        FragmentHelper.setFragment(getFragmentManager(), appListing);
    }

    @Override
    public void onRefresh() {
        downloadData();
        refreshLayout.setRefreshing(false);
    }

    private void downloadData() {
        NetworkCallback<JSONArray> jsonCallback = new NetworkCallback<JSONArray>() {
            @Override
            public void onSuccess(final JSONArray jsonObject) {
                CardHelper.populateAppCards(apps, jsonObject);
                CardHelper.retrieveAppCardIcons(apps, adapter, recyclerView);
                adapter.setList(apps);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure() {
                Toast.makeText(getContext(), "No internet connection", Toast.LENGTH_SHORT).show();
            }
        };
        new ReqJSONArray(jsonCallback, Constants.APP_LISTINGS).execute();
    }
}
