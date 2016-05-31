package com.fisstion.sample.checkinguservalidations;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText userName,password;
    Button login,register;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.edtUserName);
        password = (EditText) findViewById(R.id.edtPassWord);
        login = (Button) findViewById(R.id.loginBtn);
        register = (Button) findViewById(R.id.registerBtn);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
       /* final String userRegName=sharedpreferences.getString(AppConstants.KEY_REG_USER_NAME,null);
        final String RegPassword=sharedpreferences.getString(AppConstants.KEY_REG_PASSWORD,null);*/
        final String sharedUserName=sharedpreferences.getString(AppConstants.KEY_REG_USER_NAME,null);
        final String shredPassword =sharedpreferences.getString(AppConstants.KEY_REG_PASSWORD,null);
        if(sharedUserName==null){
            Intent i=new Intent(getApplicationContext(),SignUpActivity.class);
            startActivity(i);
            finish();

        }
        if(!(sharedUserName==null)){
            register.setVisibility(View.GONE);
        }
        System.out.println("sharedUserName"+sharedUserName);
        System.out.println("sharedPassword"+shredPassword);

       /* SharedPreferences preferences=getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        final String userRegName=preferences.getString(null,KEY_REG_USER_NAME);
        final String RegPassword=preferences.getString("KEY_REG_PASSWORD",null);*/
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginUserName=userName.getText().toString();
                String loginPassword=password.getText().toString();


                if (loginUserName==null||loginUserName.length()==0) {
                    userName.setError("please enter the username");

                } else if (loginPassword==null||loginPassword.length()==0) {
                    password.setError("please enter the password");
                }
                else if(sharedUserName!=null&&!loginUserName.equals(sharedUserName)){
                    userName.setError("username is incorrect");

                }
                else if(shredPassword!=null&&!loginPassword.equals(shredPassword)){
                  password.setError("password is incorrect");

                }






                /*else if(!(userName.getText().toString().equals(SignUpActivity.RegisterUserName))&&(!(password.getText().toString().equals(SignUpActivity.RegisterPassword)))){

                    printToastMessage("please Register");


                }*/



                else{

                    printToastMessage("you are Suceesfully Logined");
                   /* Log.d(userRegName, "userName");
                    Log.d(RegPassword,"password");*/
                    System.out.println("username"+sharedUserName);
                    System.out.println("password"+shredPassword);

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