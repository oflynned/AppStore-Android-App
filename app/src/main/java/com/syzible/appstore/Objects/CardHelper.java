package com.syzible.appstore.Objects;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

/**
 * Created by ed on 18/12/2016
 */

public class CardHelper {
    public static void populateAppCards(List<App> list, JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            try {
                list.add(new App(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void populateDeveloperCards(List<Developer> list, JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            try {
                list.add(new Developer(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
