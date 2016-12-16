package com.syzible.appstore.Network;

/**
 * Created by ed on 16/12/2016
 */

abstract class GetRequest extends Request {
    GetRequest(Networking networking, String url) {
        super(networking, url, "GET");
    }
}