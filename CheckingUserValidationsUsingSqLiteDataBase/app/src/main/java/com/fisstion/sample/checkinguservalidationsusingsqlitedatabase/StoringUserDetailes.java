package com.fisstion.sample.checkinguservalidationsusingsqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alekhya on 4/6/16.
 */
public class StoringUserDetailes extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "StoringUserDetailes";
    private static final String TBL_USER= "tbl_User_Information";


    public StoringUserDetailes(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creating the table
       /* String CREATE_USER_TABLE = "CREATE TABLE " + TBL_USER + "("
                + UserConstants.KEY_USER_NAME + " TEXT PRIMARY KEY,"+UserConstants.KEY_PASSWORD + " TEXT,"
                +  ")";
        db.execSQL(CREATE_USER_TABLE);
*/
        String CREATE_USER_TABLE = "CREATE TABLE " + TBL_USER + "("
                + UserConstants.KEY_USER_NAME+ " TEXT PRIMARY KEY,"+UserConstants.KEY_PASSWORD + " TEXT" + ")";

        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TBL_USER);

        // Create tables again
        onCreate(db);

    }
    public int getCount(){
        String selectQuery = "SELECT  * FROM " + TBL_USER;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null&& cursor.getCount()>0){
            return cursor.getCount();
        }
        return 0;
    }
    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserConstants.KEY_USER_NAME, user.getUserName());//name
        values.put(UserConstants.KEY_PASSWORD,user.getPassword());//phoneNumber
        db.insert(TBL_USER,null,values);
        db.close();

    }
    public int checkUserIsThereOrNot(String name, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TBL_USER, new String[] {
                        UserConstants.KEY_USER_NAME,UserConstants.KEY_PASSWORD },  UserConstants.KEY_USER_NAME +"=?" +" AND " + UserConstants.KEY_PASSWORD +"=?",
                new String[] { name,password }, null, null, null, null);
        if (cursor != null&& cursor.getCount()>0){

            return cursor.getCount();

        }
        return 0;


    }



}
