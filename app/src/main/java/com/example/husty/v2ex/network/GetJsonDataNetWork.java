package com.example.husty.v2ex.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by HUSTy on 2016/12/1.
 */

public class GetJsonDataNetWork {
    public String getStringData(String url){
        HttpURLConnection connection = null;
        URL mUrl;
        StringBuilder respone=new StringBuilder();
        try {
            mUrl = new URL(url);
            connection=(HttpURLConnection)mUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            InputStream in=connection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            String line;
            while((line=reader.readLine())!=null){
                line=line+"\n";
                respone.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return respone.toString();
    }
}
