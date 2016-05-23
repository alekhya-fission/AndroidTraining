package com.fisstion.sample.shownamesusinglistview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button loginButton;
    private EditText edtName,edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName=(EditText)findViewById(R.id.edtUserName);
        edtPassword=(EditText)findViewById(R.id.edtPassword);
        loginButton=(Button)findViewById(R.id.btn_Login);
   /*  final String userName=edtName.getText().toString();
        final String PassWord=edtPassword.getText().toString();*/

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtName.getText().toString().length()==0){
                   Toast.makeText(getApplicationContext(),"please enter username",Toast.LENGTH_SHORT).show();
                }
                else if(edtPassword.getText().toString().length()==0){
                    Toast.makeText(getApplicationContext(),"please enter password",Toast.LENGTH_SHORT).show();
                }
                else{
                   /* String displayString =  edtName.getText().toString() +
                                                  "' username '" + edtPassword.getText().toString() + "' as password";
                    Toast.makeText(getApplicationContext(),displayString,Toast.LENGTH_SHORT).show();
*/

                   /* Toast msg = Toast.makeText(getBaseContext(), displayString,
                            Toast.LENGTH_LONG);

                    msg.show();*/
                    /*showMessage(edtName);
                    showMessage(edtPassword);
*/
                    printMessage(edtName.getText().toString());
                    printMessage(edtPassword.getText().toString());
                }

            }
        });

    }
   /* public void showMessage(EditText name){
        String showString=name.getText().toString();
        Toast.makeText(getApplicationContext(),showString,Toast.LENGTH_SHORT).show();


    }
*/
    public void printMessage(String value){
        Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
    }


}
