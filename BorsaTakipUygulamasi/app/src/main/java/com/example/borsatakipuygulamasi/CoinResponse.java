package com.example.borsatakipuygulamasi;

import com.google.gson.annotations.SerializedName;

public class CoinResponse {
    @SerializedName("data")
    private CoinData data;

    public CoinData getData() {
        return data;
    }

    public static class CoinData {
        @SerializedName("priceUsd")
        private String priceUsd;

        public String getPriceUsd() {
            return priceUsd;
        }
    }
}
