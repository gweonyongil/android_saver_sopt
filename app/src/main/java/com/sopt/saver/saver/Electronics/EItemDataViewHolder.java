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
    //ImageView electronics_user_img;
    TextView electronics_time_tv;
    TextView electronics_name_tv;
    TextView electronics_price_tv;
    TextView electronics_able_time_tv;
    TextView electronics_commentnum_tv;

    public EItemDataViewHolder(View itemView){
        super(itemView);
        electronics_item_img = (ImageView)itemView.findViewById(R.id.electronics_item_img);
        //electronics_user_img = (ImageView)itemView.findViewById(R.id.electronics_full_user_item_img);
        electronics_time_tv = (TextView)itemView.findViewById(R.id.electronics_item_text1);
        electronics_name_tv = (TextView)itemView.findViewById(R.id.electronics_item_text2);
        electronics_price_tv = (TextView)itemView.findViewById(R.id.electronics_item_text3);
        electronics_able_time_tv = (TextView)itemView.findViewById(R.id.electronics_item_image1_text);
        electronics_commentnum_tv = (TextView)itemView.findViewById(R.id.electronics_item_image2_text);
    }
}
