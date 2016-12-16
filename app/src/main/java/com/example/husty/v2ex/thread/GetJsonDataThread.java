package com.example.husty.v2ex.thread;

import android.os.Handler;
import android.os.Message;

import com.example.husty.v2ex.network.GetJsonDataNetWork;

/**
 * Created by HUSTy on 2016/12/1.
 */

public class GetJsonDataThread implements Runnable{
    int sign;
    Handler handler;
    String url;
    String stringDataOfJson=null;
    public GetJsonDataThread(int sign,Handler handler,String url){
        this.sign=sign;
        this.handler=handler;
        this.url=url;
    }
    @Override
    public void run() {
        GetJsonDataNetWork netWork=new GetJsonDataNetWork();
        stringDataOfJson=netWork.getStringData(url);
        Message msg=new Message();
        msg.what=sign;
        msg.obj=stringDataOfJson;
        handler.sendMessage(msg);
    }
}
