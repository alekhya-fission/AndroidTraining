package com.fisstion.sample.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    String msg="welcome to the android";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg,"oncreate");

    }

     @Override
    protected void onStart(){
         super.onStart();
         Log.d(msg,"onStart");

   }


    @Override
    protected void onResume(){
        super.onResume();
        Log.d(msg,"onResume");

    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(msg,"onPause");

    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(msg,"onStop");

    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(msg,"onRestart");

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();//why we call the super.onstart

        Log.d(msg,"onDestroy");

    }











}
