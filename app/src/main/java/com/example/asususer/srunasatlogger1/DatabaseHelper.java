package com.example.asususer.srunasatlogger1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by asus user on 2/11/2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_Version = 1;
    public static final String DATABASE_NAME = "Users.db";
    public static final String TABLE_NAME = "User";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_CONFIRMPASSWORD = "confirmpassword";
    public static final String COLUMN_FIRSTNAME = "firstname";
    public static final String COLUMN_LASTNAME = "lastname";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_KANTOOR = "kantoor";
    public static final String COLUMN_ADRES = "adres";
    public static final String COLUMN_PHONE = "phone";
    SQLiteDatabase database;
    private static final String TABBLE_CREATE = "create table contacts (id integer primary key not null , " +
            "username text not null , password text not null , confirmpassword text not null , firstname text not null , lastname text not null , email text not null ," +
            " gender text not null , kantoor text not null , adres text not null , phone text not null) ";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABBLE_CREATE);
        this.database = database;

    }

    public void insertUser(User user) {
        database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from users";
        Cursor cursor = database.rawQuery(query , null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_USERNAME, user.getUserName());
        values.put(COLUMN_PASSWORD, user.getPassword());
        values.put(COLUMN_CONFIRMPASSWORD, user.getConfirmPassword());
        values.put(COLUMN_FIRSTNAME, user.getFirstName());
        values.put(COLUMN_LASTNAME, user.getLastName());
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_GENDER, user.getGender());
        values.put(COLUMN_KANTOOR, user.getKantoor());
        values.put(COLUMN_ADRES, user.getAdres());
        values.put(COLUMN_PHONE, user.getPhone());

        database.insert(TABLE_NAME, null, values);
        database.close();
    }

    public String searchpassword(String username) {
        database = this.getReadableDatabase();
        String query = " select username , password from " + TABLE_NAME;
        Cursor cursor = database.rawQuery(query, null);

        String usernameT, passwordT;
        passwordT = "Not Found";

        if (cursor.moveToFirst())
        {
            do {
                usernameT = cursor.getString(0);
                passwordT = cursor.getString(1);

                if (usernameT.equals(username)) {
                    passwordT = cursor.getString(1);
                    break;
                }
                }
                while (cursor.moveToNext()) ;
                }
                return passwordT;
            }


    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        database.execSQL(query);
        this.onCreate(database);

    }
}
