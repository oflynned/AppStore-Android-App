package com.syzible.appstore.Network;

/**
 * Created by ed on 16/12/2016
 */

abstract class PostRequest<T> extends Request<T> {
    PostRequest(NetworkCallback<T> networkCallback, String url) {
        super(networkCallback, url, "POST");
    }
}