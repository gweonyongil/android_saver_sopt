package com.sopt.saver.saver.Mydeal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.sopt.saver.saver.R;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by kyi42 on 2017-06-27.
 */

public class MydealRecyclerAdapter extends RecyclerView.Adapter<MydealViewHolder>{
    ArrayList<Mydeal_ProductData> mydeal_productDatas;
    View.OnClickListener clickListener;
    private Context context;

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
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.electronics_item_description, parent, false);
        view.setOnClickListener(clickListener);
        MydealViewHolder mydealViewHolder = new MydealViewHolder(view);
        return mydealViewHolder;
    }

    @Override
    public void onBindViewHolder(MydealViewHolder holder, int position) {
        if(mydeal_productDatas.get(position).image != null)
        {
            Glide.with(context)
                    .load(mydeal_productDatas.get(position).image)
                    .bitmapTransform(new CropCircleTransformation(context))
                    .into(holder.mydeal_item_img);
        }
        ///////////////////////CIRCLE TEST/////////////////////////
        Glide.with(context)
                .load(R.drawable.background)
                .bitmapTransform(new CropCircleTransformation(context))
                .into(holder.mydeal_item_img);

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
