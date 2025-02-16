package com.example.borsatakipuygulamasi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AltcoinActivity extends AppCompatActivity {

    private EditText etCoinName;        // Kullanıcıdan coin adı almak için
    private Button btnAddCoin;         // Coin ekleme butonu
    private Button btnDeleteCoin;      // Coin silme butonu
    private TextView tvAltcoinListesi; // Sabit listeyi göstermek için
    private EditText etBasketName;     // Sepet ismini almak için

    private SQLiteHelper sqLiteHelper; // SQLite veritabanı yardımıcısı

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altcoin);

        // XML bileşenlerini bağlama
        etCoinName = findViewById(R.id.etCoinName);
        btnAddCoin = findViewById(R.id.btnAddCoin);
        btnDeleteCoin = findViewById(R.id.btnDeleteCoin); // Coin silme butonu
        tvAltcoinListesi = findViewById(R.id.tvAltcoinListesi);
        etBasketName = findViewById(R.id.etBasketName);

        sqLiteHelper = new SQLiteHelper(this); // SQLiteHelper başlat

        // Coin ekleme butonu tıklama olayı
        btnAddCoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String coinName = etCoinName.getText().toString().trim();
                String basketName = etBasketName.getText().toString().trim();

                if (!coinName.isEmpty() && !basketName.isEmpty()) {
                    boolean isInserted = sqLiteHelper.insertCoin(coinName, basketName);
                    if (isInserted) {
                        Toast.makeText(AltcoinActivity.this, "Coin eklendi", Toast.LENGTH_SHORT).show();
                        updateCoinList();
                    } else {
                        Toast.makeText(AltcoinActivity.this, "Coin ekleme başarısız!", Toast.LENGTH_SHORT).show();
                    }

                    // Metin kutularını temizle
                    etCoinName.setText("");
                    etBasketName.setText("");
                } else {
                    Toast.makeText(AltcoinActivity.this, "Coin adı ve sepet adı gerekli!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Coin silme butonu tıklama olayı
        btnDeleteCoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String coinName = etCoinName.getText().toString().trim();
                String basketName = etBasketName.getText().toString().trim();

                if (!coinName.isEmpty() && !basketName.isEmpty()) {
                    boolean isDeleted = sqLiteHelper.deleteCoin(coinName, basketName);
                    if (isDeleted) {
                        Toast.makeText(AltcoinActivity.this, "Coin silindi", Toast.LENGTH_SHORT).show();
                        updateCoinList();
                    } else {
                        Toast.makeText(AltcoinActivity.this, "Coin silme başarısız! Bu coin bulunamadı.", Toast.LENGTH_SHORT).show();
                    }

                    // Metin kutularını temizle
                    etCoinName.setText("");
                    etBasketName.setText("");
                } else {
                    Toast.makeText(AltcoinActivity.this, "Coin adı ve sepet adı gerekli!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Veritabanındaki coinleri yükle ve listeyi güncelle
        updateCoinList();
    }

    // Listeyi güncelleyen fonksiyon
    private void updateCoinList() {
        StringBuilder listText = new StringBuilder();

        // Sepet ismine göre coin'leri gruplayarak al
        Map<String, ArrayList<String>> basketMap = new HashMap<>();

        // Tüm coinleri veritabanından al
        Cursor cursor = sqLiteHelper.getAllCoins();

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String coinName = cursor.getString(cursor.getColumnIndex("coin_name"));
                String basketName = cursor.getString(cursor.getColumnIndex("basket_name"));

                // Sepete göre coin'leri grupla
                if (!basketMap.containsKey(basketName)) {
                    basketMap.put(basketName, new ArrayList<String>());
                }
                basketMap.get(basketName).add(coinName);
            } while (cursor.moveToNext());
            cursor.close();
        }

        // Her sepete ait coin'leri listele
        for (Map.Entry<String, ArrayList<String>> entry : basketMap.entrySet()) {
            String basketName = entry.getKey();
            ArrayList<String> coins = entry.getValue();

            listText.append("--- Sepet: ").append(basketName).append(" ---\n");
            for (String coin : coins) {
                listText.append(coin).append("\n");
            }
            listText.append("\n");
        }

        // Güncellenmiş listeyi ekranda göster
        tvAltcoinListesi.setText(listText.toString());
    }
}
