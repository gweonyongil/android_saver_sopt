package com.sopt.saver.saver.Mydeal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sopt.saver.saver.R;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by kyi42 on 2017-07-03.
 */

public class MydealListAdapter extends BaseAdapter {
    ArrayList<Mydeal_ProductData> mydeal_productDatas;
    View.OnClickListener onClickListener;
    Context context;
    ////////////CONSTRUCTOR///////////////
    public MydealListAdapter()
    {

    }
    public MydealListAdapter(ArrayList<Mydeal_ProductData> mydeal_productDatas, View.OnClickListener onClickListener) {
        this.mydeal_productDatas = mydeal_productDatas;
        this.onClickListener = onClickListener;
    }
    //////////////METHOD/////////////////
    public void setAdapter(ArrayList<Mydeal_ProductData> mydeal_productDatas) {
        this.mydeal_productDatas = mydeal_productDatas;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    @Override
    public int getCount() {
        return mydeal_productDatas != null ? mydeal_productDatas.size() : 0;
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
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.mydeal_item_description, parent, false);
        }
        ImageView mydeal_img = (ImageView) convertView.findViewById(R.id.mydeal_item_img);
        TextView mydeal_userid = (TextView) convertView.findViewById(R.id.mydeal_item_text1);
        TextView mydeal_title = (TextView) convertView.findViewById(R.id.mydeal_item_text2);
        TextView mydeal_product = (TextView) convertView.findViewById(R.id.mydeal_item_text3);
        TextView mydeal_price = (TextView) convertView.findViewById(R.id.mydeal_item_text4);
        TextView mydeal_time = (TextView) convertView.findViewById(R.id.mydeal_item_text5);
        TextView mydeal_text6 = (TextView) convertView.findViewById(R.id.mydeal_item_text6);
        TextView mydeal_text7 = (TextView) convertView.findViewById(R.id.mydeal_item_text1);
        ////////////////뷰 설정/////////////////
        if (mydeal_productDatas.get(position).image != null) {
            Glide.with(context)
                    .load(mydeal_productDatas.get(position).image)
                    .bitmapTransform(new CropCircleTransformation(context))
                    .into(mydeal_img);
        }
        mydeal_userid.setText(mydeal_productDatas.get(position).userid);
        mydeal_title.setText(mydeal_productDatas.get(position).title);
        mydeal_product.setText(mydeal_productDatas.get(position).product);
        mydeal_price.setText(mydeal_productDatas.get(position).price);
        mydeal_time.setText(mydeal_productDatas.get(position).time);
        mydeal_text6.setText(mydeal_productDatas.get(position).id);
        mydeal_text7.setText(mydeal_productDatas.get(position).comcount);

        return convertView;
    }
}
