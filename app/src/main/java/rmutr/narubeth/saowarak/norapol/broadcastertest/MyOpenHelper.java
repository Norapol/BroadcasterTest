package rmutr.narubeth.saowarak.norapol.broadcastertest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NORAPOL on 11/3/2559.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit
    public static final String database_name = "test.db";
    private static final int database_version = 1;
    private static final String create_testTABLE = "create table testTABLE (" +
            "_id integer primary key, " +
            "Date text, " +
            "Score text, " +
            "Times text);";


    public MyOpenHelper(Context context) {
        super(context, database_name, null, database_version);
    } //Construtor

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_testTABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
} // Main Class
