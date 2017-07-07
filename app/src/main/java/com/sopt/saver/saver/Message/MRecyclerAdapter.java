package com.sopt.saver.saver.Message;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.sopt.saver.saver.R;

import java.util.ArrayList;

/**
 * Created by hyowon on 2017. 4. 15..
 */

public class MRecyclerAdapter extends RecyclerView.Adapter<MessageViewHolder> {

    private Context context;
    private ArrayList<MessageListData> messageListDatas;
    private View.OnClickListener onClickListener;

    public void setContext(Context context) {
        this.context = context;
    }

    public MRecyclerAdapter(ArrayList<MessageListData> mainListDatas, View.OnClickListener onClickListener) {
        this.messageListDatas = mainListDatas;
        this.onClickListener = onClickListener;
    }

    public void setAdapter(ArrayList<MessageListData> mainListDatas){
        this.messageListDatas = mainListDatas;
        notifyDataSetChanged();
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_message, parent,false);
        MessageViewHolder viewHolder = new MessageViewHolder(view);

        view.setOnClickListener(onClickListener);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {

        //holder.recycler_img.setImageResource(R.drawable.category_guita);
        Glide
                .with(context)
                .load(messageListDatas.get(position).imgUrl)
                .into(holder.recycler_img);
        holder.recycler_username.setText(messageListDatas.get(position).username);
        holder.recycler_content.setText(messageListDatas.get(position).content);
        holder.recycler_date.setText(messageListDatas.get(position).date);
    }

    @Override
    public int getItemCount() {
        return messageListDatas !=null ? messageListDatas.size() : 0;
    }
}
