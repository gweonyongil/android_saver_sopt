package com.sopt.saver.saver.Electronics;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sopt.saver.saver.Answer.AnswerActivity;
import com.sopt.saver.saver.R;

/**
 * Created by kyi42 on 2017-06-28.
 */

public class EProductInfoFragment extends Fragment {
    TextView product_time_tv;
    TextView product_writer_user_id_tv;
    TextView product_comment_num_tv;
    TextView product_dday_tv;
    TextView product_tv1;
    TextView product_tv2;
    TextView product_tv3;
    TextView product_tv4;
    TextView product_tv5;
    TextView product_tv6;
    TextView product_tv7;
    TextView product_tv8;
    Button product_answer_btn;
    public EProductInfoFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_productinfo, container, false);
        product_writer_user_id_tv = (TextView) view.findViewById(R.id.electronics_prodInfo_user_id_tv);
        product_time_tv = (TextView) view.findViewById(R.id.electronics_prodInfo_time_text);
        product_comment_num_tv = (TextView) view.findViewById(R.id.electronics_prodInfo_item_image2_text);
        product_dday_tv = (TextView) view.findViewById(R.id.electronics_prodInfo_item_image1_text);
        product_tv1 = (TextView) view.findViewById(R.id.electronics_prodInfo_item_text1);
        product_tv2 = (TextView) view.findViewById(R.id.electronics_prodInfo_item_text2);
        product_tv2 = (TextView) view.findViewById(R.id.electronics_prodInfo_item_text2);
        product_tv3 = (TextView) view.findViewById(R.id.electronics_prodInfo_item_text3);
        product_tv4 = (TextView) view.findViewById(R.id.electronics_prodInfo_item_text4);
        product_tv5 = (TextView) view.findViewById(R.id.electronics_prodInfo_item_text5);
        product_tv6 = (TextView) view.findViewById(R.id.electronics_prodInfo_item_text6);
        product_tv7 = (TextView) view.findViewById(R.id.electronics_prodInfo_item_text7);
        product_tv8 = (TextView) view.findViewById(R.id.electronics_prodInfo_item_text8);
        product_answer_btn = (Button) view.findViewById(R.id.electronics_prodInfo_answer_btn);
        product_answer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Fragment 내에서 intent 전달
                Intent ans_intent = new Intent(getActivity(), AnswerActivity.class);
                startActivity(ans_intent);
            }
        });
        if(getArguments() != null)
        {
            product_writer_user_id_tv.setText(getArguments().getString("writer_user_id"));
            product_time_tv.setText(getArguments().getString("time"));
            product_comment_num_tv.setText(getArguments().getString("comment_num"));
            product_dday_tv.setText(getArguments().getString("dday"));
            product_tv1.setText(getArguments().getString("text1"));
            product_tv2.setText(getArguments().getString("text2"));
            product_tv3.setText(getArguments().getString("text3"));
            product_tv4.setText(getArguments().getString("text4"));
            product_tv5.setText(getArguments().getString("text5"));
            product_tv6.setText(getArguments().getString("text6"));
            product_tv7.setText(getArguments().getString("text7"));
            product_tv8.setText(getArguments().getString("text8"));
        }
        return view;
    }
    public Button getProduct_answer_btn()
    {
        return product_answer_btn;
    }
}
