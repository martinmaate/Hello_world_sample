package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class handler extends AppCompatActivity {


    ImageView imageView;

    Handler handler;

    ProgressBar progressBar;

    TextView must_logo;

    Boolean progressStatus = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        imageView = findViewById(R.id.image);

        must_logo = findViewById(R.id.magic);

        progressBar = findViewById(R.id.progressbar);



        handler = new Handler() {




            public void handleMessage(Message msg) {

                progressStatus = false;

                Object obj = msg.getData().getParcelable("MyObject");

                imageView.setImageBitmap((Bitmap) obj);

                imageView.setVisibility(View.VISIBLE);



            }

        };

    }



    public void downloadImage(View view) {

        Log.i("Button", "Tapped");

        progressStatus = true;



        DownloadImage downloadImage = new DownloadImage();

        new Thread(downloadImage).start();

    }

    class DownloadImage implements Runnable {

        @Override

        public void run() {

            URL url;

            HttpURLConnection httpURLConnection;

            Bitmap result = null;



            handler.post(new Runnable() {

                @Override

                public void run() {

                    if (progressStatus = true) {

                        must_logo.setText(" Loading ");

                        must_logo.setVisibility(View.VISIBLE);

                        progressBar.setVisibility(View.VISIBLE);




                    }

                }

            });



            try {

                url = new URL("https://www.must.ac.ug/wp-content/uploads/2018/08/must-site-logo11-1.png");

                httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.connect();

                InputStream in = httpURLConnection.getInputStream();

                result = BitmapFactory.decodeStream(in);

            } catch (MalformedURLException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            }



            Message message = handler.obtainMessage();

            Bundle bundle = new Bundle();

            bundle.putParcelable("MyObject", result);

            message.setData(bundle);

            handler.sendMessage(message);

        }

    }

    }

