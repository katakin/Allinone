package com.example.allinone.model;

/**
 * Created by katakin on 21/07/17.
 */

public class GlobalData {
    private double total_market_cap_usd;
    private double total_24h_volume_usd;
    private float bitcoin_percentage_of_market_cap;
    private int active_currencies;
    private int active_assets;
    private int active_markets;

    public double getTotal_market_cap_usd() {
        return total_market_cap_usd;
    }

    public double getTotal_24h_volume_usd() {
        return total_24h_volume_usd;
    }

    public float getBitcoin_percentage_of_market_cap() {
        return bitcoin_percentage_of_market_cap;
    }

    public int getActive_currencies() {
        return active_currencies;
    }

    public int getActive_assets() {
        return active_assets;
    }

    public int getActive_markets() {
        return active_markets;
    }
}
