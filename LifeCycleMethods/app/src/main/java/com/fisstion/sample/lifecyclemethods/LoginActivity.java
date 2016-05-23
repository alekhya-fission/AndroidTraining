package com.fisstion.sample.lifecyclemethods;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    Button navigationbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("first oncreate");
        setContentView(R.layout.activity_main);
      navigationbtn=(Button)findViewById(R.id.navigation_button);
        navigationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(i);

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("first onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("first onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("first onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("first onstop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("first onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("first onDestroy");
    }
}

