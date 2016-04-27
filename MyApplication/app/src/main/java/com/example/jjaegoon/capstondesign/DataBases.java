package com.example.jjaegoon.capstondesign;

/**
 * Created by jjaegoon on 2016-04-27.
 */

import android.provider.BaseColumns;

public final class DataBases {

        public static final class CreateDB implements BaseColumns {
            public static final String NAME = "name";
            public static final String CONTENT = "content";
            public static final String _TABLENAME = "rfid";
            public static final String _CREATE = "create table" + _TABLENAME + "(" + _ID + " integer primary key autoincrement, "
                    +NAME+" text not null, "
                    +CONTENT+" text not null);";
        }
}
