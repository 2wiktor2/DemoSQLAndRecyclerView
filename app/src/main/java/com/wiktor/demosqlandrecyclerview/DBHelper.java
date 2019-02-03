package com.wiktor.demosqlandrecyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final String NAME_OF_DB = "DBForCrossSection";

    final String COLUMN_ID = "ColumnId";
    final String COLUMN_DATA_TIME = "ColumnDataTime";
    final String COLUMN_NUM_1 = "ColumnNum1";
    final String COLUMN_NUM_2 = "ColumnNum2";
    final String COLUMN_NUM_3 = "ColumnNum3";
    final String COLUMN_SHOP = "ColumnShop";
    final String COLUMN_PRISE = "ColumnPrise";
    final String COLUMN_NOTES = "ColumnNotes";


    final String NAME_OF_TABLE = "SavedHistory";


    public DBHelper(Context context) {
        super(context, "DBForCrossSection", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table " + NAME_OF_TABLE + " ( " + COLUMN_ID +
                " integer primary key autoincrement, " +
                COLUMN_DATA_TIME + " text, " +
                COLUMN_NUM_1 + " integer, " +
                COLUMN_NUM_2 + " integer, " +
                COLUMN_NUM_3 + " integer, " +
                COLUMN_SHOP + " text, " +
                COLUMN_PRISE + " integer, " +
                COLUMN_NOTES + " text);");
        //db.execSQL("Create table " + NAME_OF_TABLE + " ( " + ID_COLUMN +
        // " integer primary key autoincrement, " +  FIO_COLUMN + " text, " +
        // AGE_COLUMN + " text );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createRow(String time, int num1, int num2, int num3, String shop, int prise, String notes) {
        SQLiteDatabase db111 = getWritableDatabase();
        ContentValues cv111 = new ContentValues();
        cv111.put(COLUMN_DATA_TIME, time);
        cv111.put(COLUMN_NUM_1, num1);
        cv111.put(COLUMN_NUM_2, num2);
        cv111.put(COLUMN_NUM_3, num3);
        cv111.put(COLUMN_SHOP, shop);
        cv111.put(COLUMN_PRISE, prise);
        cv111.put(COLUMN_NOTES, notes);

        long rowId = db111.insert(NAME_OF_TABLE, null, cv111);
        Log.d("ololo", " Дата = " + time +
                " Num1 = " + num1 +
                " Num2 = " + num2 +
                " Num3 = " + num3 +
                " Shop = " + shop +
                " Prise = " + prise +
                " Notes = " + notes);
    }

    public ArrayList <HistoryModel> getData() {
        ArrayList <HistoryModel> arrayList = new ArrayList <>();
        SQLiteDatabase db = getWritableDatabase();
        String[] columns = {COLUMN_ID,
                COLUMN_DATA_TIME,
                COLUMN_NUM_1,
                COLUMN_NUM_2,
                COLUMN_NUM_3,
                COLUMN_SHOP,
                COLUMN_PRISE,
                COLUMN_NOTES};
        Cursor cursor = db.query(NAME_OF_TABLE, columns, null, null,
                null, null, null, null);
        if (cursor.moveToFirst()) {
            int idFromTable = cursor.getColumnIndex(COLUMN_ID);
            int dataTimeFromTable = cursor.getColumnIndex(COLUMN_DATA_TIME);
            int num1FromTable = cursor.getColumnIndex(COLUMN_NUM_1);
            int num2FromTable = cursor.getColumnIndex(COLUMN_NUM_2);
            int num3FromTable = cursor.getColumnIndex(COLUMN_NUM_3);
            int shopFromTable = cursor.getColumnIndex(COLUMN_SHOP);
            int priseFromTable = cursor.getColumnIndex(COLUMN_PRISE);
            int notesFromTable = cursor.getColumnIndex(COLUMN_NOTES);

            do {
                HistoryModel hm = new HistoryModel(
                        cursor.getInt(idFromTable),
                        cursor.getString(dataTimeFromTable),
                        cursor.getInt(num1FromTable),
                        cursor.getInt(num2FromTable),
                        cursor.getInt(num3FromTable),
                        cursor.getString(shopFromTable),
                        cursor.getInt(priseFromTable),
                        cursor.getString(notesFromTable)
                );
                arrayList.add(hm);

            } while (cursor.moveToNext());
            cursor.close();
        }
        return arrayList;
    }
}
