package com.syzible.appstore.Network;

/**
 * Created by ed on 16/12/2016
 */

public interface Networking {
    void onStart();
    void onProgress(int progress);
    void onSuccess(Object object);
    void onFailure();
}
