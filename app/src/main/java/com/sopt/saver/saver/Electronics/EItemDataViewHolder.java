package com.sopt.saver.saver.Electronics;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sopt.saver.saver.R;

/**
 * Created by kyi42 on 2017-04-15.
 */

public class EItemDataViewHolder extends RecyclerView.ViewHolder {

    ImageView electronics_item_img;
    TextView electronics_title_tv;
    TextView electronics_product_tv;
    TextView electronics_price_tv;
    TextView electronics_commentnum_tv;
    TextView electronics_time_tv;
    TextView electronics_dday_tv;
    TextView electronics_user_id_tv;

    public EItemDataViewHolder(View itemView){
        super(itemView);
        electronics_item_img = (ImageView)itemView.findViewById(R.id.electronics_item_img);
        electronics_title_tv = (TextView)itemView.findViewById(R.id.electronics_item_text1);
        electronics_product_tv = (TextView)itemView.findViewById(R.id.electronics_item_text2);
        electronics_price_tv = (TextView)itemView.findViewById(R.id.electronics_item_text3);
        electronics_dday_tv = (TextView)itemView.findViewById(R.id.electronics_item_text4);
        electronics_time_tv = (TextView)itemView.findViewById(R.id.electronics_item_text5);
        electronics_user_id_tv = (TextView)itemView.findViewById(R.id.electronics_item_text6);
        electronics_commentnum_tv = (TextView)itemView.findViewById(R.id.electronics_item_image1_text);
    }
}
