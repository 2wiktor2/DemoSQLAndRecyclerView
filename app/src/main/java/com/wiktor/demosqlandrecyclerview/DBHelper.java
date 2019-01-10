package com.wiktor.demosqlandrecyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
        db.execSQL("Create table " + NAME_OF_TABLE + " ( " + COLUMN_ID + " integer primary key autoincrement, " +
                COLUMN_DATA_TIME + " text, " +
                COLUMN_NUM_1 + " integer, " +
                COLUMN_NUM_2 + " integer, " +
                COLUMN_NUM_3 + " integer, " +
                COLUMN_SHOP + " text, " +
                COLUMN_PRISE + " text, " +
                COLUMN_NOTES + " text);");
        //db.execSQL("Create table " + NAME_OF_TABLE + " ( " + ID_COLUMN + " integer primary key autoincrement, " +  FIO_COLUMN + " text, " +  AGE_COLUMN + " text );");
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

    public void getData() {
        SQLiteDatabase db = getWritableDatabase();
        String[] columns = {COLUMN_ID,
                COLUMN_DATA_TIME,
                COLUMN_NUM_1,
                COLUMN_NUM_2,
                COLUMN_NUM_3,
                COLUMN_SHOP,
                COLUMN_PRISE,
                COLUMN_NOTES};


/*
            String selection = AGE_COLUMN + " = ? AND " + FIO_COLUMN+ " = ?";
            String[] selectionArgs = new String[]{"3", "kkk"};
            Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, FIO_COLUMN + " desc");

            if (cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex(ID_COLUMN);
                int fio = cursor.getColumnIndex(FIO_COLUMN);
                int age = cursor.getColumnIndex(AGE_COLUMN);
                do {
                    Log.d("ololo",
                            " fio = " + cursor.getString(fio) +
                                    " age = " + cursor.getString(age));

                } while (cursor.moveToNext());

                cursor.close();
            }
        }
*/

/*        case R.id.btnRead:
        Log.d(LOG_TAG, "--- Rows in mytable: ---");
        // делаем запрос всех данных из таблицы mytable, получаем Cursor
        Cursor c = db.query("mytable", null, null, null, null, null, null);

        // ставим позицию курсора на первую строку выборки
        // если в выборке нет строк, вернется false
        if (c.moveToFirst()) {

            // определяем номера столбцов по имени в выборке
            int idColIndex = c.getColumnIndex("id");
            int nameColIndex = c.getColumnIndex("name");
            int emailColIndex = c.getColumnIndex("email");

            do {
                // получаем значения по номерам столбцов и пишем все в лог
                Log.d(LOG_TAG,
                        "ID = " + c.getInt(idColIndex) +
                                ", name = " + c.getString(nameColIndex) +
                                ", email = " + c.getString(emailColIndex));
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (c.moveToNext());
        } else
            Log.d(LOG_TAG, "0 rows");
        c.close();
        break;*/

    }
}