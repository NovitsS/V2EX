package com.example.husty.v2ex.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.husty.v2ex.R;
import com.example.husty.v2ex.activity.ItemActivity;
import com.example.husty.v2ex.activity.MainActivity;
import com.example.husty.v2ex.adapter.ItemRecyclerViewAdapter;
import com.example.husty.v2ex.parseJson.Item;
import com.example.husty.v2ex.thread.GetBitmapThread;
import com.example.husty.v2ex.thread.GetJsonDataThread;
import java.util.List;


/**
 * Created by HUSTy on 2016/12/1.
 */

public class Fragment0 extends Fragment {
    private RecyclerView recyclerView;
    private SwipeRefreshLayout mSwipeLayout;
    public static List<Item> itemList=null;
    ItemRecyclerViewAdapter madapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_layout0,null);
        GetJsonDataThread getJsonDataThread=new GetJsonDataThread(0, MainActivity.handler,"https://www.v2ex.com/api/topics/hot.json");
        Thread thread=new Thread(getJsonDataThread);
        thread.start();
        return view;
    }

    public void initRecyclerView(){
        mSwipeLayout=(SwipeRefreshLayout)this.getView().findViewById(R.id.swipe_container);
        mSwipeLayout.setDistanceToTriggerSync(400);
        mSwipeLayout.setSize(SwipeRefreshLayout.LARGE);
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        GetJsonDataThread getJsonDataThread=new GetJsonDataThread(0, MainActivity.handler,"https://www.v2ex.com/api/topics/hot.json");
                        Thread thread=new Thread(getJsonDataThread);
                        mSwipeLayout.setRefreshing(false);
                    }
                },1000);
            }
        });
        final Context context=getContext();
        recyclerView=(RecyclerView)this.getView().findViewById(R.id.recyclerview_fragment0);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        madapter=new ItemRecyclerViewAdapter(itemList,context);
        madapter.setOnItemClickListener(new ItemRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Intent intent=new Intent(context, ItemActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("sign",0);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(madapter);
    }
    public void parseUrlToBitmap(){
        int length=itemList.size();
        for(int i=0;i<length;i++){
            GetBitmapThread getImage=new GetBitmapThread(i,0);
            Thread thread=new Thread(getImage);
            thread.start();
        }
    }
}
