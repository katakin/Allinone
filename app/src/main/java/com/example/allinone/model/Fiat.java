package com.example.allinone.model;

/**
 * Created by katakin on 21/07/17.
 */

public enum Fiat {
    AUD("AUD"),
    BRL("BRL"),
    CAD("CAD"),
    CHF("CHF"),
    CNY("CNY"),
    EUR("EUR"),
    GBR("GBP"),
    HKD("HKD"),
    IDR("IDR"),
    INR("INR"),
    JPY("JPY"),
    KRW("KRW"),
    MXN("MXN"),
    RUB("RUB"),
    USD("USD");

    private String text;

    Fiat(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
