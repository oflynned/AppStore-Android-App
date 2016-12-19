package com.syzible.appstore.Helpers;

/**
 * Created by ed on 16/12/2016
 */

public abstract class Constants {
    private static final String REMOTE_URL = "http://www.syzible.com";
    private static final String LOCAL_URL = "http://10.0.2.2:3000";
    private static final String ENDPOINT = LOCAL_URL + "/appstore";

    //subdirectories
    public static final String APP_LISTINGS = ENDPOINT + "/get-listings";
    public static final String SAMPLE_ICON = LOCAL_URL + "/images/tearma_logo.png";
}
