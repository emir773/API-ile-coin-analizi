package com.example.borsatakipuygulamasi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {

    // Veritabanı bilgileri
    private static final String DATABASE_NAME = "AltcoinDB";
    private static final int DATABASE_VERSION = 1;

    // Tablo bilgileri
    private static final String TABLE_NAME = "Altcoins";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_COIN_NAME = "coin_name";
    private static final String COLUMN_BASKET_NAME = "basket_name";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Altcoins tablosunu oluştur
        String createTable = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_COIN_NAME + " TEXT, "
                + COLUMN_BASKET_NAME + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Tabloyu güncelleme sırasında eski tabloyu sil ve yeniden oluştur
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Coin ekleme
    public boolean insertCoin(String coinName, String basketName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_COIN_NAME, coinName);
        values.put(COLUMN_BASKET_NAME, basketName);

        long result = db.insert(TABLE_NAME, null, values);
        return result != -1; // Başarılıysa true, değilse false döner
    }

    // Tüm coinleri çekme
    public Cursor getAllCoins() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    // Belirli bir sepetteki coinleri çekme
    public ArrayList<String> getCoinsByBasket(String basketName) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> coinList = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME,
                new String[]{COLUMN_COIN_NAME},
                COLUMN_BASKET_NAME + "=?",
                new String[]{basketName},
                null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                coinList.add(cursor.getString(0)); // Coin adını listeye ekle
            } while (cursor.moveToNext());
            cursor.close();
        }
        return coinList;
    }

    // Coin silme
    public boolean deleteCoin(String coinName, String basketName) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowsDeleted = db.delete(TABLE_NAME,
                COLUMN_COIN_NAME + "=? AND " + COLUMN_BASKET_NAME + "=?",
                new String[]{coinName, basketName});

        return rowsDeleted > 0; // Silme işlemi başarılıysa true döner
    }

    // Belirli bir sepeti silme
    public boolean deleteBasket(String basketName) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowsDeleted = db.delete(TABLE_NAME,
                COLUMN_BASKET_NAME + "=?",
                new String[]{basketName});

        return rowsDeleted > 0; // Silme işlemi başarılıysa true döner
    }

    // Veritabanını temizleme
    public void clearDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }
}
