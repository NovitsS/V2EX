package com.example.husty.v2ex.parseHtml;

import android.graphics.Bitmap;

/**
 * Created by HUSTy on 2016/12/3.
 */

public class HtmlItem {
    String title;
    String bitmapUrl;
    String url;
    Bitmap bitmap;
    String username;

    public String getTitle() {
        return title;
    }

    public String getBitmapUrl() {
        return bitmapUrl;
    }

    public String getUrl() {
        return url;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBitmapUrl(String bitmapUrl) {
        this.bitmapUrl = bitmapUrl;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
