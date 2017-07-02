package com.sopt.saver.saver.Electronics;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sopt.saver.saver.Answer.AnswerActivity;
import com.sopt.saver.saver.R;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by kyi42 on 2017-06-28.
 */

public class EProductInfoFragment extends Fragment {
    ImageView product_profile_img;
    TextView product_time_tv;
    TextView product_writer_user_id_tv;
    TextView product_comment_num_tv;
    TextView product_tv1;
    TextView product_tv2;
    TextView product_tv3;
    TextView product_tv4;
    TextView product_tv5;
    Button product_answer_btn;

    public EProductInfoFragment() {
        super();
    }

    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_productinfo, container, false);
        product_profile_img = (ImageView) view.findViewById(R.id.electronics_prodInfo_item_img);
        product_writer_user_id_tv = (TextView) view.findViewById(R.id.electronics_prodInfo_userid_tv);
        product_time_tv = (TextView) view.findViewById(R.id.electronics_prodInfo_time_tv);
        product_comment_num_tv = (TextView) view.findViewById(R.id.electronics_prodInfo_item_image1_text);
        product_tv1 = (TextView) view.findViewById(R.id.electronics_prodInfo_item_text1);
        product_tv2 = (TextView) view.findViewById(R.id.electronics_prodInfo_item_text2);
        product_tv2 = (TextView) view.findViewById(R.id.electronics_prodInfo_item_text2);
        product_tv3 = (TextView) view.findViewById(R.id.electronics_prodInfo_item_text3);
        product_tv4 = (TextView) view.findViewById(R.id.electronics_prodInfo_item_text4);
        product_tv5 = (TextView) view.findViewById(R.id.electronics_prodInfo_item_text5);
        product_answer_btn = (Button) view.findViewById(R.id.electronics_prodInfo_answer_btn);
        product_answer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent answer_intent = new Intent(getActivity(), AnswerActivity.class);
                answer_intent.putExtra("id", getArguments().getString("id"));
                startActivity(answer_intent);
            }
        });
        if (getArguments() != null) {
            if(getArguments().get("profileimage") != null) {
                Glide.with(context)
                        .load(getArguments().get("profileimage"))
                        .bitmapTransform(new CropCircleTransformation(context))
                        .into(product_profile_img);
            }
            product_writer_user_id_tv.setText(getArguments().getString("writer_user_id"));
            product_time_tv.setText(getArguments().getString("time"));
            product_comment_num_tv.setText(getArguments().getString("comment_num"));
            product_tv1.setText(getArguments().getString("text1"));
            product_tv2.setText(getArguments().getString("text2"));
            product_tv3.setText(getArguments().getString("text3"));
            product_tv4.setText(getArguments().getString("text4"));
            product_tv5.setText(getArguments().getString("text5"));
        }
        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
