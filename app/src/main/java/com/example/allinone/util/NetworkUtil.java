package com.example.allinone.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.allinone.R;
import com.google.gson.JsonSyntaxException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;

/**
 * Created by katakin on 22/07/17.
 */

public class NetworkUtil {

    public static boolean isHttpStatusCode(Throwable throwable, int statusCode) {
        return throwable instanceof HttpException && ((HttpException) throwable).code() == statusCode;
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isAvailable();
    }

    public static String getErrorMessage(Context context, Throwable mThrowable) {
        String message = null;
        if (mThrowable instanceof UnknownHostException) {
            message = context.getResources().getString(R.string.network_error);
        } else if (mThrowable instanceof JsonSyntaxException) {
            message = context.getResources().getString(R.string.data_parse_error);
        } else if (mThrowable instanceof SocketTimeoutException) {
            message = context.getResources().getString(R.string.network_timeout);
        } else if (mThrowable instanceof ConnectException) {
            message = context.getResources().getString(R.string.network_error);
        } else if (mThrowable instanceof ErrorException || mThrowable instanceof HttpException) {
            message = Errors.errorMessage(mThrowable);
        }
        return message;
    }
}
