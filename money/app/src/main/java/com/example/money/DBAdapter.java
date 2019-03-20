package com.example.money;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBAdapter  extends SQLiteOpenHelper {
    //private static final float S =0;

    public DBAdapter(Context context) {
        super(context, "money", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        String creatTable = "create table flous(id integer primary key,produit text ,money float, date text)";
        db.execSQL(creatTable);
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteTable = ("drop table if exists flous ");
        db.execSQL(deleteTable);
        onCreate(db);
    }

    public void ajouter(flous f) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("produit", f.getProduit());
        contentValues.put("money", f.getMoney());
        contentValues.put("date", f.getDate());
        db.insert("flous", null, contentValues);

    }

    public ArrayList<flous> afficher() {
        SQLiteDatabase db = getReadableDatabase();
        String selectall = "SELECT * FROM flous";
        Cursor cursor = db.rawQuery(selectall, null);
        ArrayList<flous> flouss = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                flous f = new flous(cursor.getString(1), cursor.getFloat(2));
                f.setId(cursor.getInt(0));
                f.setDate(cursor.getString(3));
                flouss.add(f);
            }
            while (cursor.moveToNext());
        }
        return flouss;
    }

    public void delete(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("flous", "id=" + Integer.toString(id), null);
    }

   // public float total() {
      //////  SQLiteDatabase db = getReadableDatabase();
       // String d = "SELECT SUM(prix) as S FROM flous";
       // Cursor cursor = db.rawQuery(d, null);

  // return  S ;}
  public Float total()
  {   Float T =0f ;

      SQLiteDatabase db=getReadableDatabase();
      String selectall="SELECT * FROM flous";
      Cursor cursor= db.rawQuery(selectall,null);
      ArrayList<flous> flouss=new ArrayList<>();
      if (cursor.moveToFirst()){
          do{
              T+=cursor.getFloat(2);
          }
          while(cursor.moveToNext());
      }

      return T ;}




}







