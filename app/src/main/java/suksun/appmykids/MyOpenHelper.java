package suksun.appmykids;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by suksun on 11/23/2016 AD.
 */
public class MyOpenHelper  extends SQLiteOpenHelper{
    public static  final String database_name = "dbmykids.db";
    private  static  final  int  database_version = 1;

    private  static  final  String create_tbusers_table = "create table tbusers(" +
            "noid integer primary key," +
            "username text, " +
            "password text);";

    private  static  final  String create_tbdev1_table = "create table tbdev1(" +
            "dev1id integer primary key," +
            "standaction text, " +
            "handaction text, " +
            "handtomouth text, " +
            "voiced text, " +
            "palygoods text, " +
            "dateadd text, " +
            "username text);";


    public MyOpenHelper(Context context){
        super(context,database_name,null,database_version);

    } //constructor


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_tbusers_table);
        sqLiteDatabase.execSQL(create_tbdev1_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
