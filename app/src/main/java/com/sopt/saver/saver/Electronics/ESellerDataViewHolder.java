package com.sopt.saver.saver.Electronics;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sopt.saver.saver.R;

/**
 * Created by kyi42 on 2017-06-28.
 */

public class ESellerDataViewHolder extends RecyclerView.ViewHolder {
    ImageView e_seller_user_img;
    TextView e_seller_user_id_tv;
    TextView e_seller_title_tv;
    TextView e_seller_prodcut_tv;
    TextView e_seller_price_tv;
    Button e_seller_open_btn;

    public ESellerDataViewHolder(View itemView) {
        super(itemView);
        e_seller_user_img = (ImageView) itemView.findViewById(R.id.electronics_seller_item_img);
        e_seller_user_id_tv = (TextView) itemView.findViewById(R.id.electronics_seller_user_id_text);
        e_seller_title_tv = (TextView) itemView.findViewById(R.id.electronics_seller_item_text1);
        e_seller_prodcut_tv = (TextView) itemView.findViewById(R.id.electronics_seller_item_text2);
        e_seller_price_tv = (TextView) itemView.findViewById(R.id.electronics_prodInfo_item_text3);
        e_seller_open_btn = (Button) itemView.findViewById(R.id.electronics_seller_open_btn);
    }
}
