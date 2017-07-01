package com.sopt.saver.saver.Electronics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sopt.saver.saver.R;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by kyi42 on 2017-07-01.
 */

public class ESellerListAdapter extends BaseAdapter {
    ArrayList<ESellerData> sellerDatas;
    View.OnClickListener onClickListener;
    Context context;
    public ESellerListAdapter(ArrayList<ESellerData> sellerDatas, View.OnClickListener onClickListener){
        this.sellerDatas = sellerDatas;
        this.onClickListener = onClickListener;
    }

    public void setAdapter(ArrayList<ESellerData> sellerDatas) {
        this.sellerDatas = sellerDatas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return sellerDatas != null ? sellerDatas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        context = parent.getContext();
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.electronics_item_seller_description, parent, false);
        }

        ImageView seller_img = (ImageView)convertView.findViewById(R.id.electronics_seller_item_img);
        TextView seller_userid = (TextView)convertView.findViewById(R.id.electronics_seller_user_id_text);
        TextView seller_title = (TextView)convertView.findViewById(R.id.electronics_seller_item_text1);
        TextView seller_product = (TextView)convertView.findViewById(R.id.electronics_seller_item_text2);
        TextView seller_price = (TextView)convertView.findViewById(R.id.electronics_seller_item_text3);
        Button seller_open_btn = (Button)convertView.findViewById(R.id.electronics_seller_open_btn);

        //        if(e_sellerDatas.get(position).image != null)
//        {
//            Glide.with(context)
//                    .load(e_sellerDatas.get(position).image)
//                    .bitmapTransform(new CropCircleTransformation(context))
//                    .into(holder.e_seller_user_img);
//        }

        Glide.with(context)
                .load(R.drawable.background)
                .bitmapTransform(new CropCircleTransformation(context))
                .into(seller_img);
        seller_userid.setText(sellerDatas.get(position).userid);
        seller_title.setText(sellerDatas.get(position).title);
        seller_product.setText(sellerDatas.get(position).product);
        seller_price.setText(sellerDatas.get(position).price);
        seller_open_btn.setOnClickListener(onClickListener);

        return convertView;
    }
}
