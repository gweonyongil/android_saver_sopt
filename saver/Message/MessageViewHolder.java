package com.sopt.saver.saver.Message;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sopt.saver.saver.R;

/**
 * Created by hyowon on 2017. 4. 15..
 */

public class MessageViewHolder extends RecyclerView.ViewHolder{

    String username;
    String content;
    String date;

    public TextView recycler_buyerid;
    public TextView recycler_user_num;
    public TextView recycler_content;
    public TextView recycler_time;

    static Context context;


    public MessageViewHolder(View itemView) {
        super(itemView);
        //////////////////////객체화///////////////////////////////
//        recycler_buyerid = (TextView)itemView.findViewById(R.id.custom_item_img);
        recycler_user_num = (TextView)itemView.findViewById(R.id.m_description_item_title);
        recycler_content = (TextView)itemView.findViewById(R.id.m_description_item_content);
        recycler_time = (TextView)itemView.findViewById(R.id.m_description_item_date);
        ////////////////////폰트설정////////////////////////////
//        SetFontClass setFontClass = new SetFontClass(context.getAssets());
//        recycler_buyerid.setTypeface(setFontClass.getNotoSansRegular());
//        recycler_content.setTypeface(setFontClass.getNotoSansRegular());
//        recycler_content.setTypeface(setFontClass.getNotoSansRegular());
    }

    public static void setContext(Context activitycontext) {
        context = activitycontext;
    }
}
