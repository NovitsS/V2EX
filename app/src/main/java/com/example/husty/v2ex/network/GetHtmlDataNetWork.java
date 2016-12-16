package com.example.husty.v2ex.network;

import com.example.husty.v2ex.parseHtml.StramTool;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by HUSTy on 2016/12/3.
 */

public class GetHtmlDataNetWork {
    public String getHtmlData(String url){
        URL mUrl= null;
        String html="";
        try {
            mUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection conn=(HttpURLConnection)mUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(8000);
            InputStream in=conn.getInputStream();
            html = StramTool.inToStringByByte(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return html;
    }
}
