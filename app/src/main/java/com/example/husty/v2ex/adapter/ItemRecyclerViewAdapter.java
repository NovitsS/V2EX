package com.example.husty.v2ex.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.husty.v2ex.R;
import com.example.husty.v2ex.parseJson.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HUSTy on 2016/12/1.
 */

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ItemViewHolder>
        implements View.OnClickListener{
    private List<Item> mItemArrayList;
    private Context mContext;
    private OnItemClickListener mListener=null;


    public ItemRecyclerViewAdapter(List<Item> itemArrayList, Context context) {
        this.mItemArrayList = itemArrayList;
        this.mContext = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recyclerview, parent, false);
        ItemViewHolder mItemViewHolder=new ItemViewHolder(view);
        return mItemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item=mItemArrayList.get(position);
        holder.mItemTitle.setText(item.getTitle());
        holder.mNodeTitle.setText("来自话题: "+item.getNode().getTitle());
        if(item.getBitmap()!=null){
            holder.memberAvatar.setImageBitmap(item.getBitmap());
        }
        holder.mItemTitle.setOnClickListener(this);
        holder.mItemTitle.setTag(position);
    }

    @Override
    public int getItemCount() {
        int num=mItemArrayList.size();
        return num;
    }

    @Override
    public void onClick(View v) {
        if(mListener!=null)
            mListener.onItemClickListener(v,(Integer) v.getTag());
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView memberAvatar;
        TextView mItemTitle,mNodeTitle;
        public ItemViewHolder(View itemView){
            super(itemView);
            memberAvatar=(ImageView)itemView.findViewById(R.id.member_avatar_mini);
            mItemTitle=(TextView)itemView.findViewById(R.id.item_title);
            mNodeTitle=(TextView)itemView.findViewById(R.id.node_title);
        }
    }

    public static  interface OnItemClickListener{
        public void onItemClickListener(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener=listener;
    }
}

