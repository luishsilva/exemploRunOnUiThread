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

    private static Activity mActivity; // activity where the image will be showed
    private static Bitmap img; // Element to the interface where image will be loaded

    public HelperDownloadImgWeb(Activity pActivity) {
        this.mActivity = pActivity;
    }

    public void downloadImg(final ImageView pImageView){
        // This thread has been created because we can't use the HttpURLConnection directly on the main thread
        new Thread(){
            public void run(){
                try{
                    // This class and functions will work to load the image
                    URL url = new URL(StringConstants.URL_IMG);
                    HttpURLConnection conection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = conection.getInputStream();
                    img = BitmapFactory.decodeStream(inputStream);

                }catch(IOException e){
                    e.printStackTrace();
                }

                // this method allow us to access and show the imageView
                mActivity.runOnUiThread(new Runnable(){

                    @Override
                    public void run() {
                        //
                        pImageView.setImageBitmap(img);
                    }
                });

            }
        }.start();
    }

}
