package com.syzible.appstore.Objects;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ed on 18/12/2016
 */

public class Developer {
    private String organisation;

    public Developer(JSONObject object) {
        try {
            this.organisation = object.getString("organisation");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getOrganisation() {
        return organisation;
    }
}
