package com.example.husty.v2ex.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.husty.v2ex.R;
import com.example.husty.v2ex.activity.ItemActivity;
import com.example.husty.v2ex.activity.MainActivity;
import com.example.husty.v2ex.adapter.HtmlItemRecyclerViewAdapter;
import com.example.husty.v2ex.parseHtml.HtmlItem;
import com.example.husty.v2ex.thread.GetBitmapThread;
import com.example.husty.v2ex.thread.GetHtmlThread;

import java.util.List;

/**
 * Created by HUSTy on 2016/12/1.
 */

public class Fragment2 extends Fragment {
    private RecyclerView recyclerView;
    public static List<HtmlItem> itemList=null;
    private HtmlItemRecyclerViewAdapter madapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_layout2,null);
        GetHtmlThread getHtmlThread=new GetHtmlThread("https://www.v2ex.com/?tab=apple", MainActivity.handler,2);
        Thread thread=new Thread(getHtmlThread);
        thread.start();
        return view;
    }

    public void initRecyclerView(){
        final Context context=getContext();
        recyclerView=(RecyclerView)this.getView().findViewById(R.id.recyclerview_fragment2);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        madapter=new HtmlItemRecyclerViewAdapter(itemList,context,"来自：apple");
        madapter.setOnItemClickListener(new HtmlItemRecyclerViewAdapter.OnItemClickListener(){

            @Override
            public void onItemClickListener(View view, int position) {
                Intent intent=new Intent(context, ItemActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("sign",2);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(madapter);
    }
    public void parseUrlToBitmap(){
        int length=itemList.size();
        for(int i=0;i<length;i++){
            GetBitmapThread getImage=new GetBitmapThread(i,2);
            Thread thread=new Thread(getImage);
            thread.start();
        }
    }
}
