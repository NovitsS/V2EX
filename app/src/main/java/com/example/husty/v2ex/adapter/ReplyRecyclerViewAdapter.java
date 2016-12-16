package com.example.husty.v2ex.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.husty.v2ex.R;
import com.example.husty.v2ex.parseHtml.ReplyItem;
import com.example.husty.v2ex.parseJson.Item;

import java.util.List;

/**
 * Created by HUSTy on 2016/12/3.
 */

public class ReplyRecyclerViewAdapter extends RecyclerView.Adapter<ReplyRecyclerViewAdapter.ReplyItemViewHolder>{
    private List<ReplyItem> mItemArrayList;
    private Context mContext;



    public ReplyRecyclerViewAdapter(List<ReplyItem> itemArrayList, Context context) {
        this.mItemArrayList = itemArrayList;
        this.mContext = context;
    }

    @Override
    public ReplyItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.reply_item,parent,false);
        ReplyItemViewHolder viewHolder=new ReplyItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ReplyItemViewHolder holder, int position) {
        ReplyItem item=mItemArrayList.get(position+2);
        holder.replyContent.setText(item.getContent());
        holder.replyUserName.setText(item.getUserName());
        holder.imageView.setImageBitmap(item.getBitmap());
    }

    @Override
    public int getItemCount() {
        return mItemArrayList.size()-2;
    }

    static class ReplyItemViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView replyUserName,replyContent;
        public ReplyItemViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.reply_user_avatar);
            replyUserName=(TextView)itemView.findViewById(R.id.reply_user_name);
            replyContent=(TextView)itemView.findViewById(R.id.reply_content);
        }
    }
}
