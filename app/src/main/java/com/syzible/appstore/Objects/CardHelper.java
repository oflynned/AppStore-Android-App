package com.syzible.appstore.Objects;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;

import com.syzible.appstore.Network.NetworkCallback;
import com.syzible.appstore.Network.ReqImage;
import com.syzible.appstore.UI.AppAdapter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by ed on 18/12/2016
 */

public class CardHelper {
    public static void populateAppCards(ArrayList<App> apps, JSONArray array) {
        apps.clear();
        for (int i = 0; i < array.length(); i++) {
            try {
                apps.add(new App(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void retrieveAppCardIcons(final ArrayList<App> apps, final AppAdapter adapter,
                                            final RecyclerView recyclerView) {
        for (final App app : apps) {
            new ReqImage(new NetworkCallback<Bitmap>() {
                @Override
                public void onSuccess(Bitmap object) {
                    app.setIcon(object);
                    adapter.setList(apps);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure() {

                }
            }, app.getIconResource()).execute();
        }
    }
}
