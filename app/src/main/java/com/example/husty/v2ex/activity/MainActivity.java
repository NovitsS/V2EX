package com.example.husty.v2ex.activity;

import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.husty.v2ex.R;
import com.example.husty.v2ex.adapter.ViewPagerAdapter;
import com.example.husty.v2ex.fragment.Fragment0;
import com.example.husty.v2ex.fragment.Fragment1;
import com.example.husty.v2ex.fragment.Fragment2;
import com.example.husty.v2ex.fragment.Fragment3;
import com.example.husty.v2ex.parseHtml.JsoupParseString;
import com.example.husty.v2ex.parseJson.ParseJsonWithGson;

public class MainActivity extends AppCompatActivity {
    Toolbar mToolbar;
    ViewPager mViewPager;
    TabLayout mTabLayout;
    static Fragment0 fragment0;
    static Fragment1 fragment1;
    static Fragment2 fragment2;
    static Fragment3 fragment3;
    public static Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String string1=(String)msg.obj;
                    Fragment0.itemList= ParseJsonWithGson.parseJson(string1);
                    fragment0.parseUrlToBitmap();
                    Handler denyHandler0=new Handler();
                    denyHandler0.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            fragment0.initRecyclerView();
                        }
                    },500);
                    break;
                case 1:
                    String string2=(String)msg.obj;
                    Fragment1.itemList=ParseJsonWithGson.parseJson(string2);
                    fragment1.parseUrlToBitmap();
                    Handler denyHandler1=new Handler();
                    denyHandler1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            fragment1.initRecyclerView();
                        }
                    },500);
                    break;
                case 2:
                    String string3=(String)msg.obj;
                    JsoupParseString jsoupParseString=new JsoupParseString();
                    Fragment2.itemList=jsoupParseString.parseStringToItem(string3);
                    fragment2.parseUrlToBitmap();
                    Handler denyHandler2=new Handler();
                    denyHandler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            fragment2.initRecyclerView();
                        }
                    },500);
                    break;
                case 3:
                    String string4=(String)msg.obj;
                    JsoupParseString jsoupParseString1=new JsoupParseString();
                    Fragment3.itemList=jsoupParseString1.parseStringToItem(string4);
                    fragment3.parseUrlToBitmap();
                    Handler denyHandler3=new Handler();
                    denyHandler3.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            fragment3.initRecyclerView();
                        }
                    },500);
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar=(Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle("V2EX");
        setSupportActionBar(mToolbar);

        mViewPager=(ViewPager)findViewById(R.id.viewpager);
        mTabLayout=(TabLayout)findViewById(R.id.tab_layout);

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        fragment0=new Fragment0();
        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();
        adapter.addFragment(fragment0,"最热");
        adapter.addFragment(fragment1,"最新");
        adapter.addFragment(fragment2,"Apple");
        adapter.addFragment(fragment3,"酷工作");
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
