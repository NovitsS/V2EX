package com.example.husty.v2ex.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.husty.v2ex.R;

/**
 * Created by HUSTy on 2016/12/3.
 */

public class ItemFragment0 extends Fragment {
    TextView itemTitle,itemTime,itemNodeTitle,itemDian,itemContent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.item_fragment0,null);
        itemTitle=(TextView) view.findViewById(R.id.item_title_new);
        itemNodeTitle=(TextView)view.findViewById(R.id.item_nodetitle_new);
        itemContent=(TextView)view.findViewById(R.id.item_content_new);
        itemTime=(TextView)view.findViewById(R.id.item_time);
        itemDian = (TextView) view.findViewById(R.id.item_dianji);
        return view;
    }

    public void setItemTitle(String data) {
        this.itemTitle.setText(data);
    }

    public void setItemTime(String data) {
        this.itemTime.setText(data);
    }

    public void setItemNodeTitle(String data) {
        this.itemNodeTitle.setText(data);
    }

    public void setItemDian(String data) {
        this.itemDian.setText(data);
    }

    public void setItemContent(String data) {
        this.itemContent.setText(data);
    }
}
