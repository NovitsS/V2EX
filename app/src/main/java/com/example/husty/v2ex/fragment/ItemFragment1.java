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
import com.example.husty.v2ex.adapter.ItemRecyclerViewAdapter;
import com.example.husty.v2ex.adapter.ReplyRecyclerViewAdapter;
import com.example.husty.v2ex.parseHtml.ReplyItem;
import com.example.husty.v2ex.thread.GetBitmapThread;

import java.util.List;

/**
 * Created by HUSTy on 2016/12/3.
 */

public class ItemFragment1 extends Fragment {
    public static List<ReplyItem> replyItemList;
    private ReplyRecyclerViewAdapter madapter;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.item_fragment1,null);
        return view;
    }

    public void parseUrlToBitmap(){
        int length=replyItemList.size();
        for(int i=0;i<length;i++){
            GetBitmapThread getImage=new GetBitmapThread(i,11);
            Thread thread=new Thread(getImage);
            thread.start();
        }
    }

    public void initRecyclerView(){
        final Context context=getContext();
        recyclerView=(RecyclerView)this.getView().findViewById(R.id.item_recycler_new);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        madapter=new ReplyRecyclerViewAdapter(replyItemList,context);
        recyclerView.setAdapter(madapter);
    }
}
