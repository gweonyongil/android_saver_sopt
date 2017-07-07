package com.sopt.saver.saver.Message;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sopt.saver.saver.API.SetFontClass;
import com.sopt.saver.saver.R;

/**
 * Created by hyowon on 2017. 4. 15..
 */

public class MessageViewHolder extends RecyclerView.ViewHolder{

    String username;
    String content;
    String date;

    public ImageView recycler_img;
    public TextView recycler_username;
    public TextView recycler_content;
    public TextView recycler_date;

    private Context context;


    public MessageViewHolder(View itemView) {
        super(itemView);
        //////////////////////객체화///////////////////////////////
        recycler_img = (ImageView)itemView.findViewById(R.id.custom_item_img);
        recycler_username = (TextView)itemView.findViewById(R.id.custom_item_title);
        recycler_content = (TextView)itemView.findViewById(R.id.custom_item_content);
        recycler_date = (TextView)itemView.findViewById(R.id.custom_item_date);
        ////////////////////폰트설정////////////////////////////
        SetFontClass setFontClass = new SetFontClass(context.getAssets());
        recycler_username.setTypeface(setFontClass.getNotoSansRegular());
        recycler_content.setTypeface(setFontClass.getNotoSansRegular());
        recycler_date.setTypeface(setFontClass.getNotoSansRegular());
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
