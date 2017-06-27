package com.sopt.saver.saver.Electronics;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sopt.saver.saver.R;

import java.util.ArrayList;

/**
 * Created by kyi42 on 2017-04-15.
 */

public class ElectronicsRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {
    ArrayList<Electronics_ItemData> electronics_itemDatas;
    View.OnClickListener clickListener;

    public ElectronicsRecyclerAdapter(ArrayList<Electronics_ItemData> electronics_itemDatas, View.OnClickListener clickListener) {
        this.electronics_itemDatas = electronics_itemDatas;
        this.clickListener = clickListener;
    }

    public void setAdapter(ArrayList<Electronics_ItemData> electronics_itemDatas) {
        this.electronics_itemDatas = electronics_itemDatas;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.electronics_item_descrpition, parent, false);
        view.setOnClickListener(clickListener);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        new ImageLoadTask(electronics_itemDatas.get(position).image, holder.electronics_item_img).execute();
        holder.electronics_time_tv.setText(electronics_itemDatas.get(position).time);
        holder.electronics_name_tv.setText(electronics_itemDatas.get(position).product);
        holder.electronics_price_tv.setText(electronics_itemDatas.get(position).price);
}

    @Override
    public int getItemCount() {
        return electronics_itemDatas != null ? electronics_itemDatas.size() : 0;
    }
}
