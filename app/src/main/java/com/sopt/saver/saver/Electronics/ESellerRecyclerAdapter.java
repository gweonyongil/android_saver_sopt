package com.sopt.saver.saver.Electronics;

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

public class ESellerRecyclerAdapter extends RecyclerView.Adapter<ESellerDataViewHolder> {
    private Context context;
    ArrayList<ESellerData> e_sellerDatas;
    View.OnClickListener clickListener;
    View.OnClickListener open_btn_clickListener;


    public ESellerRecyclerAdapter(ArrayList<ESellerData> e_sellerDatas, View.OnClickListener clickListener, View.OnClickListener open_btn_clickListener) {
        this.e_sellerDatas = e_sellerDatas;
        this.clickListener = clickListener;
        this.open_btn_clickListener = open_btn_clickListener;
    }

    public void setAdapter(ArrayList<ESellerData> e_sellerDatas) {
        this.e_sellerDatas = e_sellerDatas;
        notifyDataSetChanged();
    }

    @Override
    public ESellerDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.electronics_item_seller_description, parent, false);
        view.setOnClickListener(clickListener);
        ESellerDataViewHolder ESellerDataViewHolder = new ESellerDataViewHolder(view);
        return ESellerDataViewHolder;
    }

    @Override
    public void onBindViewHolder(ESellerDataViewHolder holder, int position) {
        if(e_sellerDatas.get(position).image != null)
        {
            Glide.with(context)
                    .load(e_sellerDatas.get(position).image)
                    .bitmapTransform(new CropCircleTransformation(context))
                    .into(holder.e_seller_user_img);
        }
        ///////////////////////CIRCLE TEST/////////////////////////
        Glide.with(context)
                .load(R.drawable.background)
                .bitmapTransform(new CropCircleTransformation(context))
                .into(holder.e_seller_user_img);
        holder.e_seller_user_id_tv.setText(e_sellerDatas.get(position).userid);
        holder.e_seller_prodcut_tv.setText(e_sellerDatas.get(position).product);
        holder.e_seller_title_tv.setText(e_sellerDatas.get(position).title);
        holder.e_seller_price_tv.setText(e_sellerDatas.get(position).price);
        holder.e_seller_open_btn.setOnClickListener(open_btn_clickListener);
    }


    @Override
    public int getItemCount() {
        return e_sellerDatas != null ? e_sellerDatas.size() : 0;
    }
}
