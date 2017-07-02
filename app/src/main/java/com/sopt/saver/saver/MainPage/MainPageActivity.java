package com.sopt.saver.saver.MainPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sopt.saver.saver.Category.CategoryActivity;
import com.sopt.saver.saver.Electronics.ESellerListViewActivity;
import com.sopt.saver.saver.Message.MessageActivity;
import com.sopt.saver.saver.Mypage.MyPageActivity;
import com.sopt.saver.saver.Network.NetworkService;
import com.sopt.saver.saver.R;
import com.sopt.saver.saver.Write.WritePageActivity;
import com.sopt.saver.saver.application.ApplicationController;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPageActivity extends AppCompatActivity {
    //////////////MAIN//////////////////////
    private TextView people_tv;
    private TextView comment_tv;
    private TextView success_tv;
    private ImageButton buy_btn;
    private ImageButton sell_btn;
    /////////////LAYOUT ITEM////////////////
    private LinearLayout elec_item1_layout;
    private LinearLayout elec_item2_layout;
    private LinearLayout ticket_item1_layout;
    private LinearLayout ticket_item2_layout;
    private LinearLayout brand_item1_layout;
    private LinearLayout brand_item2_layout;
    private LinearLayout smart_item1_layout;
    private LinearLayout smart_item2_layout;
    private LinearLayout etc_item1_layout;
    private LinearLayout etc_item2_layout;
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
    ArrayList<String> id_arrayllist;
    String user_num;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        ////////////////////////arraylist 초기화///////////////////////
        id_arrayllist = new ArrayList<String>();
        ///////////////////////서비스 초기화///////////////////////////
        service = ApplicationController.getInstance().getNetworkService();
        ///////////////////////////Intent/////////////////////////////
        id = getIntent().getExtras().getString("id");
        user_num = getIntent().getExtras().getString("user_num");
        id = "test";
        ///////////////////////객체 초기화//////////////////////////////
        buy_btn = (ImageButton) findViewById(R.id.mainpage_buy_btn);
        sell_btn = (ImageButton) findViewById(R.id.mainpage_sell_btn);
        people_tv = (TextView) findViewById(R.id.mainpage_people_tv);
        comment_tv = (TextView) findViewById(R.id.mainpage_info_tv);
        success_tv = (TextView) findViewById(R.id.mainpage_success_tv);
        ///////////////////////세부 LAYOUT 객체화////////////////////////
        elec_item1_layout = (LinearLayout) findViewById(R.id.elec_now_item1_layout);
        elec_item2_layout = (LinearLayout) findViewById(R.id.elec_now_item2_layout);
        ticket_item1_layout = (LinearLayout) findViewById(R.id.ticket_now_item1_layout);
        ticket_item2_layout = (LinearLayout) findViewById(R.id.ticket_now_item2_layout);
        brand_item1_layout = (LinearLayout) findViewById(R.id.brand_now_item1_layout);
        brand_item2_layout = (LinearLayout) findViewById(R.id.brand_now_item2_layout);
        smart_item1_layout = (LinearLayout) findViewById(R.id.smart_now_item1_layout);
        smart_item2_layout = (LinearLayout) findViewById(R.id.smart_now_item2_layout);
        etc_item1_layout = (LinearLayout) findViewById(R.id.etc_now_item1_layout);
        etc_item2_layout = (LinearLayout) findViewById(R.id.etc_now_item2_layout);
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
                        intent.putExtra("id", id);
                        intent.putExtra("user_num",user_num);
                        startActivity(intent);
                    }
                }
        );

        buy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent write_intent = new Intent(getApplicationContext(), WritePageActivity.class);
                write_intent.putExtra("id", id);
                write_intent.putExtra("user_num",user_num);
                startActivity(write_intent);
            }
        });

        sell_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category_intent = new Intent(getApplicationContext(), CategoryActivity.class);
                category_intent.putExtra("id", id);
                category_intent.putExtra("user_num",user_num);
                startActivity(category_intent);
            }
        });

        category_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category_intent = new Intent(MainPageActivity.this, CategoryActivity.class);
                category_intent.putExtra("id", id);
                category_intent.putExtra("user_num",user_num);
                startActivity(category_intent);
            }
        });
        message_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent message_intent = new Intent(MainPageActivity.this, MessageActivity.class);
                message_intent.putExtra("id", id);
                message_intent.putExtra("user_num",user_num);
                startActivity(message_intent);
            }
        });
        mydeal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mydeal_intent = new Intent(MainPageActivity.this, MydealRecyclerViewActivity.class);
                mydeal_intent.putExtra("id", id);
                mydeal_intent.putExtra("user_num",user_num);
                startActivity(mydeal_intent);
            }
        });
        //////////////////ITEM LINEAR CLICK EVENT//////////////////
        elec_item1_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPageActivity.this, ESellerListViewActivity.class);
                intent.putExtra("thing_num", id_arrayllist.get(0));
                intent.putExtra("user_num",user_num);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        elec_item2_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPageActivity.this, ESellerListViewActivity.class);
                intent.putExtra("thing_num", id_arrayllist.get(1));
                intent.putExtra("user_num",user_num);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        ticket_item1_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPageActivity.this, ESellerListViewActivity.class);
                intent.putExtra("thing_num", id_arrayllist.get(2));
                intent.putExtra("user_num",user_num);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        ticket_item2_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPageActivity.this, ESellerListViewActivity.class);
                intent.putExtra("thing_num", id_arrayllist.get(3));
                intent.putExtra("user_num",user_num);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        brand_item1_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPageActivity.this, ESellerListViewActivity.class);
                intent.putExtra("thing_num", id_arrayllist.get(4));
                intent.putExtra("user_num",user_num);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        brand_item2_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPageActivity.this, ESellerListViewActivity.class);
                intent.putExtra("thing_num", id_arrayllist.get(5));
                intent.putExtra("user_num",user_num);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        smart_item1_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPageActivity.this, ESellerListViewActivity.class);
                intent.putExtra("thing_num", id_arrayllist.get(6));
                intent.putExtra("user_num",user_num);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        smart_item2_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPageActivity.this, ESellerListViewActivity.class);
                intent.putExtra("thing_num", id_arrayllist.get(7));
                intent.putExtra("user_num",user_num);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        etc_item1_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPageActivity.this, ESellerListViewActivity.class);
                intent.putExtra("thing_num", id_arrayllist.get(8));
                intent.putExtra("user_num",user_num);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        etc_item2_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPageActivity.this, ESellerListViewActivity.class);
                intent.putExtra("thing_num", id_arrayllist.get(9));
                intent.putExtra("user_num",user_num);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        /////////////////////네트워킹////////////////////////
        Call<MainPageResult> requestMainPage = service.getMainPageInfo();
        requestMainPage.enqueue(new Callback<MainPageResult>() {
            @Override
            public void onResponse(Call<MainPageResult> call, Response<MainPageResult> response) {
                if (response.isSuccessful()) {
                    if (response.body().message.equals("ok")) {
                        people_tv.setText(response.body().result.usercount.get(0).usercount);
                        comment_tv.setText(response.body().result.allcommentCount.get(0).allcommentCount);
                        success_tv.setText(response.body().result.informationCount.get(0).informationCount);
                        /////////////////////////ELEC 초기화////////////////////////////////
//                        Glide.with(getApplicationContext())
//                                .load(response.body().magam1.get(0).mainProductDatas.get(0).image)
//                                .into(elec_item1_img);
                        elec_item1_title_tv.setText(response.body().result.magam1.get(0).period);
                        elec_item1_content_tv.setText(response.body().result.magam1.get(0).kind);
                        elec_item1_price_tv.setText(response.body().result.magam1.get(0).product);
                        id_arrayllist.add(String.valueOf(response.body().result.magam1.get(0).elec_num));
//                        Glide.with(getApplicationContext())
//                                .load(response.body().mainPageData.mainProductDatas.get(1).image)
//                                .into(elec_item2_img);
                        elec_item2_title_tv.setText(response.body().result.magam1.get(1).period);
                        elec_item2_content_tv.setText(response.body().result.magam1.get(1).kind);
                        elec_item2_price_tv.setText(response.body().result.magam1.get(1).product);
                        id_arrayllist.add(String.valueOf(response.body().result.magam1.get(1).elec_num));
                        //////////////////////TICKET 초기화////////////////////////////////
//                        Glide.with(getApplicationContext())
//                                .load(response.body().mainPageData.mainProductDatas.get(2).image)
//                                .into(ticket_item1_img);
                        ticket_item1_title_tv.setText(response.body().result.magam2.get(0).period);
                        ticket_item1_content_tv.setText(response.body().result.magam2.get(0).kind);
                        ticket_item1_price_tv.setText(response.body().result.magam2.get(0).product);
                        id_arrayllist.add(String.valueOf(response.body().result.magam2.get(0).util_num));
//                        Glide.with(getApplicationContext())
//                                .load(response.body().mainPageData.mainProductDatas.get(3).image)
//                                .into(ticket_item2_img);
                        ticket_item2_title_tv.setText(response.body().result.magam2.get(1).period);
                        ticket_item2_content_tv.setText(response.body().result.magam2.get(1).kind);
                        ticket_item2_price_tv.setText(response.body().result.magam2.get(1).product);
                        id_arrayllist.add(String.valueOf(response.body().result.magam2.get(1).util_num));
                        ////////////////////////BRAND 초기화//////////////////////////////////
//                        Glide.with(getApplicationContext())
//                                .load(response.body().mainPageData.mainProductDatas.get(4).image)
//                                .into(brand_item1_img);
                        brand_item1_title_tv.setText(response.body().result.magam3.get(0).period);
                        brand_item1_content_tv.setText(response.body().result.magam3.get(0).kind);
                        brand_item1_price_tv.setText(response.body().result.magam3.get(0).product);
                        id_arrayllist.add(String.valueOf(response.body().result.magam3.get(0).brand_num));
//                        Glide.with(getApplicationContext())
//                                .load(response.body().mainPageData.mainProductDatas.get(5).image)
//                                .into(brand_item2_img);
                        brand_item2_title_tv.setText(response.body().result.magam3.get(1).period);
                        brand_item2_content_tv.setText(response.body().result.magam3.get(1).kind);
                        brand_item2_price_tv.setText(response.body().result.magam3.get(1).product);
                        id_arrayllist.add(String.valueOf(response.body().result.magam3.get(1).brand_num));
                        ///////////////////////SMART 초기화/////////////////////////////////
//                        Glide.with(getApplicationContext())
//                                .load(response.body().mainPageData.mainProductDatas.get(6).image)
//                                .into(smart_item1_img);
                        smart_item1_title_tv.setText(response.body().result.magam4.get(0).period);
                        smart_item1_content_tv.setText(response.body().result.magam4.get(0).kind);
                        smart_item1_price_tv.setText(response.body().result.magam4.get(0).product);
                        id_arrayllist.add(String.valueOf(response.body().result.magam4.get(0).smart_num));
//                        Glide.with(getApplicationContext())
//                                .load(response.body().mainPageData.mainProductDatas.get(7).image)
//                                .into(smart_item2_img);
                        smart_item2_title_tv.setText(response.body().result.magam4.get(1).period);
                        smart_item2_content_tv.setText(response.body().result.magam4.get(1).kind);
                        smart_item2_price_tv.setText(response.body().result.magam4.get(1).product);
                        id_arrayllist.add(String.valueOf(response.body().result.magam4.get(1).smart_num));
                        ///////////////////////ETC 초기화/////////////////////////////////
//                        Glide.with(getApplicationContext())
//                                .load(response.body().mainPageData.mainProductDatas.get(8).image)
//                                .into(etc_item1_img);
                        etc_item1_title_tv.setText(response.body().result.magam5.get(0).period);
                        etc_item1_content_tv.setText(response.body().result.magam5.get(0).kind);
                        etc_item1_price_tv.setText(response.body().result.magam5.get(0).product);
                        id_arrayllist.add(String.valueOf(response.body().result.magam5.get(0).etc_num));
//                        Glide.with(getApplicationContext())
//                                .load(response.body().mainPageData.mainProductDatas.get(8).image)
//                                .into(etc_item2_img);
                        etc_item2_title_tv.setText(response.body().result.magam5.get(1).period);
                        etc_item2_content_tv.setText(response.body().result.magam5.get(1).kind);
                        etc_item2_price_tv.setText(response.body().result.magam5.get(1).product);
                        id_arrayllist.add(String.valueOf(response.body().result.magam5.get(1).etc_num));
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Mainpage Error1", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MainPageResult> call, Throwable t)
            {
                Toast.makeText(getApplicationContext(), "Mainpage Error2", Toast.LENGTH_SHORT).show();
                Log.i("myTag", t.toString());
            }
        });
    }
}
