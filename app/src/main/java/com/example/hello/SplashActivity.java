package com.example.hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;

public class SplashActivity extends Activity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this, ListDisplay.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
