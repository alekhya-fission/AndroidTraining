package com.fisstion.sample.insertdetailsusingdatabse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


/**
 * Created by alekhya on 31/5/16.
 */
public class StudentInformation extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "StudentsContactManager";
   // private static final String TABLE_CONTACTS = "contacts";
   private static final String TBL_STUDENT= "tbl_student_information";

    public StudentInformation(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creating the table
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TBL_STUDENT + "("
                 + StudentConstants.KEY_NAME + " TEXT PRIMARY KEY,"+StudentConstants.KEY_BRANCH_NAME + " TEXT,"
                + StudentConstants.KEY_PH_NO + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TBL_STUDENT );

        // Create tables again
        onCreate(db);

    }
    public void addStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(StudentConstants.KEY_NAME, student.getStuName());//name
        values.put(StudentConstants.KEY_PH_NO,student.getStuPhoneNumber());//phoneNumber
        values.put(StudentConstants.KEY_BRANCH_NAME,student.getStuBranch());//branchName
        db.insert(TBL_STUDENT,null,values);
        db.close();

    }
    Student getStudent(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TBL_STUDENT, new String[] {
                        StudentConstants.KEY_NAME, StudentConstants.KEY_PH_NO,StudentConstants.KEY_BRANCH_NAME }, StudentConstants.KEY_NAME + "=?",
                new String[] { name }, null, null, null, null);
        if (cursor != null&& cursor.getCount()>0){
            cursor.moveToFirst();
            Student student = new Student(cursor.getString(0),cursor.getString(1),cursor.getString(2));
            return student;

        }
        return null;


    }
    public void deleteContact(String sName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TBL_STUDENT, StudentConstants.KEY_NAME+ " = ?",
                new String[] {sName});
        db.close();
    }
    public ArrayList<Student> getAllContacts() {
        ArrayList<Student> contactList = new ArrayList<Student>();

        String selectQuery = "SELECT  * FROM " + TBL_STUDENT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student(cursor.getString(0),cursor.getString(1),cursor.getString(2));
                contactList.add(student);
            } while (cursor.moveToNext());
        }

        return contactList;
    }



}
