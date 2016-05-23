package com.fisstion.sample.checkinguservalidations;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText userName,password;
    Button login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.edtUserName);
        password = (EditText) findViewById(R.id.edtPassWord);
        login = (Button) findViewById(R.id.loginBtn);
        register = (Button) findViewById(R.id.registerBtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().length() == 0) {
                    printToastMessage("please enter the username");

                } else if (password.getText().toString().length() == 0) {
                    printToastMessage("please enter the password");
                }
                else if(!(userName.getText().toString().equals(SignUpActivity.RegisterUserName))){
                    printToastMessage("userName is incorrect");

                }
                else if(!(password.getText().toString().equals(SignUpActivity.RegisterPassword))){
                    printToastMessage("password is incorrect");

                }

                /*else if(!(userName.getText().toString().equals(SignUpActivity.RegisterUserName))&&(!(password.getText().toString().equals(SignUpActivity.RegisterPassword)))){

                    printToastMessage("please Register");


                }*/



                else{

                    printToastMessage("you are Suceesfully Logined");
                }

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(i);

            }
        });


    }
    public void printToastMessage(String message){
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();

    }


}