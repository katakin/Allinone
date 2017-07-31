package com.example.allinone.network;

/**
 * Created by katakin on 21/07/17.
 */

public enum ApiAlias {

    TICKERS("/v1/ticker/"),
    TICKER("/v1/ticker/{id}/"),
    GLOBAL("/v1/global/");

    private String requestUrl;

    ApiAlias(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestUrl() {
        return requestUrl;
    }
}