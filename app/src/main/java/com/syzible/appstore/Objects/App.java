package com.syzible.appstore.Objects;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ed on 16/12/2016
 */

public class App {
    private String id, publisherId, title, appPackage, description, resourceId;
    private float rating;
    private Category category;

    public App(JSONObject object) {
        try {
            this.title = object.getString("title");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return id;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public String getTitle() {
        return title;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public String getDescription() {
        return description;
    }

    public String getResourceId() {
        return resourceId;
    }

    public float getRating() {
        return rating;
    }

    public Category getCategory() {
        return category;
    }
}
