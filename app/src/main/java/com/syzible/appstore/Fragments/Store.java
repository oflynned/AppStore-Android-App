package com.syzible.appstore.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.syzible.appstore.Helpers.Constants;
import com.syzible.appstore.Helpers.JSON;
import com.syzible.appstore.Network.NetworkCallback;
import com.syzible.appstore.Network.ReqJSON;
import com.syzible.appstore.R;

import org.json.JSONObject;

/**
 * Created by ed on 16/12/2016
 */

public class Store extends Fragment implements NetworkCallback<JSONObject> {
    TextView title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_main, container, false);
        title = (TextView) view.findViewById(R.id.content_main_title);
        new ReqJSON(this, Constants.JSON_ENDPOINT).execute();
        return view;
    }

    @Override
    public void onProgress(int progress) {

    }

    @Override
    public void onSuccess(JSONObject object) {
        title.setText(JSON.getKeyValue(object, "time"));
    }

    @Override
    public void onFailure() {
        Toast.makeText(getContext(), "Internet call failed", Toast.LENGTH_SHORT).show();
    }
}
