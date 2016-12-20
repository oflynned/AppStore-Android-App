package com.syzible.appstore.Objects;

import android.graphics.Bitmap;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ed on 16/12/2016
 */

public class App {
    private String id, publisherId, publisherName, title, appPackage, description, resourceId;
    private String rating;
    private String category;
    private Bitmap icon;
    private String iconUrl, apkUrl;

    public App(JSONObject object) {
        try {
            this.title = object.getString("title");
            this.publisherName = object.getString("publisher_name");
            this.category = object.getString("category");
            this.rating = object.getString("rating");
            this.iconUrl = object.getString("icon_url");
            this.apkUrl = object.getString("apk_url");
            this.appPackage = object.getString("app_package");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public String getPublisherName() {
        return publisherName;
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

    public String getRating() {
        return rating;
    }

    public String getCategory() {
        return category;
    }

    public String getIconResource() {
        return iconUrl;
    }

    public String getApkUrl() {
        return apkUrl;
    }
}
