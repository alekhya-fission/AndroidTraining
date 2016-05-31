package com.fisstion.sample.checkinguservalidations;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends Activity {
    EditText registerUserName,registerPassword,registerConfirmPassword;
    Button signUp;
    public static final String MyPREFERENCES = "MyPrefs" ;
    //creating shared preference instance
    SharedPreferences sharedpreferences;
    //storing purpose
    private String sharedUserName=" ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        sharedUserName=sharedpreferences.getString(AppConstants.KEY_REG_USER_NAME,"");
        System.out.println("sharedUserName"+sharedUserName);
        registerUserName=(EditText)findViewById(R.id.edtRegUserName);
        registerPassword=(EditText)findViewById(R.id.edtRegPassword);
        registerConfirmPassword=(EditText)findViewById(R.id.edtRegConfirmPassword);
        signUp=(Button)findViewById(R.id.signUpBtn);



        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(registerUserName.getText().toString().length()==0){
                    registerUserName.setError("please enter the username");

                }
                else if(registerPassword.getText().toString().length()==0){
                    registerPassword.setError("please enter the password");

                }
                else if(registerConfirmPassword.getText().toString().length()==0){
                    registerConfirmPassword.setError("please enter the confirm password");

                }
                else if(!(registerPassword.getText().toString().equals(registerConfirmPassword.getText().toString()))){
                    registerPassword.setError("password and confirm password should be equal");

                }
                else if(sharedUserName!=null&&registerUserName.getText().toString().equals(sharedUserName)){
                    printToastMessage("the username is already taken registered with another username");
                }

                else {
                  /*  RegisterUserName=registerUserName.getText().toString();
                    RegisterPassword=registerPassword.getText().toString();
                    printToastMessage("detailes are sucessfully inserted");*/

                    String regName=registerUserName.getText().toString();
                    String regPassword=registerPassword.getText().toString();
                    //store the values using shared preferences Editor
                    SharedPreferences.Editor editor=sharedpreferences.edit();
                    editor.putString(AppConstants.KEY_REG_USER_NAME,regName);
                    editor.putString(AppConstants.KEY_REG_PASSWORD,regPassword);
                    editor.commit();

                  /*  sharedUserName=sharedpreferences.getString(AppConstants.KEY_REG_USER_NAME,null);
                 shredPassword =sharedpreferences.getString(AppConstants.KEY_REG_PASSWORD,null);
                    System.out.println("sharedUserName"+sharedUserName);*/
                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    finish();


                }


            }
        });




    }
        public void printToastMessage(String message){
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();

    }




    }
