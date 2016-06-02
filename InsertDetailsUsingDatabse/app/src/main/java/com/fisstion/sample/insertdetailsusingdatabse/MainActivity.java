package com.fisstion.sample.insertdetailsusingdatabse;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText mEdtStuName,mEdtStuPhoneNumber,mEdtStuBranch;
    Button mBtnInsert,mBtnShowAll,mBtnDelete,mBtnShowOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdtStuName=(EditText)findViewById(R.id.edtStuName);
        mEdtStuBranch=(EditText)findViewById(R.id.edtStuBranch);
        mEdtStuPhoneNumber=(EditText)findViewById(R.id.edtStuPhoneNumber);
        mBtnInsert=(Button)findViewById(R.id.insertBtn);
        mBtnShowAll=(Button)findViewById(R.id.ShowAllBtn) ;
        mBtnDelete=(Button)findViewById(R.id.DeleteBtn);
        mBtnShowOne=(Button)findViewById(R.id.ShowOneBtn);

        mBtnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stuName=mEdtStuName.getText().toString();
                String stuBranch=mEdtStuBranch.getText().toString();
                String stuPhoneNumber=mEdtStuPhoneNumber.getText().toString();
                if(TextUtils.isEmpty(stuName)){
                    printToastMessage("please enter the studentName");
                }
                else if(TextUtils.isEmpty(stuBranch)){
                    printToastMessage("please enter the studentBranch");
                }
                else if(TextUtils.isEmpty(stuPhoneNumber)){
                    printToastMessage("please enter the phone number");
                }
                else{
                    StudentInformation studentInformation=new StudentInformation(getApplicationContext());
                    Student student=new Student(stuName,stuBranch,stuPhoneNumber);
                    studentInformation.addStudent(student);
                    mEdtStuName.setText("");
                    mEdtStuPhoneNumber.setText("");
                    mEdtStuBranch.setText("");
                    printToastMessage("the data is sucessfully ");

                }


            }
        });
        mBtnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),AllStudentInforamtion.class);
                startActivity(i);


            }
        });



        mBtnShowOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.show_dialog);
                dialog.setTitle("Title...");
                final EditText mEdtAddDialog = (EditText) dialog.findViewById(R.id.edtShowDialog);

                Button dialogAddButton = (Button) dialog.findViewById(R.id.btnAdd);

                dialogAddButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String addName = mEdtAddDialog.getText().toString();
                        if (TextUtils.isEmpty(addName)) {
                            printToastMessage("please enter the name to the Add");
                        } else {
                            StudentInformation studentInformation = new StudentInformation(getApplicationContext());
                            Student name=studentInformation.getStudent(addName);
                            String details = name.getStuName()+"-"+name.getStuPhoneNumber()+"-"+name.stuBranch;
                            printToastMessage(details);
                        }


                    }
                });

                dialog.show();




            }
        });

        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.delete_dialog);
                dialog.setTitle("Title...");
                final EditText mEdtDeleteDialog = (EditText) dialog.findViewById(R.id.edtDeleteDialog);

                Button dialogButtonDelete = (Button) dialog.findViewById(R.id.btnDelete);

                dialogButtonDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String deleteName = mEdtDeleteDialog.getText().toString();
                        if (TextUtils.isEmpty(deleteName)) {
                            printToastMessage("please enter the name to the delete");
                        } else {
                            StudentInformation studentInformation = new StudentInformation(getApplicationContext());
                            studentInformation.deleteContact(deleteName);
                            printToastMessage("your details are deleted sucessfully");

                        }


                    }
                });

                dialog.show();


            }
        });





    }
    public void printToastMessage(String message){
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();

    }
}
