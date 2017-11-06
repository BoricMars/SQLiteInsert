package com.example.sqliteinsert;

import android.provider.BaseColumns;

/**
 * Created by christian on 2-11-2017.
 */

public class UserContract {
    // lege constructor class word hier neergezet
    private UserContract() {

    }

    public static final class Contract implements BaseColumns {
        // naam database
        public final static String DATABASE_NAME = "employee";

        // database versie
        public final static int DATABASE_VERSION = 5;


        public final static class UserEntity {

            //  baan viir database voor users
            public final static String TABLE_NAME = "UserInfo";

            // ID van User
            public final static String UID = BaseColumns._ID;

            // User Name
            public final static String USER_NAME = "UserName";

            // Password
            public final static String USER_PWD = "Password";

        }


    }
}
