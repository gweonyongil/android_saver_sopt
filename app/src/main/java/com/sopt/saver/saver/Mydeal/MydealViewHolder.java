package com.sopt.saver.saver.Mydeal;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sopt.saver.saver.R;

/**
 * Created by kyi42 on 2017-06-27.
 */

public class MydealViewHolder extends RecyclerView.ViewHolder{
    ImageView mydeal_item_img;
    //ImageView electronics_user_img;
    TextView mydeal_userid_tv;
    TextView mydeal_time_tv;
    TextView mydeal_title_tv;
    TextView mydeal_product_tv;
    TextView mydeal_price_tv;
    TextView mydeal_dday_tv;
    TextView mydeal_commentnum_tv;

    public MydealViewHolder(View itemView){
        super(itemView);
        mydeal_item_img = (ImageView)itemView.findViewById(R.id.mydeal_item_img);
        //electronics_user_img = (ImageView)itemView.findViewById(R.id.electronics_full_user_item_img);
        mydeal_title_tv = (TextView)itemView.findViewById(R.id.mydeal_item_text1);
        mydeal_product_tv = (TextView)itemView.findViewById(R.id.mydeal_item_text2);
        mydeal_price_tv = (TextView)itemView.findViewById(R.id.mydeal_item_text3);
        mydeal_dday_tv = (TextView)itemView.findViewById(R.id.mydeal_item_text4);
        mydeal_time_tv = (TextView)itemView.findViewById(R.id.mydeal_item_text5);
        mydeal_userid_tv = (TextView)itemView.findViewById(R.id.mydeal_item_text6);
        mydeal_commentnum_tv = (TextView)itemView.findViewById(R.id.mydeal_item_image1_text);
    }
}
