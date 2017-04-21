package com.company.akshay.flightbooking.Data;

import android.provider.BaseColumns;

/**
 * Created by Durgaprasad on 4/21/2017.
 */

public final class UserContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private UserContract() {}

    /**
     * Inner class that defines constant values for the pets database table.
     * Each entry in the table represents a single pet.
     */
    public static final class UserEntry implements BaseColumns {

        /** Name of database table for pets */
        public final static String TABLE_NAME = "users";

        public final static String _ID = BaseColumns._ID;

        public final static String AIR_LINE_NAME ="name";

        public final static String AIR_LINE_ID = "airline_id";
    }

}
