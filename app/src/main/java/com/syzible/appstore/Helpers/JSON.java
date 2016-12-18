package com.syzible.appstore.Helpers;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ed on 18/12/2016
 */

public class JSON {
    public static String getKeyValue(JSONObject object, String key) {
        assert object != null;
        try {
            if(object.has(key))
                return object.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
