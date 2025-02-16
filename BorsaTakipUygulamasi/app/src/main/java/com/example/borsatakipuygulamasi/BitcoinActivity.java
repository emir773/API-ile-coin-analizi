/*

package com.example.borsatakipuygulamasi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast; // Toast kütüphanesini ekleyin
import androidx.appcompat.app.AppCompatActivity;

public class BitcoinActivity extends AppCompatActivity {

    private EditText etBitcoinAdi, etMaliyet, etStopNoktasi, etNot;
    private TextView tvBitcoinListesi;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "BitcoinTakipPrefs";
    private static final String LIST_KEY = "BitcoinListesi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitcoin); // Yeni XML layout'u

        etBitcoinAdi = findViewById(R.id.etBitcoinAdi);
        etMaliyet = findViewById(R.id.etMaliyet);
        etStopNoktasi = findViewById(R.id.etStopNoktasi);
        etNot = findViewById(R.id.etNot);
        tvBitcoinListesi = findViewById(R.id.tvBitcoinListesi);
        Button btnEkle = findViewById(R.id.btnEkle);
        Button btnListeyiSil = findViewById(R.id.button2); // Listeyi Sil butonu

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        // Kaydedilen verileri yükle
        loadSavedData();

        // Ekle butonuna tıklanma olayını tanımla
        btnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bitcoinAdi = etBitcoinAdi.getText().toString();
                String maliyet = etMaliyet.getText().toString();
                String stopNoktasi = etStopNoktasi.getText().toString();
                String not = etNot.getText().toString();

                if (bitcoinAdi.isEmpty() || maliyet.isEmpty() || stopNoktasi.isEmpty() || not.isEmpty()) {
                    tvBitcoinListesi.setText("Lütfen tüm alanları doldurun.");
                    return;
                }

                String yeniBitcoin = "Bitcoin: " + bitcoinAdi + "\n"
                        + "Maliyet: " + maliyet + "\n"
                        + "Stop Noktası: " + stopNoktasi + "\n"
                        + "Beklentiler: " + not + "\n\n";

                String mevcutListe = tvBitcoinListesi.getText().toString();
                String guncelListe = mevcutListe + yeniBitcoin;

                tvBitcoinListesi.setText(guncelListe);

                saveData(guncelListe);

                // Formu sıfırla
                etBitcoinAdi.setText("");
                etMaliyet.setText("");
                etStopNoktasi.setText("");
                etNot.setText("");
            }
        });

        // Listeyi Sil butonuna tıklanma olayını tanımla
        btnListeyiSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Takip listesini temizle
                tvBitcoinListesi.setText("");

                // SharedPreferences'den veriyi sil
                clearData();
            }
        });

        // Geri düğmesini etkinleştir
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    // Veriyi SharedPreferences'e kaydetme
    private void saveData(String data) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LIST_KEY, data);
        editor.apply();
    }

    // Kaydedilen veriyi yükleme
    private void loadSavedData() {
        String savedList = sharedPreferences.getString(LIST_KEY, ""); // Varsayılan boş değer
        tvBitcoinListesi.setText(savedList);
    }

    // SharedPreferences'teki veriyi silme
    private void clearData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(LIST_KEY); // LIST_KEY anahtarını kullanarak veriyi sil
        editor.apply();
    }


    // Geri düğmesine basıldığında aktiviteyi kapat
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}

*/
/*
package com.example.borsatakipuygulamasi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast; // Toast kütüphanesini ekleyin
import androidx.appcompat.app.AppCompatActivity;

public class BitcoinActivity extends AppCompatActivity {

    private EditText etBitcoinAdi, etMaliyet, etStopNoktasi, etNot;
    private TextView tvBitcoinListesi;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "BitcoinTakipPrefs";
    private static final String LIST_KEY = "BitcoinListesi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitcoin); // Yeni XML layout'u

        // Layout elemanlarını tanımla
        etBitcoinAdi = findViewById(R.id.etBitcoinAdi);
        etMaliyet = findViewById(R.id.etMaliyet);
        etStopNoktasi = findViewById(R.id.etStopNoktasi);
        etNot = findViewById(R.id.etNot);
        tvBitcoinListesi = findViewById(R.id.tvBitcoinListesi);
        Button btnEkle = findViewById(R.id.btnEkle);
        Button btnListeyiSil = findViewById(R.id.button2); // Listeyi Sil butonu
        Button btnSorgula = findViewById(R.id.btnSorgula); // Sorgulama butonu

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        // Kaydedilen verileri yükle
        loadSavedData();

        // Ekle butonu işlevi
        btnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bitcoinAdi = etBitcoinAdi.getText().toString();
                String maliyet = etMaliyet.getText().toString();
                String stopNoktasi = etStopNoktasi.getText().toString();
                String not = etNot.getText().toString();

                if (bitcoinAdi.isEmpty() || maliyet.isEmpty() || stopNoktasi.isEmpty() || not.isEmpty()) {
                    tvBitcoinListesi.setText("Lütfen tüm alanları doldurun.");
                    return;
                }

                String yeniBitcoin = "Bitcoin: " + bitcoinAdi + "\n"
                        + "Maliyet: " + maliyet + "\n"
                        + "Stop Noktası: " + stopNoktasi + "\n"
                        + "Beklentiler: " + not + "\n\n";

                String mevcutListe = tvBitcoinListesi.getText().toString();
                String guncelListe = mevcutListe + yeniBitcoin;

                tvBitcoinListesi.setText(guncelListe);

                saveData(guncelListe);

                // Formu sıfırla
                etBitcoinAdi.setText("");
                etMaliyet.setText("");
                etStopNoktasi.setText("");
                etNot.setText("");
            }
        });

        // Listeyi Sil butonu işlevi
        btnListeyiSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvBitcoinListesi.setText("");
                clearData();
            }
        });

        // Yeni Bitcoin adını sorgulama butonu işlevi
        btnSorgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sorgulananBitcoin = etBitcoinAdi.getText().toString().trim();

                if (sorgulananBitcoin.isEmpty()) {
                    Toast.makeText(BitcoinActivity.this, "Lütfen bir Bitcoin adı girin", Toast.LENGTH_SHORT).show();
                    return;
                }

                String mevcutListe = tvBitcoinListesi.getText().toString();
                if (mevcutListe.contains("Bitcoin: " + sorgulananBitcoin)) {
                    Toast.makeText(BitcoinActivity.this, sorgulananBitcoin + " listede bulunuyor.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BitcoinActivity.this, sorgulananBitcoin + " listede bulunamadı.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Geri düğmesini etkinleştir
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    // Veriyi SharedPreferences'e kaydetme
    private void saveData(String data) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LIST_KEY, data);
        editor.apply();
    }

    // Kaydedilen veriyi yükleme
    private void loadSavedData() {
        String savedList = sharedPreferences.getString(LIST_KEY, ""); // Varsayılan boş değer
        tvBitcoinListesi.setText(savedList);
    }

    // SharedPreferences'teki veriyi silme
    private void clearData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(LIST_KEY); // LIST_KEY anahtarını kullanarak veriyi sil
        editor.apply();
    }

    // Geri düğmesine basıldığında aktiviteyi kapat
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}

*/
/*
package com.example.borsatakipuygulamasi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BitcoinActivity extends AppCompatActivity {

    private EditText etBitcoinAdi, etMaliyet, etStopNoktasi, etNot;
    private TextView tvBitcoinListesi;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "BitcoinTakipPrefs";
    private static final String LIST_KEY = "BitcoinListesi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitcoin);

        // Layout elemanlarını tanımla
        etBitcoinAdi = findViewById(R.id.etBitcoinAdi);
        etMaliyet = findViewById(R.id.etMaliyet);
        etStopNoktasi = findViewById(R.id.etStopNoktasi);
        etNot = findViewById(R.id.etNot);
        tvBitcoinListesi = findViewById(R.id.tvBitcoinListesi);
        Button btnEkle = findViewById(R.id.btnEkle);
        Button btnListeyiSil = findViewById(R.id.button2);
        Button btnSorgula = findViewById(R.id.btnSorgula);
        Button btnGuncelle = findViewById(R.id.btnGuncelle); // Güncelleme butonu

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        // Kaydedilen verileri yükle
        loadSavedData();

        // Ekle butonu işlevi
        btnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bitcoinAdi = etBitcoinAdi.getText().toString();
                String maliyet = etMaliyet.getText().toString();
                String stopNoktasi = etStopNoktasi.getText().toString();
                String not = etNot.getText().toString();

                if (bitcoinAdi.isEmpty() || maliyet.isEmpty() || stopNoktasi.isEmpty() || not.isEmpty()) {
                    tvBitcoinListesi.setText("Lütfen tüm alanları doldurun.");
                    return;
                }

                String yeniBitcoin = "Bitcoin: " + bitcoinAdi + "\n"
                        + "Maliyet: " + maliyet + "\n"
                        + "Stop Noktası: " + stopNoktasi + "\n"
                        + "Beklentiler: " + not + "\n\n";

                String mevcutListe = tvBitcoinListesi.getText().toString();
                String guncelListe = mevcutListe + yeniBitcoin;

                tvBitcoinListesi.setText(guncelListe);

                saveData(guncelListe);

                // Formu sıfırla
                etBitcoinAdi.setText("");
                etMaliyet.setText("");
                etStopNoktasi.setText("");
                etNot.setText("");
            }
        });

        // Listeyi Sil butonu işlevi
        btnListeyiSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvBitcoinListesi.setText("");
                clearData();
            }
        });

        // Yeni Bitcoin adını sorgulama butonu işlevi
        btnSorgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sorgulananBitcoin = etBitcoinAdi.getText().toString().trim();

                if (sorgulananBitcoin.isEmpty()) {
                    Toast.makeText(BitcoinActivity.this, "Lütfen bir Bitcoin adı girin", Toast.LENGTH_SHORT).show();
                    return;
                }

                String mevcutListe = tvBitcoinListesi.getText().toString();
                if (mevcutListe.contains("Bitcoin: " + sorgulananBitcoin)) {
                    Toast.makeText(BitcoinActivity.this, sorgulananBitcoin + " listede bulunuyor.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BitcoinActivity.this, sorgulananBitcoin + " listede bulunamadı.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Güncelleme butonunun işlevi
        btnGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bitcoinAdi = etBitcoinAdi.getText().toString();
                String maliyet = etMaliyet.getText().toString();
                String stopNoktasi = etStopNoktasi.getText().toString();
                String not = etNot.getText().toString();

                if (bitcoinAdi.isEmpty() || maliyet.isEmpty() || stopNoktasi.isEmpty() || not.isEmpty()) {
                    Toast.makeText(BitcoinActivity.this, "Lütfen tüm alanları doldurun.", Toast.LENGTH_SHORT).show();
                    return;
                }

                String mevcutListe = tvBitcoinListesi.getText().toString();

                // Güncellenmesi gereken Bitcoin bilgisi
                if (mevcutListe.contains("Bitcoin: " + bitcoinAdi)) {
                    String guncellenmisBitcoin = "Bitcoin: " + bitcoinAdi + "\n"
                            + "Maliyet: " + maliyet + "\n"
                            + "Stop Noktası: " + stopNoktasi + "\n"
                            + "Beklentiler: " + not + "\n\n";

                    // Listeyi güncelle
                    mevcutListe = mevcutListe.replace("Bitcoin: " + bitcoinAdi, guncellenmisBitcoin);

                    tvBitcoinListesi.setText(mevcutListe);
                    saveData(mevcutListe);

                    Toast.makeText(BitcoinActivity.this, bitcoinAdi + " başarıyla güncellendi.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BitcoinActivity.this, bitcoinAdi + " listede bulunamadı.", Toast.LENGTH_SHORT).show();
                }

                // Formu sıfırla
                etBitcoinAdi.setText("");
                etMaliyet.setText("");
                etStopNoktasi.setText("");
                etNot.setText("");
            }
        });

        // Geri düğmesini etkinleştir
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    // Veriyi SharedPreferences'e kaydetme
    private void saveData(String data) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LIST_KEY, data);
        editor.apply();
    }

    // Kaydedilen veriyi yükleme
    private void loadSavedData() {
        String savedList = sharedPreferences.getString(LIST_KEY, "");
        tvBitcoinListesi.setText(savedList);
    }

    // SharedPreferences'teki veriyi silme
    private void clearData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(LIST_KEY);
        editor.apply();
    }

    // Geri düğmesine basıldığında aktiviteyi kapat
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
*/
/*
package com.example.borsatakipuygulamasi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BitcoinActivity extends AppCompatActivity {

    private EditText etBitcoinAdi, etMaliyet, etStopNoktasi, etNot;
    private TextView tvBitcoinListesi;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "BitcoinTakipPrefs";
    private static final String LIST_KEY = "BitcoinListesi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitcoin);

        // Layout elemanlarını tanımla
        etBitcoinAdi = findViewById(R.id.etBitcoinAdi);
        etMaliyet = findViewById(R.id.etMaliyet);
        etStopNoktasi = findViewById(R.id.etStopNoktasi);
        etNot = findViewById(R.id.etNot);
        tvBitcoinListesi = findViewById(R.id.tvBitcoinListesi);
        Button btnEkle = findViewById(R.id.btnEkle);
        Button btnListeyiSil = findViewById(R.id.button2);
        Button btnSorgula = findViewById(R.id.btnSorgula);
        Button btnGuncelle = findViewById(R.id.btnGuncelle); // Güncelleme butonu

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        // Kaydedilen verileri yükle
        loadSavedData();

        // Ekle butonu işlevi
        btnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bitcoinAdi = etBitcoinAdi.getText().toString();
                String maliyet = etMaliyet.getText().toString();
                String stopNoktasi = etStopNoktasi.getText().toString();
                String not = etNot.getText().toString();

                if (bitcoinAdi.isEmpty() || maliyet.isEmpty() || stopNoktasi.isEmpty() || not.isEmpty()) {
                    tvBitcoinListesi.setText("Lütfen tüm alanları doldurun.");
                    return;
                }

                String yeniBitcoin = "Bitcoin: " + bitcoinAdi + "\n"
                        + "Maliyet: " + maliyet + "\n"
                        + "Stop Noktası: " + stopNoktasi + "\n"
                        + "Beklentiler: " + not + "\n\n";

                String mevcutListe = tvBitcoinListesi.getText().toString();
                String guncelListe = mevcutListe + yeniBitcoin;

                tvBitcoinListesi.setText(guncelListe);

                saveData(guncelListe);

                // Formu sıfırla
                etBitcoinAdi.setText("");
                etMaliyet.setText("");
                etStopNoktasi.setText("");
                etNot.setText("");
            }
        });

        // Listeyi Sil butonu işlevi
        btnListeyiSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvBitcoinListesi.setText("");
                clearData();
            }
        });

        // Yeni Bitcoin adını sorgulama butonu işlevi
        btnSorgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sorgulananBitcoin = etBitcoinAdi.getText().toString().trim();

                if (sorgulananBitcoin.isEmpty()) {
                    Toast.makeText(BitcoinActivity.this, "Lütfen bir Bitcoin adı girin", Toast.LENGTH_SHORT).show();
                    return;
                }

                String mevcutListe = tvBitcoinListesi.getText().toString();
                if (mevcutListe.contains("Bitcoin: " + sorgulananBitcoin)) {
                    Toast.makeText(BitcoinActivity.this, sorgulananBitcoin + " listede bulunuyor.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BitcoinActivity.this, sorgulananBitcoin + " listede bulunamadı.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Güncelleme butonunun işlevi
        btnGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bitcoinAdi = etBitcoinAdi.getText().toString();
                String maliyet = etMaliyet.getText().toString();
                String stopNoktasi = etStopNoktasi.getText().toString();
                String not = etNot.getText().toString();

                if (bitcoinAdi.isEmpty() || maliyet.isEmpty() || stopNoktasi.isEmpty() || not.isEmpty()) {
                    Toast.makeText(BitcoinActivity.this, "Lütfen tüm alanları doldurun.", Toast.LENGTH_SHORT).show();
                    return;
                }

                String mevcutListe = tvBitcoinListesi.getText().toString();

                // Güncellenmesi gereken Bitcoin bilgisi
                if (mevcutListe.contains("Bitcoin: " + bitcoinAdi)) {
                    String guncellenmisBitcoin = "Bitcoin: " + bitcoinAdi + "\n"
                            + "Maliyet: " + maliyet + "\n"
                            + "Stop Noktası: " + stopNoktasi + "\n"
                            + "Beklentiler: " + not + "\n\n";

                    // Listeyi güncelle
                    mevcutListe = mevcutListe.replaceFirst("Bitcoin: " + bitcoinAdi + "[\\s\\S]*?\\n\\n", guncellenmisBitcoin);

                    tvBitcoinListesi.setText(mevcutListe);
                    saveData(mevcutListe);

                    Toast.makeText(BitcoinActivity.this, bitcoinAdi + " başarıyla güncellendi.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BitcoinActivity.this, bitcoinAdi + " listede bulunamadı.", Toast.LENGTH_SHORT).show();
                }

                // Formu sıfırla
                etBitcoinAdi.setText("");
                etMaliyet.setText("");
                etStopNoktasi.setText("");
                etNot.setText("");
            }
        });

        // Geri düğmesini etkinleştir
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    // Veriyi SharedPreferences'e kaydetme
    private void saveData(String data) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LIST_KEY, data);
        editor.apply();
    }

    // Kaydedilen veriyi yükleme
    private void loadSavedData() {
        String savedList = sharedPreferences.getString(LIST_KEY, "");
        tvBitcoinListesi.setText(savedList);
    }

    // SharedPreferences'teki veriyi silme
    private void clearData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(LIST_KEY);
        editor.apply();
    }

    // Geri düğmesine basıldığında aktiviteyi kapat
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
} */
/*
package com.example.borsatakipuygulamasi;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BitcoinActivity extends AppCompatActivity {

    private EditText etBitcoinAdi, etMaliyet, etStopNoktasi, etNot;
    private TextView tvBitcoinListesi;
    private DatabaseHelper databaseHelper; // DatabaseHelper sınıfı

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitcoin);

        // Layout elemanlarını tanımla
        etBitcoinAdi = findViewById(R.id.etBitcoinAdi);
        etMaliyet = findViewById(R.id.etMaliyet);
        etStopNoktasi = findViewById(R.id.etStopNoktasi);
        etNot = findViewById(R.id.etNot);
        tvBitcoinListesi = findViewById(R.id.tvBitcoinListesi);
        Button btnEkle = findViewById(R.id.btnEkle);
        Button btnListeyiSil = findViewById(R.id.button2);
        Button btnSorgula = findViewById(R.id.btnSorgula);

        // Veritabanı bağlantısını başlat
        databaseHelper = new DatabaseHelper(this);

        // Ekle butonu işlevi
        btnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bitcoinAdi = etBitcoinAdi.getText().toString();
                String maliyet = etMaliyet.getText().toString();
                String stopNoktasi = etStopNoktasi.getText().toString();
                String not = etNot.getText().toString();

                if (bitcoinAdi.isEmpty() || maliyet.isEmpty() || stopNoktasi.isEmpty() || not.isEmpty()) {
                    tvBitcoinListesi.setText("Lütfen tüm alanları doldurun.");
                    return;
                }

                // Yeni Bitcoin verisini veritabanına ekle
                databaseHelper.insertBitcoin(bitcoinAdi, maliyet, stopNoktasi, not);

                // Formu sıfırla
                etBitcoinAdi.setText("");
                etMaliyet.setText("");
                etStopNoktasi.setText("");
                etNot.setText("");

                // Veritabanındaki tüm Bitcoinleri listele
                loadBitcoinList();
            }
        });

        // Listeyi Sil butonu işlevi
        btnListeyiSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteAllBitcoins();
                loadBitcoinList();  // Listeyi yeniden yükle
                Toast.makeText(BitcoinActivity.this, "Liste temizlendi.", Toast.LENGTH_SHORT).show();
            }
        });

        // Yeni Bitcoin adını sorgulama butonu işlevi
        btnSorgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sorgulananBitcoin = etBitcoinAdi.getText().toString().trim();

                if (sorgulananBitcoin.isEmpty()) {
                    Toast.makeText(BitcoinActivity.this, "Lütfen bir Bitcoin adı girin", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Veritabanında Bitcoin adı sorgula
                Cursor cursor = databaseHelper.getAllBitcoins();
                boolean found = false;
                while (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    if (name.equals(sorgulananBitcoin)) {
                        Toast.makeText(BitcoinActivity.this, sorgulananBitcoin + " listede bulunuyor.", Toast.LENGTH_SHORT).show();
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    Toast.makeText(BitcoinActivity.this, sorgulananBitcoin + " listede bulunamadı.", Toast.LENGTH_SHORT).show();
                }
                cursor.close();  // Cursor'u kapat
            }
        });

        // Başlangıçta veritabanındaki tüm Bitcoinleri yükle
        loadBitcoinList();
    }

    // Veritabanındaki Bitcoin listesini yükle
    private void loadBitcoinList() {
        Cursor cursor = databaseHelper.getAllBitcoins();
        StringBuilder bitcoinList = new StringBuilder();

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String cost = cursor.getString(cursor.getColumnIndex("cost"));
            String stop = cursor.getString(cursor.getColumnIndex("stop"));
            String note = cursor.getString(cursor.getColumnIndex("note"));

            bitcoinList.append("Bitcoin: ").append(name).append("\n")
                    .append("Maliyet: ").append(cost).append("\n")
                    .append("Stop Noktası: ").append(stop).append("\n")
                    .append("Beklentiler: ").append(note).append("\n\n");
        }

        tvBitcoinListesi.setText(bitcoinList.toString());
        cursor.close();  // Cursor'u kapat
    }
}
*/

package com.example.borsatakipuygulamasi;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BitcoinActivity extends AppCompatActivity {

    private EditText etBitcoinAdi, etMaliyet, etStopNoktasi, etNot;
    private TextView tvBitcoinListesi;
    private DatabaseHelper databaseHelper; // DatabaseHelper sınıfı

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitcoin);

        // Layout elemanlarını tanımla
        etBitcoinAdi = findViewById(R.id.etBitcoinAdi);
        etMaliyet = findViewById(R.id.etMaliyet);
        etStopNoktasi = findViewById(R.id.etStopNoktasi);
        etNot = findViewById(R.id.etNot);
        tvBitcoinListesi = findViewById(R.id.tvBitcoinListesi);
        Button btnEkle = findViewById(R.id.btnEkle);
        Button btnListeyiSil = findViewById(R.id.button2);
        Button btnSorgula = findViewById(R.id.btnSorgula);
        Button btnGuncelle = findViewById(R.id.btnGuncelle); // Güncelle butonu ekleyin

        // Veritabanı bağlantısını başlat
        databaseHelper = new DatabaseHelper(this);

        // Ekle butonu işlevi
        btnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bitcoinAdi = etBitcoinAdi.getText().toString();
                String maliyet = etMaliyet.getText().toString();
                String stopNoktasi = etStopNoktasi.getText().toString();
                String not = etNot.getText().toString();

                if (bitcoinAdi.isEmpty() || maliyet.isEmpty() || stopNoktasi.isEmpty() || not.isEmpty()) {
                    tvBitcoinListesi.setText("Lütfen tüm alanları doldurun.");
                    return;
                }

                // Yeni Bitcoin verisini veritabanına ekle
                databaseHelper.insertBitcoin(bitcoinAdi, maliyet, stopNoktasi, not);

                // Formu sıfırla
                etBitcoinAdi.setText("");
                etMaliyet.setText("");
                etStopNoktasi.setText("");
                etNot.setText("");

                // Veritabanındaki tüm Bitcoinleri listele
                loadBitcoinList();
            }
        });

        // Listeyi Sil butonu işlevi
        btnListeyiSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteAllBitcoins();
                loadBitcoinList();  // Listeyi yeniden yükle
                Toast.makeText(BitcoinActivity.this, "Liste temizlendi.", Toast.LENGTH_SHORT).show();
            }
        });

        // Yeni Bitcoin adını sorgulama butonu işlevi
        btnSorgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sorgulananBitcoin = etBitcoinAdi.getText().toString().trim();

                if (sorgulananBitcoin.isEmpty()) {
                    Toast.makeText(BitcoinActivity.this, "Lütfen bir Bitcoin adı girin", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Veritabanında Bitcoin adı sorgula
                Cursor cursor = databaseHelper.getAllBitcoins();
                boolean found = false;
                while (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    if (name.equals(sorgulananBitcoin)) {
                        Toast.makeText(BitcoinActivity.this, sorgulananBitcoin + " listede bulunuyor.", Toast.LENGTH_SHORT).show();
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    Toast.makeText(BitcoinActivity.this, sorgulananBitcoin + " listede bulunamadı.", Toast.LENGTH_SHORT).show();
                }
                cursor.close();  // Cursor'u kapat
            }
        });

        // Güncelle butonu işlevi
        btnGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bitcoinAdi = etBitcoinAdi.getText().toString();
                String yeniMaliyet = etMaliyet.getText().toString();
                String yeniStop = etStopNoktasi.getText().toString();
                String yeniNot = etNot.getText().toString();

                if (bitcoinAdi.isEmpty() || yeniMaliyet.isEmpty() || yeniStop.isEmpty() || yeniNot.isEmpty()) {
                    Toast.makeText(BitcoinActivity.this, "Lütfen tüm alanları doldurun.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Bitcoin verisini güncelle
                databaseHelper.updateBitcoin(bitcoinAdi, yeniMaliyet, yeniStop, yeniNot);

                // Formu sıfırla
                etBitcoinAdi.setText("");
                etMaliyet.setText("");
                etStopNoktasi.setText("");
                etNot.setText("");

                // Veritabanındaki tüm Bitcoinleri listele
                loadBitcoinList();
            }
        });

        // Başlangıçta veritabanındaki tüm Bitcoinleri yükle
        loadBitcoinList();
    }

    // Veritabanındaki Bitcoin listesini yükle
    private void loadBitcoinList() {
        Cursor cursor = databaseHelper.getAllBitcoins();
        StringBuilder bitcoinList = new StringBuilder();

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String cost = cursor.getString(cursor.getColumnIndex("cost"));
            String stop = cursor.getString(cursor.getColumnIndex("stop"));
            String note = cursor.getString(cursor.getColumnIndex("note"));

            bitcoinList.append("Bitcoin: ").append(name).append("\n")
                    .append("Maliyet: ").append(cost).append("\n")
                    .append("Stop Noktası: ").append(stop).append("\n")
                    .append("Beklentiler: ").append(note).append("\n\n");
        }

        tvBitcoinListesi.setText(bitcoinList.toString());
        cursor.close();  // Cursor'u kapat
    }

}
