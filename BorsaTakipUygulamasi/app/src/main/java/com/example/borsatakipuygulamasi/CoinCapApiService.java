package com.example.borsatakipuygulamasi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import com.example.borsatakipuygulamasi.CoinResponse;


// Coin fiyatlarını çekmek için API servisi
public interface CoinCapApiService {

    // API URL'ini belirtiyoruz. Coin fiyatlarını çekmek için kullanılacak endpoint.
    @GET("v2/assets/{coinId}")
    Call<CoinResponse> getCoinPrice(@Path("coinId") String coinId);  // coinId parametresini URL'ye yerleştiriyoruz
}
