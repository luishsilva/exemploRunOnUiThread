package com.example.luissilva.exemplorunonuithread;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by luissilva on 29/11/17.
 */

public class HelperDownloadImgWeb {

    private static Activity mActivity;
    private static Bitmap img;

    public HelperDownloadImgWeb(Activity pActivity) {
        this.mActivity = pActivity;
    }

    public void downloadImg(final ImageView pImageView){
        new Thread(){
            public void run(){
                try{
                    URL url = new URL(StringConstants.URL_IMG);
                    HttpURLConnection conection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = conection.getInputStream();
                    img = BitmapFactory.decodeStream(inputStream);

                }catch(IOException e){
                    e.printStackTrace();
                }

                mActivity.runOnUiThread(new Runnable(){

                    @Override
                    public void run() {
                        pImageView.setImageBitmap(img);
                    }
                });

            }
        }.start();
    }

}
