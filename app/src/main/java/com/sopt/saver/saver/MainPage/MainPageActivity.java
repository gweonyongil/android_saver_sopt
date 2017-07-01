package com.sopt.saver.saver.MainPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.sopt.saver.saver.Category.CategoryActivity;
import com.sopt.saver.saver.Message.MessageActivity;
import com.sopt.saver.saver.Mydeal.MydealRecyclerViewActivity;
import com.sopt.saver.saver.Mypage.MyPageActivity;
import com.sopt.saver.saver.Network.NetworkService;
import com.sopt.saver.saver.R;
import com.sopt.saver.saver.application.ApplicationController;

public class MainPageActivity extends AppCompatActivity {
    //////////////MAIN//////////////////////
    private TextView people_tv;
    private TextView comment_tv;
    private TextView success_tv;
    ////////////////ELEC////////////////////
    private ImageView elec_item1_img;
    private TextView elec_item1_title_tv;
    private TextView elec_item1_content_tv;
    private TextView elec_item1_price_tv;
    private ImageView elec_item2_img;
    private TextView elec_item2_title_tv;
    private TextView elec_item2_content_tv;
    private TextView elec_item2_price_tv;
    ////////////////TICKET///////////////////
    private ImageView ticket_item1_img;
    private TextView ticket_item1_title_tv;
    private TextView ticket_item1_content_tv;
    private TextView ticket_item1_price_tv;
    private ImageView ticket_item2_img;
    private TextView ticket_item2_title_tv;
    private TextView ticket_item2_content_tv;
    private TextView ticket_item2_price_tv;
    ////////////////BRAND////////////////////////
    private ImageView brand_item1_img;
    private TextView brand_item1_title_tv;
    private TextView brand_item1_content_tv;
    private TextView brand_item1_price_tv;
    private ImageView brand_item2_img;
    private TextView brand_item2_title_tv;
    private TextView brand_item2_content_tv;
    private TextView brand_item2_price_tv;
    /////////////////SMART//////////////////////
    private ImageView smart_item1_img;
    private TextView smart_item1_title_tv;
    private TextView smart_item1_content_tv;
    private TextView smart_item1_price_tv;
    private ImageView smart_item2_img;
    private TextView smart_item2_title_tv;
    private TextView smart_item2_content_tv;
    private TextView smart_item2_price_tv;
    //////////////////ETC////////////////////////
    private ImageView etc_item1_img;
    private TextView etc_item1_title_tv;
    private TextView etc_item1_content_tv;
    private TextView etc_item1_price_tv;
    private ImageView etc_item2_img;
    private TextView etc_item2_title_tv;
    private TextView etc_item2_content_tv;
    private TextView etc_item2_price_tv;
    ////////////////////NAVIBAR///////////////
    private ImageButton main_btn;
    private ImageButton category_btn;
    private ImageButton message_btn;
    private ImageButton mydeal_btn;
    ////////////////SERVICE///////////////////
    NetworkService service;
    ////////////////////Intent//////////////////
    String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        ///////////////////////서비스 초기화///////////////////////////
        service = ApplicationController.getInstance().getNetworkService();
        ///////////////////////////Intent/////////////////////////////
//      userid = getIntent().getExtras().getString("userid");
        userid = "test";
        ///////////////////////객체 초기화//////////////////////////////
        people_tv = (TextView) findViewById(R.id.mainpage_people_tv);
        comment_tv = (TextView) findViewById(R.id.mainpage_info_tv);
        success_tv = (TextView) findViewById(R.id.mainpage_success_tv);
        ///////////////////////ELEC 초기화//////////////////////////////
        elec_item1_img = (ImageView) findViewById(R.id.elec_item1_img);
        elec_item1_title_tv = (TextView) findViewById(R.id.elec_item1_title_tv);
        elec_item1_content_tv = (TextView) findViewById(R.id.elec_item1_content_tv);
        elec_item1_price_tv = (TextView) findViewById(R.id.elec_item1_price_tv);
        elec_item2_img = (ImageView) findViewById(R.id.elec_item2_img);
        elec_item2_title_tv = (TextView) findViewById(R.id.elec_item2_title_tv);
        elec_item2_content_tv = (TextView) findViewById(R.id.elec_item2_content_tv);
        elec_item2_price_tv = (TextView) findViewById(R.id.elec_item2_price_tv);
        //////////////////////TICKET 초기화////////////////////////////////
        ticket_item1_img = (ImageView) findViewById(R.id.ticket_item1_img);
        ticket_item1_title_tv = (TextView) findViewById(R.id.ticket_item1_title_tv);
        ticket_item1_content_tv = (TextView) findViewById(R.id.ticket_item1_content_tv);
        ticket_item1_price_tv = (TextView) findViewById(R.id.ticket_item1_price_tv);
        ticket_item2_img = (ImageView) findViewById(R.id.ticket_item2_img);
        ticket_item2_title_tv = (TextView) findViewById(R.id.ticket_item2_title_tv);
        ticket_item2_content_tv = (TextView) findViewById(R.id.ticket_item2_content_tv);
        ticket_item2_price_tv = (TextView) findViewById(R.id.ticket_item2_price_tv);
        ////////////////////////BRAND 초기화//////////////////////////////////
        brand_item1_img = (ImageView) findViewById(R.id.brand_item1_img);
        brand_item1_title_tv = (TextView) findViewById(R.id.brand_item1_title_tv);
        brand_item1_content_tv = (TextView) findViewById(R.id.brand_item1_content_tv);
        brand_item1_price_tv = (TextView) findViewById(R.id.brand_item1_price_tv);
        brand_item2_img = (ImageView) findViewById(R.id.brand_item2_img);
        brand_item2_title_tv = (TextView) findViewById(R.id.brand_item2_title_tv);
        brand_item2_content_tv = (TextView) findViewById(R.id.brand_item2_content_tv);
        brand_item2_price_tv = (TextView) findViewById(R.id.brand_item2_price_tv);
        ///////////////////////SMART 초기화/////////////////////////////////
        smart_item1_img = (ImageView) findViewById(R.id.smart_item1_img);
        smart_item1_title_tv = (TextView) findViewById(R.id.smart_item1_title_tv);
        smart_item1_content_tv = (TextView) findViewById(R.id.smart_item1_content_tv);
        smart_item1_price_tv = (TextView) findViewById(R.id.smart_item1_price_tv);
        smart_item2_img = (ImageView) findViewById(R.id.smart_item2_img);
        smart_item2_title_tv = (TextView) findViewById(R.id.smart_item2_title_tv);
        smart_item2_content_tv = (TextView) findViewById(R.id.smart_item2_content_tv);
        smart_item2_price_tv = (TextView) findViewById(R.id.smart_item2_price_tv);
        ///////////////////////ETC 초기화/////////////////////////////////
        etc_item1_img = (ImageView) findViewById(R.id.etc_item1_img);
        etc_item1_title_tv = (TextView) findViewById(R.id.etc_item1_title_tv);
        etc_item1_content_tv = (TextView) findViewById(R.id.etc_item1_content_tv);
        etc_item1_price_tv = (TextView) findViewById(R.id.etc_item1_price_tv);
        etc_item2_img = (ImageView) findViewById(R.id.etc_item2_img);
        etc_item2_title_tv = (TextView) findViewById(R.id.etc_item2_title_tv);
        etc_item2_content_tv = (TextView) findViewById(R.id.etc_item2_content_tv);
        etc_item2_price_tv = (TextView) findViewById(R.id.etc_item2_price_tv);
        //////////////////////NAVIBAR 초기화//////////////////////////////
        category_btn = (ImageButton) findViewById(R.id.mainpage_category_btn);
        message_btn = (ImageButton) findViewById(R.id.mainpage_message_btn);
        mydeal_btn = (ImageButton) findViewById(R.id.mainpage_mydeal_btn);
        ////////////////클릭이벤트////////////////////////////
        findViewById(R.id.main_mypage_btn).setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MyPageActivity.class);
                        startActivity(intent);
                    }
                }
        );
        category_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category_intent = new Intent(MainPageActivity.this, CategoryActivity.class);
                category_intent.putExtra("userid", userid);
                startActivity(category_intent);
            }
        });
        message_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent message_intent = new Intent(MainPageActivity.this, MessageActivity.class);
                message_intent.putExtra("userid", userid);
                startActivity(message_intent);
            }
        });
        mydeal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mydeal_intent = new Intent(MainPageActivity.this, MydealRecyclerViewActivity.class);
                mydeal_intent.putExtra("userid", userid);
                startActivity(mydeal_intent);
            }
        });
        /////////////////////네트워킹////////////////////////

    }
}
