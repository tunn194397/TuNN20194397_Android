package com.example.bai1_mycurrency;

public class CurrencyEntity {
    private String name;
    private String symbol;
    private String country;
    private int compareWithOneVND;

    public CurrencyEntity(String name, String symbol, String country, int compareWithOneVND) {
        this.name = name;
        this.symbol = symbol;
        this.country = country;
        this.compareWithOneVND = compareWithOneVND;
    }
    public CurrencyEntity() {

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getCompareWithOneVND() {
        return compareWithOneVND;
    }

    public void setCompareWithOneVND(int compareWithOneVND) {
        this.compareWithOneVND = compareWithOneVND;
    }
}