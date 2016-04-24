package rmutr.narubeth.saowarak.norapol.broadcastertest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by NORAPOL on 11/3/2559.
 */
public class MyManage {

    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;

    public static final String test_table = "testTABLE";
    public static final String column_id = "id";
    public static final String column_name = "name";
    public static final String column_Date = "Date";
    public static final String column_Score = "score";
    public static final String column_Times = "Times";

    public MyManage(Context context) {

        myOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = myOpenHelper.getWritableDatabase();

    } //Constructor

    public long addTest(String strDate,
                        String strScore,
                        String strTimes,
                        String strName) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_name, strName);
        contentValues.put(column_Date, strDate);
        contentValues.put(column_Score, strScore);
        contentValues.put(column_Times, strTimes);

        return writeSqLiteDatabase.insert(test_table, null, contentValues);

    }

} //Main Class
