package com.fisstion.sample.lifecyclemethods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
       System.out.println("Second oncreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Second onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Second onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println(" Second onpause");
    }

    @Override
    protected   void onStop() {
        super.onStop();
        System.out.println("Second onstop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("Second onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Second onDestroy");
    }
}
