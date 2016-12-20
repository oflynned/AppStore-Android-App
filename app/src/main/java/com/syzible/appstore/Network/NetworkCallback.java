package com.syzible.appstore.Network;

/**
 * Created by ed on 16/12/2016
 */

public interface NetworkCallback<T> {
    void onSuccess(T object);
    void onFailure();
}
