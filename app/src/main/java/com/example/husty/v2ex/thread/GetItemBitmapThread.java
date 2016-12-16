package com.example.husty.v2ex.thread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by HUSTy on 2016/12/3.
 */

public class GetItemBitmapThread implements Runnable{
    private String url;
    private Handler mHandler;

    public GetItemBitmapThread(String url,Handler handler){
        this.mHandler=handler;
        this.url=url;
    }
    @Override
    public void run() {
        try {
            URL mUrl=new URL("https:"+url);
            HttpURLConnection conn= (HttpURLConnection) mUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(8000);
            InputStream in=conn.getInputStream();
            Bitmap bitmap= BitmapFactory.decodeStream(in);
            Message msg=new Message();
            msg.what=11;
            msg.obj=bitmap;
            mHandler.sendMessage(msg);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
