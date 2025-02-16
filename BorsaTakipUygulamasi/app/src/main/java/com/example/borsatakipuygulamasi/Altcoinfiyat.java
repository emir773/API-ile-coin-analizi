package com.example.borsatakipuygulamasi;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Altcoinfiyat extends AppCompatActivity {

    private EditText etCoinName; // Kullanıcının coin adını gireceği EditText
    private Button btnFetchPrice; // Coin fiyatını çekmek için buton
    private TextView tvCoinPrice; // Coin fiyatını gösterecek TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altcoinfiyat);

        // XML bileşenlerini bağlama
        etCoinName = findViewById(R.id.etCoinName);
        btnFetchPrice = findViewById(R.id.btnFetchPrice);
        tvCoinPrice = findViewById(R.id.tvCoinPrice);

        // Buton tıklama olayını tanımlıyoruz
        btnFetchPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String coinName = etCoinName.getText().toString().trim();

                // Kullanıcı boş coin adı girmemişse işlem yapılacak
                if (!coinName.isEmpty()) {
                    fetchCoinPrice(coinName);
                } else {
                    Toast.makeText(Altcoinfiyat.this, "Lütfen bir coin adı girin!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Coin fiyatını API'den çekme fonksiyonu
    private void fetchCoinPrice(String coinName) {
        // Coin ID'yi almak için fonksiyon çağrılır
        String coinId = getCoinIdFromName(coinName);

        if (coinId != null) {
            // Retrofit API servisini alıyoruz
            CoinCapApiService apiService = RetrofitClient.getClient().create(CoinCapApiService.class);

            // API çağrısını yapıyoruz
            Call<CoinResponse> call = apiService.getCoinPrice(coinId);  // coinId parametresini URL'ye yerleştiriyoruz
            call.enqueue(new Callback<CoinResponse>() {
                @Override
                public void onResponse(Call<CoinResponse> call, Response<CoinResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        // API başarılı bir şekilde yanıt verdiyse, fiyatı alıp TextView'e yazdırıyoruz
                        String price = response.body().getData().getPriceUsd();
                        tvCoinPrice.setText(coinName.toUpperCase() + " Fiyatı: $" + price);
                    } else {
                        // Eğer API yanıtı başarısızsa, hata mesajını gösteriyoruz
                        Log.e("API_ERROR", "Yanıt başarısız: " + response.message());
                        Toast.makeText(Altcoinfiyat.this, "Fiyat bilgisi alınamadı!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<CoinResponse> call, Throwable t) {
                    // API çağrısı başarısız olduğunda, hata mesajını gösteriyoruz
                    Log.e("API_ERROR", "API çağrısı başarısız: " + t.getMessage());
                    Toast.makeText(Altcoinfiyat.this, "API çağrısı başarısız oldu!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(Altcoinfiyat.this, "Geçersiz coin adı!", Toast.LENGTH_SHORT).show();
        }
    }

    // Coin adını coin ID'sine dönüştürmek için yardımcı fonksiyon
    private String getCoinIdFromName(String coinName) {
        switch (coinName.toLowerCase()) {
            case "avalanche":
                return "avalanche";  // AVAX için Coin ID
            case "bitcoin":
                return "bitcoin";  // BTC için Coin ID
            case "ethereum":
                return "ethereum";  // ETH için Coin ID
            case "dogecoin":
                return "dogecoin";  // DOGE için Coin ID
            case "litecoin":
                return "litecoin";  // LTC için Coin ID
            case "xrp":
                return "xrp";  // LTC için Coin ID
            case "solana":
                return "solana";  // LTC için Coin ID
            case "cardona":
                return "cardona";  // LTC için Coin ID
            case "tron":
                return "tron";  // LTC için Coin ID
            case "tether":
                return "tether";  // LTC için Coin ID
            case "chainlink":
                return "chainlink";  // LTC için Coin ID
            // Burada diğer coin ID'lerini de ekleyebilirsiniz
            default:
                return null;  // Bilinmeyen coin adı için null döndür
        }
    } }


