package com.example.allinone.network;

import android.content.Context;

import com.example.allinone.model.CurrencyData;
import com.example.allinone.model.Fiat;
import com.example.allinone.model.GlobalData;
import com.example.allinone.util.NetworkUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by katakin on 21/07/17.
 */

public class Methods {

    private Context context;
    private Api api;
    private Gson gson;

    public Methods(Context context, Api api, Gson gson) {
        this.context = context;
        this.api = api;
        this.gson = gson;
    }

    public void returnTickers(ResponseCallback<List<CurrencyData>> callback, Fiat fiat, Integer limit) {
        String url = ApiAlias.TICKERS.getRequestUrl();
        LinkedHashMap<String, String> params = new LinkedHashMap<>();
        if (fiat != null) params.put("convert", fiat.getText());
        if (limit != null && limit >= 1) params.put("limit", String.valueOf(limit));

        makeObservable(url, params)
                .subscribe(responseBody -> {
                    try {
                        Type type = new TypeToken<ArrayList<CurrencyData>>() {
                        }.getType();
                        ArrayList<CurrencyData> list = gson.fromJson(responseBody.string(), type);
                        callback.onSuccess(list);
                    } catch (Exception | Error e) {
                        callback.onFailure(e.getMessage());
                    }
                }, throwable -> callback.onFailure(NetworkUtil.getErrorMessage(context, throwable)));
    }

    public void returnTicker(ResponseCallback<ArrayList<CurrencyData>> callback, String currencyName, Fiat fiat) {
        String url = ApiAlias.TICKER.getRequestUrl().replace("{id}", currencyName);
        LinkedHashMap<String, String> params = new LinkedHashMap<>();
        if (fiat != null) params.put("convert", fiat.getText());

        makeObservable(url, params)
                .subscribe(responseBody -> {
                    try {
                        Type type = new TypeToken<ArrayList<CurrencyData>>() {
                        }.getType();
                        ArrayList<CurrencyData> list = gson.fromJson(responseBody.string(), type);
                        callback.onSuccess(list);
                    } catch (Exception | Error e) {
                        callback.onFailure(e.getMessage());
                    }
                }, throwable -> callback.onFailure(NetworkUtil.getErrorMessage(context, throwable)));
    }

    public void returnGlobal(ResponseCallback<GlobalData> callback, Fiat fiat) {
        String url = ApiAlias.GLOBAL.getRequestUrl();
        LinkedHashMap<String, String> params = new LinkedHashMap<>();
        if (fiat != null) params.put("convert", fiat.getText());

        makeObservable(url, params)
                .subscribe(responseBody -> {
                    try {
                        Type type = new TypeToken<GlobalData>() {
                        }.getType();
                        GlobalData list = gson.fromJson(responseBody.string(), type);
                        callback.onSuccess(list);
                    } catch (Exception | Error e) {
                        callback.onFailure(e.getMessage());
                    }
                }, throwable -> callback.onFailure(NetworkUtil.getErrorMessage(context, throwable)));
    }

    private Observable<ResponseBody> makeObservable(String url, LinkedHashMap<String, String> params) {
        return api.getRequest(url, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io());
    }
}
