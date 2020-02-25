package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView textView=findViewById(R.id.textView2);
        AssetManager assetManager = getAssets();
        InputStream files;

        {
            try{
                files= assetManager.open("maate_program.c");

            } catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
