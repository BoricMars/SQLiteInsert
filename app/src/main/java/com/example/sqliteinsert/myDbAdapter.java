package com.example.sqliteinsert;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.sqliteinsert.UserContract.Contract.UserEntity.TABLE_NAME;

public class myDbAdapter  {

    myDbHelper helper;

    public myDbAdapter(Context context)
    {
        helper = new myDbHelper(context);
    }

    public long insertData(String name, String password) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.Contract.UserEntity.USER_NAME, name);
        contentValues.put(UserContract.Contract.UserEntity.USER_PWD, password);
        long id = db.insert(UserContract.Contract.DATABASE_NAME, null, contentValues);
        return id;
    }

    public Cursor getData(){
        SQLiteDatabase db = helper.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    static class myDbHelper extends SQLiteOpenHelper {
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + UserContract.Contract.UserEntity.UID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + UserContract.Contract.UserEntity.USER_NAME + " VARCHAR(225), "
                + UserContract.Contract.UserEntity.USER_PWD + " VARCHAR(225));";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "
                + TABLE_NAME;
        // laat zien in welke view/activity je zit.
        private Context context;

        public myDbHelper(Context context) {
            super(context, UserContract.Contract.DATABASE_NAME, null, UserContract.Contract.DATABASE_VERSION);
            this.context = context;
            Message.message(context, "Started...");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {

                db.execSQL(CREATE_TABLE);
                Message.message(context, "TABLE CREATED");
            } catch (Exception e) {
                Message.message(context, "" + e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context, "OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (Exception e) {
                Message.message(context, "" + e);
            }
        }
    }

}
