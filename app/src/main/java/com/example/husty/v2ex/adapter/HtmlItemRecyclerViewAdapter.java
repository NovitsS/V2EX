package com.example.husty.v2ex.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.husty.v2ex.R;
import com.example.husty.v2ex.parseHtml.HtmlItem;

import java.util.List;

/**
 * Created by HUSTy on 2016/12/4.
 */

public class HtmlItemRecyclerViewAdapter extends RecyclerView.Adapter<HtmlItemRecyclerViewAdapter.HtmlItemViewHolder>
                                        implements View.OnClickListener{
    private List<HtmlItem> mItemArrayList;
    private Context mContext;
    private String nodeTitle;
    private OnItemClickListener mListener;


    public HtmlItemRecyclerViewAdapter(List<HtmlItem> itemArrayList, Context context,String nodeTitle) {
        this.mItemArrayList = itemArrayList;
        this.mContext = context;
        this.nodeTitle=nodeTitle;
    }
    @Override
    public HtmlItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recyclerview, parent, false);
        HtmlItemViewHolder mItemViewHolder=new HtmlItemViewHolder(view);
        return mItemViewHolder;
    }

    @Override
    public void onBindViewHolder(HtmlItemViewHolder holder, int position) {
        HtmlItem item=mItemArrayList.get(position);
        holder.mNodeTitle.setText(nodeTitle);
        holder.mItemTitle.setText(item.getTitle());
        holder.memberAvatar.setImageBitmap(item.getBitmap());
        holder.mItemTitle.setOnClickListener(this);
        holder.mItemTitle.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mItemArrayList.size();
    }

    @Override
    public void onClick(View v) {
        if(mListener!=null)
            mListener.onItemClickListener(v,(Integer) v.getTag());
    }

    static class HtmlItemViewHolder extends RecyclerView.ViewHolder{
        ImageView memberAvatar;
        TextView mItemTitle,mNodeTitle;
        public HtmlItemViewHolder(View itemView) {
            super(itemView);
            memberAvatar=(ImageView)itemView.findViewById(R.id.member_avatar_mini);
            mItemTitle=(TextView)itemView.findViewById(R.id.item_title);
            mNodeTitle=(TextView)itemView.findViewById(R.id.node_title);
        }
    }
    public static  interface OnItemClickListener{
        public void onItemClickListener(View view,int position);
    }

    public void setOnItemClickListener(HtmlItemRecyclerViewAdapter.OnItemClickListener listener){
        this.mListener=listener;
    }
}
