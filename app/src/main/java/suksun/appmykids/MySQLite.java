package suksun.appmykids;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by suksun on 11/23/2016 AD.
 */
public class MySQLite {
    private  MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;
//ตาราง tbusers
  public static final  String tbusers = "tbusers";
    public static final String column_noid = "noid";
    public static final String column_username = "username";
    public static final String column_password = "password";

// tbfamily
    public static final  String tbfamily = "tbfamily";
    public static final String column_famid = "famid";
    public static final String column_famname = "famname";
    public static final String column_famfather = "famfather";




    public MySQLite(Context context){
        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();
    }

    public  long addNewUser(String strusername,String strpassword){
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_username,strusername);
        contentValues.put(column_password,strpassword);
        return sqLiteDatabase.insert(tbusers,null,contentValues);
    }

    public  long addFamily(String strfamname,String strfamfather){
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_famname,strfamname);
        contentValues.put(column_famfather,strfamfather);
        return sqLiteDatabase.insert(tbfamily,null,contentValues);
    }



}
