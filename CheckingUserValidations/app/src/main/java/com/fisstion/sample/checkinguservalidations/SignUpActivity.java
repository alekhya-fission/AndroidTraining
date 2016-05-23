package com.fisstion.sample.checkinguservalidations;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends Activity {
    EditText registerUserName,registerPassword,registerConfirmPassword;
    Button signUp;
    public static String RegisterUserName=" ";
    public static String RegisterPassword=" ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        registerUserName=(EditText)findViewById(R.id.edtRegUserName);
        registerPassword=(EditText)findViewById(R.id.edtRegPassword);
        registerConfirmPassword=(EditText)findViewById(R.id.edtRegConfirmPassword);
        signUp=(Button)findViewById(R.id.signUpBtn);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(registerUserName.getText().toString().length()==0){
                    printToastMessage("please enter username");

                }
                else if(registerPassword.getText().toString().length()==0){
                    printToastMessage("please enter Password");

                }
                else if(registerConfirmPassword.getText().toString().length()==0){
                    printToastMessage("please enter ConfirmPassword");

                }
                else if(!(registerPassword.getText().toString().equals(registerConfirmPassword.getText().toString()))){
                    printToastMessage("password and confirm password shuld be equal");

                }
                else {
                    RegisterUserName=registerUserName.getText().toString();
                    RegisterPassword=registerPassword.getText().toString();
                    printToastMessage("detailes are sucessfully inserted");


                }







            }
        });






    }
    public void printToastMessage(String message){
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();

    }

}
