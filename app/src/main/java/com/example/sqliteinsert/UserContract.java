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
        public final static String DATABASE_NAME = "employee";
        public final static int DATABASE_VERSION = 5;


        public final static class UserEntity {
            public final static String TABLE_NAME = "UserInfo";
            public final static String UID = BaseColumns._ID;
            public final static String USER_NAME = "UserName";
            public final static String USER_PWD = "Password";

        }


    }
}
