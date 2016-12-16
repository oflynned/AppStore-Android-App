package com.syzible.appstore.Network;

/**
 * Created by ed on 16/12/2016
 */

public class Update extends PostRequest {

    public Update(Networking networking, String url) {
        super(networking, url);
    }

    @Override
    public Object download() {
        return null;
    }

    @Override
    public Object upload() {
        return null;
    }
}
