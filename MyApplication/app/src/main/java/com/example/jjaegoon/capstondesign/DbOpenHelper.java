package com.example.jjaegoon.capstondesign;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jjaegoon on 2016-04-27.
 */
public class DbOpenHelper{

    private static final String DATABASE_NAME = "rfid.db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private DatabaseHelper mDBhelper;
    private Context mCtx;

    private class DatabaseHelper extends SQLiteOpenHelper {

        //생성자
        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context, name, factory, version);
        }

        //최초 DB를 만들때 한번만 호출된다.
        public void onCreate(SQLiteDatabase db){
            db.execSQL(DataBases.CreateDB._CREATE);
        }

        //버전이 업데이트 되었을 경우 DB를 다시 만들어 준다.
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS" + DataBases.CreateDB._TABLENAME);
            onCreate(db);
        }
    }

    public DbOpenHelper(Context context){
        this.mCtx = context;
    }

    public DbOpenHelper open() throws SQLException{
        mDBhelper = new DatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = mDBhelper.getWritableDatabase();
        return this;
    }

    public void close(){
        mDB.close();
    }
}
