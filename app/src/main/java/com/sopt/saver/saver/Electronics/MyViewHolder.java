package com.sopt.saver.saver.Electronics;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sopt.saver.saver.R;

/**
 * Created by kyi42 on 2017-04-15.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView electronics_item_img;
    TextView electronics_time_tv;
    TextView electronics_name_tv;
    TextView electronics_price_tv;

    public MyViewHolder(View itemView){
        super(itemView);
        electronics_time_tv = (TextView)itemView.findViewById(R.id.electronics_time_text);
        electronics_item_img = (ImageView)itemView.findViewById(R.id.electronics_item_image1);
        electronics_name_tv = (TextView)itemView.findViewById(R.id.electronics_item_image1_text);
        electronics_price_tv = (TextView)itemView.findViewById(R.id.electronics_item_price);
    }
}
