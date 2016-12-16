package com.example.husty.v2ex.parseHtml;

import android.graphics.Bitmap;

/**
 * Created by HUSTy on 2016/12/3.
 */

public class ReplyItem {
    String bitmapUrl;
    String userName;
    Bitmap bitmap;
    String content;

    public void setBitmapUrl(String bitmapUrl) {
        this.bitmapUrl = bitmapUrl;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public String getBitmapUrl() {
        return bitmapUrl;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public String getContent() {
        return content;
    }
}
