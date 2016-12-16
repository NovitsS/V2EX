package com.example.husty.v2ex.thread;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.husty.v2ex.fragment.Fragment0;
import com.example.husty.v2ex.fragment.Fragment1;
import com.example.husty.v2ex.fragment.Fragment2;
import com.example.husty.v2ex.fragment.Fragment3;
import com.example.husty.v2ex.fragment.ItemFragment1;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by HUSTy on 2016/12/2.
 */

public class GetBitmapThread implements Runnable{
    int position,sign;
    public GetBitmapThread(int position,int sign){
        this.position=position;
        this.sign=sign;
    }
    @Override
    public void run() {
        URL url=null;
        HttpURLConnection conn = null;
        InputStream inStream = null;
        Bitmap bitmap;
            switch (sign){
                case 0:
                    try {
                        url = new URL("https:" + Fragment0.itemList.get(position).getMember().getAvatar_mini());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                    try {
                        conn = (HttpURLConnection) url.openConnection();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    conn.setConnectTimeout(5000);
                    try {
                        conn.setRequestMethod("GET");
                    } catch (ProtocolException e) {
                        e.printStackTrace();
                    }
                    try {
                        inStream = conn.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    bitmap = BitmapFactory.decodeStream(inStream);
                    Fragment0.itemList.get(position).setBitmap(bitmap);
                    break;
                case 1:
                    try {
                        url = new URL("https:" + Fragment1.itemList.get(position).getMember().getAvatar_mini());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    try {
                        conn = (HttpURLConnection) url.openConnection();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    conn.setConnectTimeout(5000);
                    try {
                        conn.setRequestMethod("GET");
                    } catch (ProtocolException e) {
                        e.printStackTrace();
                    }
                    try {
                        inStream = conn.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    bitmap = BitmapFactory.decodeStream(inStream);
                    Fragment1.itemList.get(position).setBitmap(bitmap);
                    break;
                case 2:
                    try {
                        url = new URL("https:"+Fragment2.itemList.get(position).getBitmapUrl());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    try {
                        conn = (HttpURLConnection) url.openConnection();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    conn.setConnectTimeout(5000);
                    try {
                        conn.setRequestMethod("GET");
                    } catch (ProtocolException e) {
                        e.printStackTrace();
                    }
                    try {
                        inStream = conn.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    bitmap = BitmapFactory.decodeStream(inStream);
                    Fragment2.itemList.get(position).setBitmap(bitmap);
                    break;
                case 3:
                    try {
                        url = new URL("https:"+Fragment3.itemList.get(position).getBitmapUrl());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    try {
                        conn = (HttpURLConnection) url.openConnection();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    conn.setConnectTimeout(5000);
                    try {
                        conn.setRequestMethod("GET");
                    } catch (ProtocolException e) {
                        e.printStackTrace();
                    }
                    try {
                        inStream = conn.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    bitmap = BitmapFactory.decodeStream(inStream);
                    Fragment3.itemList.get(position).setBitmap(bitmap);
                    break;
                case 11:
                    try {
                        url = new URL("https:" + ItemFragment1.replyItemList.get(position).getBitmapUrl());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    try {
                        conn = (HttpURLConnection) url.openConnection();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    conn.setConnectTimeout(5000);
                    try {
                        conn.setRequestMethod("GET");
                    } catch (ProtocolException e) {
                        e.printStackTrace();
                    }
                    try {
                        inStream = conn.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    bitmap = BitmapFactory.decodeStream(inStream);
                    ItemFragment1.replyItemList.get(position).setBitmap(bitmap);
                    break;
            }
    }
}
