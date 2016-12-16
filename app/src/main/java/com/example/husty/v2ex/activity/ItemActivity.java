package com.example.husty.v2ex.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.husty.v2ex.R;
import com.example.husty.v2ex.adapter.ViewPagerAdapter;
import com.example.husty.v2ex.fragment.Fragment0;
import com.example.husty.v2ex.fragment.Fragment1;
import com.example.husty.v2ex.fragment.Fragment2;
import com.example.husty.v2ex.fragment.Fragment3;
import com.example.husty.v2ex.fragment.ItemFragment0;
import com.example.husty.v2ex.fragment.ItemFragment1;
import com.example.husty.v2ex.parseHtml.HtmlItem;
import com.example.husty.v2ex.parseHtml.ItemConcreteData;
import com.example.husty.v2ex.parseHtml.JsoupParseString;
import com.example.husty.v2ex.parseHtml.ReplyItem;
import com.example.husty.v2ex.parseJson.Item;
import com.example.husty.v2ex.thread.GetHtmlThread;
import com.example.husty.v2ex.thread.GetItemBitmapThread;

import java.util.List;

/**
 * Created by HUSTy on 2016/12/3.
 */

public class ItemActivity extends AppCompatActivity {
    ImageView imageView;
    TextView mItemTitle,mItemContent,mItemUserName,mItemTagLine;
    Toolbar mItemToolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    ViewPager viewPager;
    TabLayout tabLayout;
    Item item;
    HtmlItem htmlItem;
    ItemFragment0 fragment0;
    ItemFragment1 fragment1;
    ViewPagerAdapter adapter;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 11:
                    Bitmap bitmap=(Bitmap)msg.obj;
                    imageView.setImageBitmap(bitmap);
                    break;
                case 12:
                    String data=(String)msg.obj;
                    JsoupParseString jsoupParseString=new JsoupParseString();
                    ItemFragment1.replyItemList=jsoupParseString.parseString(data);
                    ItemConcreteData concreteData=jsoupParseString.parseStringToConcreteItem(data);
                    fragment0.setItemTitle(concreteData.getTitle());
                    fragment0.setItemContent(concreteData.getContent());
                    fragment0.setItemTime(concreteData.getTime());
                    fragment0.setItemNodeTitle(concreteData.getSign());
                    fragment1.parseUrlToBitmap();
                    fragment1.initRecyclerView();
                    break;

            }
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_new);
        imageView=(ImageView)findViewById(R.id.item_avatar_new);
        //mItemTitle=(TextView)findViewById(R.id.item_title);
        //mItemContent=(TextView)findViewById(R.id.item_content_concrete);
        mItemUserName=(TextView)findViewById(R.id.item_username);
        mItemTagLine=(TextView)findViewById(R.id.item_tagline);
        mItemToolbar=(Toolbar)findViewById(R.id.toolbar_new);
        collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsing_appbar_new);
        collapsingToolbarLayout.setTitle(" ");
        mItemToolbar.setTitle(" ");
        setSupportActionBar(mItemToolbar);
        Bundle bundle=getIntent().getExtras();
        int position=(Integer) bundle.get("position");
        int sign=(Integer)bundle.get("sign");
        String bitmapUrl;
        GetItemBitmapThread getItemBitmapThread;
        Thread thread,thread1;
        GetHtmlThread getHtmlThread;
        String itemUrlString, mHttpsUrl;
        switch (sign){
            case 0:
                item= Fragment0.itemList.get(position);
                mItemUserName.setText(" "+item.getMember().getUsername());
                mItemTagLine.setText(" "+item.getMember().getTagline());
                bitmapUrl=item.getMember().getAvatar_normal();
                getItemBitmapThread=new GetItemBitmapThread(bitmapUrl,handler);
                thread=new Thread(getItemBitmapThread);
                thread.start();
                itemUrlString=item.getUrl();
                mHttpsUrl=itemUrlString.replaceAll("http","https");
                getHtmlThread=new GetHtmlThread(mHttpsUrl,handler);
                thread1=new Thread(getHtmlThread);
                thread1.start();
                viewPager=(ViewPager)findViewById(R.id.viewpager_item);
                tabLayout=(TabLayout)findViewById(R.id.tab_layout_new);
                adapter=new ViewPagerAdapter(getSupportFragmentManager());
                fragment0=new ItemFragment0();
                fragment1=new ItemFragment1();
                adapter.addFragment(fragment0,"正文");
                adapter.addFragment(fragment1,"评论");
                viewPager.setAdapter(adapter);
                tabLayout.setupWithViewPager(viewPager);
                break;
            case 1:
                item= Fragment1.itemList.get(position);
                mItemUserName.setText(" "+item.getMember().getUsername());
                mItemTagLine.setText(" "+item.getMember().getTagline());
                bitmapUrl=item.getMember().getAvatar_normal();
                getItemBitmapThread=new GetItemBitmapThread(bitmapUrl,handler);
                thread=new Thread(getItemBitmapThread);
                thread.start();
                itemUrlString=item.getUrl();
                mHttpsUrl=itemUrlString.replaceAll("http","https");
                getHtmlThread=new GetHtmlThread(mHttpsUrl,handler);
                thread1=new Thread(getHtmlThread);
                thread1.start();
                viewPager=(ViewPager)findViewById(R.id.viewpager_item);
                tabLayout=(TabLayout)findViewById(R.id.tab_layout_new);
                adapter=new ViewPagerAdapter(getSupportFragmentManager());
                fragment0=new ItemFragment0();
                fragment1=new ItemFragment1();
                adapter.addFragment(fragment0,"正文");
                adapter.addFragment(fragment1,"评论");
                viewPager.setAdapter(adapter);
                tabLayout.setupWithViewPager(viewPager);
                break;
            case 2:
                htmlItem= Fragment2.itemList.get(position);
                mItemUserName.setText(" "+htmlItem.getUsername());
                bitmapUrl=htmlItem.getBitmapUrl();
                mHttpsUrl=bitmapUrl.replaceAll("normal","large");
                getItemBitmapThread=new GetItemBitmapThread(mHttpsUrl,handler);
                thread=new Thread(getItemBitmapThread);
                thread.start();
                itemUrlString=htmlItem.getUrl();
                getHtmlThread=new GetHtmlThread(itemUrlString,handler);
                thread1=new Thread(getHtmlThread);
                thread1.start();
                viewPager=(ViewPager)findViewById(R.id.viewpager_item);
                tabLayout=(TabLayout)findViewById(R.id.tab_layout_new);
                adapter=new ViewPagerAdapter(getSupportFragmentManager());
                fragment0=new ItemFragment0();
                fragment1=new ItemFragment1();
                adapter.addFragment(fragment0,"正文");
                adapter.addFragment(fragment1,"评论");
                viewPager.setAdapter(adapter);
                tabLayout.setupWithViewPager(viewPager);
                break;
            case 3:
                htmlItem= Fragment3.itemList.get(position);
                mItemUserName.setText(" "+htmlItem.getUsername());
                bitmapUrl=htmlItem.getBitmapUrl();
                mHttpsUrl=bitmapUrl.replaceAll("normal","large");
                getItemBitmapThread=new GetItemBitmapThread(mHttpsUrl,handler);
                thread=new Thread(getItemBitmapThread);
                thread.start();
                itemUrlString=htmlItem.getUrl();
                getHtmlThread=new GetHtmlThread(itemUrlString,handler);
                thread1=new Thread(getHtmlThread);
                thread1.start();
                viewPager=(ViewPager)findViewById(R.id.viewpager_item);
                tabLayout=(TabLayout)findViewById(R.id.tab_layout_new);
                adapter=new ViewPagerAdapter(getSupportFragmentManager());
                fragment0=new ItemFragment0();
                fragment1=new ItemFragment1();
                adapter.addFragment(fragment0,"正文");
                adapter.addFragment(fragment1,"评论");
                viewPager.setAdapter(adapter);
                tabLayout.setupWithViewPager(viewPager);
                break;
        }
    }
}
