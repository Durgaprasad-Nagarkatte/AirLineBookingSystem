package com.company.akshay.flightbooking.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.company.akshay.flightbooking.Data.UserContract.UserEntry.TABLE_NAME;

/**
 * Created by Durgaprasad on 4/21/2017.
 */

public class UserDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = UserDbHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "user.db";
    private static final int DATABASE_VERSION = 1;


    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USERS_TABLE =  "CREATE TABLE " + UserContract.UserEntry.TABLE_NAME + " ("
                + UserContract.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + UserContract.UserEntry.AIR_LINE_NAME + " TEXT NOT NULL, "
                + UserContract.UserEntry.AIR_LINE_ID + " TEXT);";
        db.execSQL(SQL_CREATE_USERS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
