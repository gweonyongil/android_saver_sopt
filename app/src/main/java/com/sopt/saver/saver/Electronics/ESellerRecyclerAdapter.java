package com.sopt.saver.saver.Electronics;

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

public class ESellerRecyclerAdapter extends RecyclerView.Adapter<ESellerDataViewHolder> {
    ArrayList<ESellerData> e_sellerDatas;
    View.OnClickListener clickListener;

    public ESellerRecyclerAdapter(ArrayList<ESellerData> e_sellerDatas, View.OnClickListener clickListener) {
        this.e_sellerDatas = e_sellerDatas;
        this.clickListener = clickListener;
    }

    public void setAdapter(ArrayList<ESellerData> e_sellerDatas) {
        this.e_sellerDatas = e_sellerDatas;
        notifyDataSetChanged();
    }
    @Override
    public ESellerDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.electronics_item_seller_description , parent, false);
        view.setOnClickListener(clickListener);//클릭 시 텍스트 뷰 Visible 속성
        ESellerDataViewHolder ESellerDataViewHolder = new ESellerDataViewHolder(view);
        return ESellerDataViewHolder;
    }

    @Override
    public void onBindViewHolder(ESellerDataViewHolder holder, int position) {
        new ImageLoadTask(e_sellerDatas.get(position).image, holder.e_seller_user_img).execute();
        holder.e_seller_user_id_tv.setText(e_sellerDatas.get(position).userid);
        holder.e_seller_prodcut_tv.setText(e_sellerDatas.get(position).product);
        holder.e_seller_title_tv.setText(e_sellerDatas.get(position).title);
        holder.e_seller_price_tv.setText(e_sellerDatas.get(position).price);
    }

    @Override
    public int getItemCount() {
        return e_sellerDatas != null ? e_sellerDatas.size() : 0;
    }
}
