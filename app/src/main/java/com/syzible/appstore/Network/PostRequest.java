package com.syzible.appstore.Network;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ed on 16/12/2016
 */

abstract class PostRequest extends Request {
    PostRequest(Networking networking, String url) {
        super(networking, url, "POST");
    }
}