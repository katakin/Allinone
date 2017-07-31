package com.example.allinone.network;

/**
 * Created by katakin on 21/07/17.
 */

public interface ResponseCallback<T> {
    void onSuccess(T object);

    void onFailure (String error);
}