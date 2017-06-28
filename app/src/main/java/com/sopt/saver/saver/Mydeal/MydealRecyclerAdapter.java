package com.sopt.saver.saver.Mydeal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sopt.saver.saver.ImageLoadTask;
import com.sopt.saver.saver.R;

import java.util.ArrayList;

/**
 * Created by kyi42 on 2017-06-27.
 */

public class MydealRecyclerAdapter extends RecyclerView.Adapter<MydealViewHolder>{
    ArrayList<Mydeal_ProductData> mydeal_productDatas;
    View.OnClickListener clickListener;

    public MydealRecyclerAdapter(ArrayList<Mydeal_ProductData> mydeal_productDatas, View.OnClickListener clickListener) {
        this.mydeal_productDatas = mydeal_productDatas;
        this.clickListener = clickListener;
    }

    public void setAdapter(ArrayList<Mydeal_ProductData> mydeal_productDatas) {
        this.mydeal_productDatas = mydeal_productDatas;
        notifyDataSetChanged();
    }
    @Override
    public MydealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.electronics_item_description, parent, false);
        view.setOnClickListener(clickListener);
        MydealViewHolder mydealViewHolder = new MydealViewHolder(view);
        return mydealViewHolder;
    }

    @Override
    public void onBindViewHolder(MydealViewHolder holder, int position) {
        new ImageLoadTask(mydeal_productDatas.get(position).image, holder.mydeal_item_img).execute();
        holder.mydeal_time_tv.setText(mydeal_productDatas.get(position).time);
        holder.mydeal_product_tv.setText(mydeal_productDatas.get(position).product);
        holder.mydeal_price_tv.setText(mydeal_productDatas.get(position).price);
        holder.mydeal_commentnum_tv.setText(mydeal_productDatas.get(position).comcount);
        holder.mydeal_dday_tv.setText(mydeal_productDatas.get(position).dday);
    }
    @Override
    public int getItemCount() {
        return mydeal_productDatas != null ? mydeal_productDatas.size() : 0;
    }
}
