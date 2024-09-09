package com.example.ecopath_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class USERdatabase extends SQLiteOpenHelper
{

    private Context context;
    public static final String DATABASE_NAME="USERdatabase.db";
    public static final int DATABASE_VERSION=1;
    public static final String TABLE_NAME="StudentSignupData";
    public static final String COLUMN_REGNO="Reg_no";
    public static final String COLUMN_NAME="Name";
    public static final String COLUMN_BRANCH="Branch";
    public static final String COLUMN_BUSNUMBER="Bus_no";
    public static final String COLUMN_PASSWORD="Password";


    public USERdatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+TABLE_NAME+" ("+COLUMN_REGNO+" TEXT PRIMARY KEY, "+COLUMN_NAME+" TEXT, "+COLUMN_BRANCH+" TEXT, "+COLUMN_PASSWORD+" TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+";");
        onCreate(db);
    }

    public void add_details(String reg_no,String name,String branch,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_REGNO,reg_no);
        cv.put(COLUMN_NAME,name);
        cv.put(COLUMN_BRANCH,branch);
        cv.put(COLUMN_PASSWORD,password);
        long result=db.insert(TABLE_NAME,null,cv);
        if (result==-1)
        {
            Toast.makeText(context, "FAILED TO INSERT", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "SUCCESSFUL", Toast.LENGTH_SHORT).show();
        }
    }


    public Boolean check_regno_password(String reg,String pass)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+COLUMN_REGNO+" =? and "+COLUMN_PASSWORD+" =?;",new String[] {reg,pass});
        if (cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getusername(String reg)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT "+COLUMN_NAME+" FROM "+ TABLE_NAME+" WHERE "+COLUMN_REGNO+" = ?;",new String[] {reg});
        String result="";
        if (cursor.moveToFirst() && cursor != null)
        {
            result=cursor.getString(0);
            cursor.close();

        }
        return result;
    }

    public String getregno(String reg)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT "+COLUMN_REGNO+" FROM "+ TABLE_NAME+" WHERE "+COLUMN_REGNO+" = ?;",new String[] {reg});
        String result="";
        if (cursor.moveToFirst() && cursor != null)
        {
            result=cursor.getString(0);
            cursor.close();

        }
        return result;
    }

    public String getbranch(String reg)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT "+COLUMN_BRANCH+" FROM "+ TABLE_NAME+" WHERE "+COLUMN_REGNO+" = ?;",new String[] {reg});
        String result="";
        if (cursor.moveToFirst() && cursor != null)
        {
            result=cursor.getString(0);
            cursor.close();

        }
        return result;
    }


}
