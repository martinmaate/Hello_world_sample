package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class three extends AppCompatActivity {

    Button musicbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        musicbutton = (Button) findViewById(R.id.musicbutton);

        musicbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(three.this, R.raw.underdog);
                mediaPlayer.start();
            }
        });
    }
}



