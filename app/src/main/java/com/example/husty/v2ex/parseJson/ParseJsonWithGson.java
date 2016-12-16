package com.example.husty.v2ex.parseJson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by HUSTy on 2016/12/1.
 */

public class ParseJsonWithGson {
    public static ArrayList<Item> parseJson(String data){
        Gson gson=new Gson();
        ArrayList<Item> itemList=gson.fromJson(data,new TypeToken<ArrayList<Item>>(){}.getType());
        return itemList;
    }
}
