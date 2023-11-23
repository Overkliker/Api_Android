package com.example.api_view;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "manga.db"; // название 6д
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE_NAME = "manga";
    public static final String COLUMN_ID = "id_manga" ;
    public static final String COLUMN_NAME = "manga_name" ;
    public static final String COLUMN_IMG = "manga_img";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME
                + " TEXT, " + COLUMN_IMG + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addManga(Manga manga){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, manga.getName());
        contentValues.put(COLUMN_IMG, manga.getImage());

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public ArrayList<Manga> getMangaList(){
        ArrayList<Manga> listManga = new ArrayList<>();
        SQLiteDatabase sqliteDatabase = this.getReadableDatabase();
        Cursor result = sqliteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        if (result.moveToFirst()) {
            while (result.moveToNext()) {
                int id = result.getInt(0);
                String mangaName = result.getString(1);
                String mangaImg = result.getString(2);
                Manga manga = new Manga(id, mangaName, mangaImg);
                listManga.add(manga);

            }
        }
        result.close();
        return listManga;
    }

    public void deleteRow(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE "  + COLUMN_NAME + "='"+ name +"';");
        db.close();
    }
}
