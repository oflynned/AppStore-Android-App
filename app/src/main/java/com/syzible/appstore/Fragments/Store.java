package com.syzible.appstore.Fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.syzible.appstore.Helpers.Constants;
import com.syzible.appstore.Helpers.FragmentHelper;
import com.syzible.appstore.Network.NetworkCallback;
import com.syzible.appstore.Network.ReqImage;
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

public class Store extends Fragment implements OnViewHolderClick {
    private ArrayList<App> apps = new ArrayList<>();
    private RecyclerView recyclerView;
    private AppAdapter adapter = new AppAdapter(this);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_main, container, false);
        Button refreshButton = (Button) view.findViewById(R.id.force_refresh);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentHelper.setFragment(getFragmentManager(), new Store());
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.card_holder);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        NetworkCallback<JSONArray> jsonCallback = new NetworkCallback<JSONArray>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onProgress(int progress) {

            }

            @Override
            public void onSuccess(final JSONArray jsonObject) {
                NetworkCallback<Bitmap> imageCallback = new NetworkCallback<Bitmap>() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onProgress(int progress) {

                    }

                    @Override
                    public void onSuccess(Bitmap bitmapObject) {
                        CardHelper.populateAppCards(apps, jsonObject);

                        for(App app : apps)
                            app.setIcon(bitmapObject);

                        adapter.setList(apps);
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure() {
                        Toast.makeText(getContext(), "Bitmap failed", Toast.LENGTH_SHORT).show();
                    }
                };

                new ReqImage(imageCallback, Constants.SAMPLE_ICON).execute();
            }

            @Override
            public void onFailure() {
                Toast.makeText(getContext(), "Check your internet connection", Toast.LENGTH_SHORT).show();
            }
        };
        new ReqJSONArray(jsonCallback, Constants.APP_LISTINGS).execute();

        return view;
    }

    @Override
    public void onClick(View view, int position) {
        Toast.makeText(view.getContext(), position + " pressed", Toast.LENGTH_SHORT).show();
    }
}
