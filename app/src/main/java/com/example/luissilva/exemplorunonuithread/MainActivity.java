package com.example.luissilva.exemplorunonuithread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void loadImg(View view){
        HelperDownloadImgWeb helperDownload = new HelperDownloadImgWeb(this);
        helperDownload.downloadImg((ImageView) findViewById(R.id.imgLoaded));
    }
}
