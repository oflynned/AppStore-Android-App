package com.syzible.appstore.Network;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ed on 16/12/2016
 */

abstract class Request <T> extends AsyncTask<Object, Integer, Object> {
    private Networking networking;
    private String url, verb;
    private HttpURLConnection connection;

    Request(Networking networking, String url, String verb) {
        this.networking = networking;
        this.url = url;
        this.verb = verb;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        networking.onStart();
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        super.onProgressUpdate(progress);
        networking.onProgress(progress[0]);
    }

    @Override
    protected Object doInBackground(Object... objects) {
        try {
            connection = (HttpURLConnection) new URL(getUrl()).openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod(verb);
            connection.setRequestProperty("Content-length", "0");
            connection.setUseCaches(false);
            connection.setAllowUserInteraction(false);
            connection.connect();

            if(getVerb().equals("GET")) download();
            else upload();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        assert networking != null;
        if (o != null) networking.onSuccess(o);
        else networking.onFailure();
    }

    public String getUrl() {
        return url;
    }

    HttpURLConnection getConnection() {
        return connection;
    }

    public String getVerb() {
        return verb;
    }

    public abstract T download();
    public abstract T upload();
}
