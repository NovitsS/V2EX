package com.example.husty.v2ex.parseHtml;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by HUSTy on 2016/12/3.
 */

public class StramTool {
    public static String inToStringByByte(InputStream in) throws IOException {
        ByteArrayOutputStream outStr=new ByteArrayOutputStream();
        byte[] buffer=new byte[1024];
        int len=0;
        StringBuilder content=new StringBuilder();
        while((len=in.read(buffer))!=-1){
            content.append(new String(buffer,0,len,"UTF-8"));
        }
        outStr.close();
        return content.toString();
    }
}
