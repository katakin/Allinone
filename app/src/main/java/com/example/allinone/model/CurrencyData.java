package com.example.allinone.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by katakin on 21/07/17.
 */

public class CurrencyData {
    private String id;
    private String name;
    private String sybmol;
    private int rank;
    @SerializedName("price_usd")
    private double priceUsd;
    @SerializedName("price_btc")
    private double priceBtc;
    @SerializedName("24h_volume_usd")
    private double dailyUsd;
    @SerializedName("market_cap_usd")
    private double marketCapUsd;
    @SerializedName("available_supply")
    private double availableSupply;
    @SerializedName("total_supply")
    private double totalSupply;
    @SerializedName("percent_change_1h")
    private float percentChange1h;
    @SerializedName("percent_change_24h")
    private float percentChange24h;
    @SerializedName("percent_change_7d")
    private float percentChange7d;
    @SerializedName("last_updated")
    private long lastUpdated;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSybmol() {
        return sybmol;
    }

    public int getRank() {
        return rank;
    }

    public double getPriceUsd() {
        return priceUsd;
    }

    public double getPriceBtc() {
        return priceBtc;
    }

    public double getDailyUsd() {
        return dailyUsd;
    }

    public double getMarketCapUsd() {
        return marketCapUsd;
    }

    public double getAvailableSupply() {
        return availableSupply;
    }

    public double getTotalSupply() {
        return totalSupply;
    }

    public float getPercentChange1h() {
        return percentChange1h;
    }

    public float getPercentChange24h() {
        return percentChange24h;
    }

    public float getPercentChange7d() {
        return percentChange7d;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }
}
