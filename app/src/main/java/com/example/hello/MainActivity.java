package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    // hello world sample application by
    //MAATE MARTIN THAWITE  - 2017/BIT/094/PS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menuone, menu);

        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_three) {
            Intent myintent = new Intent(this, three.class);
            this.startActivity(myintent);
            return true;
        }

        if (id == R.id.menu_four) {
            Intent myintent = new Intent(this, four.class);
            this.startActivity(myintent);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}



