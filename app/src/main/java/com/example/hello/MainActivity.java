package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Handler;

import static android.content.Context.ALARM_SERVICE;

public class MainActivity extends AppCompatActivity {

    // Class Project Build Up App by
    //MAATE MARTIN THAWITE  - 2017/BIT/094/PS

    ImageView imageView;

    Handler handler;

    ProgressBar progressBar;

    TextView magical;

    Boolean progressStatus = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(receive,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }


    private MyReceiver receive= new MyReceiver() {
        @Override
        public void onReceive(Context c, Intent i){
            int r=i.getIntExtra("level",0);
            ProgressBar bar=findViewById(R.id.progbar);
            bar.setProgress(r);
            TextView view =findViewById(R.id.view1);
            view.setText("charge the phone"+ Integer.toString(r)+"%");

        }

    };

    public void sendMessage(View view) {
        EditText message = (EditText) findViewById(R.id.Edit_message);
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent);
        message.setText("");
    }

    public void onClick(View view){
        EditText editText=findViewById(R.id.alarm);
        int b=Integer.parseInt(editText.getText().toString());
        Intent intent=new Intent(getApplicationContext(),MyReceiver.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this.getApplicationContext(),0,intent,0);
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(b*1000),pendingIntent);
        Toast.makeText(this,"alarm set in"+ b +"seconds",Toast.LENGTH_LONG).show();
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


            Intent intent2 = new Intent(Intent.ACTION_SEND);
            intent2.setData(Uri.parse("mailto:"));
            String to[] = {"maatemartin@gmail.com", "mugisha@gmail.com", "eddie@gmail.com"};
            intent2.putExtra(Intent.EXTRA_EMAIL, to);
            intent2.putExtra(Intent.EXTRA_SUBJECT, "Emergency");
            intent2.putExtra(Intent.EXTRA_TEXT, "Be ware that Coronavirus is real!");
            
            startActivity(intent2);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }








}



