package com.syzible.appstore.Network;

/**
 * Created by ed on 16/12/2016
 */

public class ReqFile extends GetRequest {
    public ReqFile(Networking networking, String url) {
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
