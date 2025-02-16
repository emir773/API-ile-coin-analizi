/*package com.example.borsatakipuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // XML'deki bileşenleri Java koduna bağlama
        Button btnBitcoin = findViewById(R.id.btnBitcoin);
        Button btnAltcoin = findViewById(R.id.button);

        // Bitcoin Takip Listesi butonu tıklama olayı
        btnBitcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // BitcoinActivity'e geçiş
                Intent intent = new Intent(MainActivity.this, BitcoinActivity.class);
                startActivity(intent);
            }
        });

        // Favori Altcoin Sepetim butonu tıklama olayı
        btnAltcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // AltcoinActivity'e geçiş
                Intent intent = new Intent(MainActivity.this, AltcoinActivity.class);
                startActivity(intent);
            }
        });
    }
}
 */
package com.example.borsatakipuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // XML'deki bileşenleri Java koduna bağlama
        Button btnBitcoin = findViewById(R.id.btnBitcoin);
        Button btnAltcoin = findViewById(R.id.button);
        Button btnAltcoinFiyat = findViewById(R.id.btnAltcoinFiyat); // Yeni buton

        // Bitcoin Takip Listesi butonu tıklama olayı
        btnBitcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // BitcoinActivity'e geçiş
                Intent intent = new Intent(MainActivity.this, BitcoinActivity.class);
                startActivity(intent);
            }
        });

        // Favori Altcoin Sepetim butonu tıklama olayı
        btnAltcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // AltcoinActivity'e geçiş
                Intent intent = new Intent(MainActivity.this, AltcoinActivity.class);
                startActivity(intent);
            }
        });

        // Altcoin Fiyat butonu tıklama olayı
        btnAltcoinFiyat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Altcoinfiyat Activity'e geçiş
                Intent intent = new Intent(MainActivity.this, Altcoinfiyat.class);
                startActivity(intent);
            }
        });
    }
}
