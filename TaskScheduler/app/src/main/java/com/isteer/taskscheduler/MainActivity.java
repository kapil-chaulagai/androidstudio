package com.isteer.taskscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(5000,1000){

            @Override
            public void onTick(long l) {
                Log.d("lpg","onTick: I am Hero!!");
            }

            @Override
            public void onFinish() {
                Log.d("finish","onFinish: Khatam!!");
            }
        }.start();
    }
}