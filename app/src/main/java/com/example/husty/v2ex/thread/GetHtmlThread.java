package com.example.husty.v2ex.thread;

import android.os.Handler;
import android.os.Message;

import com.example.husty.v2ex.network.GetHtmlDataNetWork;

/**
 * Created by HUSTy on 2016/12/3.
 */

public class GetHtmlThread implements Runnable{
    String mUrlString;
    String data;
    Handler handler;
    int sign=-1;
    public GetHtmlThread(String mUrlString,Handler handler){
        this.mUrlString=mUrlString;
        this.handler=handler;
    }

    public GetHtmlThread(String mUrlString,Handler handler,int sign){
        this.mUrlString=mUrlString;
        this.handler=handler;
        this.sign=sign;
    }


    @Override
    public void run() {
        if (sign == -1) {
            GetHtmlDataNetWork mNetWorkGetHtmlData = new GetHtmlDataNetWork();
            data = mNetWorkGetHtmlData.getHtmlData(mUrlString);
            Message msg = new Message();
            msg.what = 12;
            msg.obj = data;
            handler.sendMessage(msg);
        }else{
            GetHtmlDataNetWork mNetWorkGetHtmlData = new GetHtmlDataNetWork();
            data = mNetWorkGetHtmlData.getHtmlData(mUrlString);
            Message msg = new Message();
            msg.what = sign;
            msg.obj = data;
            handler.sendMessage(msg);
        }
    }
}
