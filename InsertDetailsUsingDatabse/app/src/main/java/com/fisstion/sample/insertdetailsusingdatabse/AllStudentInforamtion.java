package com.fisstion.sample.insertdetailsusingdatabse;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by alekhya on 1/6/16.
 */
public class AllStudentInforamtion extends Activity {
    ListView mListView;
    //creating the arraylist and passed student object
    ArrayList<Student>studentList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_student_information);
        mListView=(ListView)findViewById(R.id.lvStudentList);
        StudentInformation studentInformation1=new StudentInformation(getApplicationContext());
        studentList=studentInformation1.getAllContacts();
        //own adapter student
        StudentData studentData=new StudentData(this,studentList);
        mListView.setAdapter(studentData);




        }











    }






