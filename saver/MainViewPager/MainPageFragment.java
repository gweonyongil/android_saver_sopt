package com.sopt.saver.saver.MainViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sopt.saver.saver.API.SetFontClass;
import com.sopt.saver.saver.Electronics.ESellerListViewActivity;
import com.sopt.saver.saver.MainPage.MainPageResult;
import com.sopt.saver.saver.Mypage.MyPageActivity;
import com.sopt.saver.saver.Network.NetworkService;
import com.sopt.saver.saver.R;
import com.sopt.saver.saver.Write.WritePageActivity;
import com.sopt.saver.saver.application.ApplicationController;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainPageFragment extends Fragment {
    //////////////MAIN//////////////////////
    private TextView main_tv1;
    private TextView main_tv2;
    private TextView people_tv;
    private TextView comment_tv;
    private TextView success_tv;
    private TextView main_sub_tv1;
    private TextView main_sub_tv2;
    private TextView main_sub_tv3;
    private TextView elec_tv;
    private TextView util_tv;
    private TextView brand_tv;
    private TextView smart_tv;
    private TextView etc_tv;

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
    private ArrayList<String> id_arrayllist;
    private String user_num;
    private String id;
    private Context context;
    private AssetManager assetManager;

    public MainPageFragment() {
        super();
    }

    //////////////////메소드//////////////////////
    public void setContext(Context context) {
        this.context = context;
    }

    public void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public void setUserData(String id, String user_num) {
        this.id = id;
        this.user_num = user_num;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_main_page, container, false);
        ////////////////////////arraylist 초기화///////////////////////
        id_arrayllist = new ArrayList<String>();
        ///////////////////////서비스 초기화///////////////////////////
        service = ApplicationController.getInstance().getNetworkService();
        ///////////////////////////Intent/////////////////////////////
//        id = getIntent().getExtras().getString("id");
//        user_num = getIntent().getExtras().getString("user_num");
        ///////////////////메인 TEXT/////////////////////////////////////
        main_tv1 = (TextView) view.findViewById(R.id.main_page_main_tv1);
        main_tv2 = (TextView) view.findViewById(R.id.main_page_main_tv2);
        buy_btn = (ImageButton) view.findViewById(R.id.mainpage_buy_btn);
        sell_btn = (ImageButton) view.findViewById(R.id.mainpage_sell_btn);
        people_tv = (TextView) view.findViewById(R.id.mainpage_people_tv);
        comment_tv = (TextView) view.findViewById(R.id.mainpage_info_tv);
        success_tv = (TextView) view.findViewById(R.id.mainpage_success_tv);
        main_sub_tv1 = (TextView) view.findViewById(R.id.main_sub_tv1);
        main_sub_tv2 = (TextView) view.findViewById(R.id.main_sub_tv2);
        main_sub_tv3 = (TextView) view.findViewById(R.id.main_sub_tv3);
        elec_tv = (TextView) view.findViewById(R.id.main_elec_tv);
        util_tv = (TextView) view.findViewById(R.id.main_util_tv);
        brand_tv = (TextView) view.findViewById(R.id.main_brand_tv);
        smart_tv = (TextView) view.findViewById(R.id.main_smart_tv);
        etc_tv = (TextView) view.findViewById(R.id.main_etc_tv);
        ///////////////////////세부 LAYOUT 객체화////////////////////////
        elec_item1_layout = (LinearLayout) view.findViewById(R.id.elec_now_item1_layout);
        elec_item2_layout = (LinearLayout) view.findViewById(R.id.elec_now_item2_layout);
        ticket_item1_layout = (LinearLayout) view.findViewById(R.id.ticket_now_item1_layout);
        ticket_item2_layout = (LinearLayout) view.findViewById(R.id.ticket_now_item2_layout);
        brand_item1_layout = (LinearLayout) view.findViewById(R.id.brand_now_item1_layout);
        brand_item2_layout = (LinearLayout) view.findViewById(R.id.brand_now_item2_layout);
        smart_item1_layout = (LinearLayout) view.findViewById(R.id.smart_now_item1_layout);
        smart_item2_layout = (LinearLayout) view.findViewById(R.id.smart_now_item2_layout);
        etc_item1_layout = (LinearLayout) view.findViewById(R.id.etc_now_item1_layout);
        etc_item2_layout = (LinearLayout) view.findViewById(R.id.etc_now_item2_layout);
        ///////////////////////ELEC 초기화//////////////////////////////
        elec_item1_img = (ImageView) view.findViewById(R.id.elec_item1_img);
        elec_item1_title_tv = (TextView) view.findViewById(R.id.elec_item1_title_tv);
        elec_item1_content_tv = (TextView) view.findViewById(R.id.elec_item1_content_tv);
        elec_item1_price_tv = (TextView) view.findViewById(R.id.elec_item1_price_tv);
        elec_item2_img = (ImageView) view.findViewById(R.id.elec_item2_img);
        elec_item2_title_tv = (TextView) view.findViewById(R.id.elec_item2_title_tv);
        elec_item2_content_tv = (TextView) view.findViewById(R.id.elec_item2_content_tv);
        elec_item2_price_tv = (TextView) view.findViewById(R.id.elec_item2_price_tv);
        //////////////////////TICKET 초기화////////////////////////////////
        ticket_item1_img = (ImageView) view.findViewById(R.id.ticket_item1_img);
        ticket_item1_title_tv = (TextView) view.findViewById(R.id.ticket_item1_title_tv);
        ticket_item1_content_tv = (TextView) view.findViewById(R.id.ticket_item1_content_tv);
        ticket_item1_price_tv = (TextView) view.findViewById(R.id.ticket_item1_price_tv);
        ticket_item2_img = (ImageView) view.findViewById(R.id.ticket_item2_img);
        ticket_item2_title_tv = (TextView) view.findViewById(R.id.ticket_item2_title_tv);
        ticket_item2_content_tv = (TextView) view.findViewById(R.id.ticket_item2_content_tv);
        ticket_item2_price_tv = (TextView) view.findViewById(R.id.ticket_item2_price_tv);
        ////////////////////////BRAND 초기화//////////////////////////////////
        brand_item1_img = (ImageView) view.findViewById(R.id.brand_item1_img);
        brand_item1_title_tv = (TextView) view.findViewById(R.id.brand_item1_title_tv);
        brand_item1_content_tv = (TextView) view.findViewById(R.id.brand_item1_content_tv);
        brand_item1_price_tv = (TextView) view.findViewById(R.id.brand_item1_price_tv);
        brand_item2_img = (ImageView) view.findViewById(R.id.brand_item2_img);
        brand_item2_title_tv = (TextView) view.findViewById(R.id.brand_item2_title_tv);
        brand_item2_content_tv = (TextView) view.findViewById(R.id.brand_item2_content_tv);
        brand_item2_price_tv = (TextView) view.findViewById(R.id.brand_item2_price_tv);
        ///////////////////////SMART 초기화/////////////////////////////////
        smart_item1_img = (ImageView) view.findViewById(R.id.smart_item1_img);
        smart_item1_title_tv = (TextView) view.findViewById(R.id.smart_item1_title_tv);
        smart_item1_content_tv = (TextView) view.findViewById(R.id.smart_item1_content_tv);
        smart_item1_price_tv = (TextView) view.findViewById(R.id.smart_item1_price_tv);
        smart_item2_img = (ImageView) view.findViewById(R.id.smart_item2_img);
        smart_item2_title_tv = (TextView) view.findViewById(R.id.smart_item2_title_tv);
        smart_item2_content_tv = (TextView) view.findViewById(R.id.smart_item2_content_tv);
        smart_item2_price_tv = (TextView) view.findViewById(R.id.smart_item2_price_tv);
        ///////////////////////ETC 초기화/////////////////////////////////
        etc_item1_img = (ImageView) view.findViewById(R.id.etc_item1_img);
        etc_item1_title_tv = (TextView) view.findViewById(R.id.etc_item1_title_tv);
        etc_item1_content_tv = (TextView) view.findViewById(R.id.etc_item1_content_tv);
        etc_item1_price_tv = (TextView) view.findViewById(R.id.etc_item1_price_tv);
        etc_item2_img = (ImageView) view.findViewById(R.id.etc_item2_img);
        etc_item2_title_tv = (TextView) view.findViewById(R.id.etc_item2_title_tv);
        etc_item2_content_tv = (TextView) view.findViewById(R.id.etc_item2_content_tv);
        etc_item2_price_tv = (TextView) view.findViewById(R.id.etc_item2_price_tv);
        ////////////////폰트 적용////////////////////////////
        SetFontClass setFontClass = new SetFontClass(assetManager);
        main_tv1.setTypeface(setFontClass.getNotoSansBold());
        main_tv2.setTypeface(setFontClass.getNotoSansRegular());
        people_tv.setTypeface(setFontClass.getNotoSansBold());
        comment_tv.setTypeface(setFontClass.getNotoSansBold());
        success_tv.setTypeface(setFontClass.getNotoSansBold());
        main_sub_tv1.setTypeface(setFontClass.getNotoSansRegular());
        main_sub_tv2.setTypeface(setFontClass.getNotoSansRegular());
        main_sub_tv3.setTypeface(setFontClass.getNotoSansRegular());
        //////////////////////////////////////////////////////////
        elec_tv.setTypeface(setFontClass.getNotoSansRegular());
        util_tv.setTypeface(setFontClass.getNotoSansRegular());
        brand_tv.setTypeface(setFontClass.getNotoSansRegular());
        smart_tv.setTypeface(setFontClass.getNotoSansRegular());
        etc_tv.setTypeface(setFontClass.getNotoSansRegular());
        ////////////////////////////////////////////////////////
        elec_item1_title_tv.setTypeface(setFontClass.getNotoSansBold());
        elec_item1_content_tv.setTypeface(setFontClass.getNotoSansRegular());
        elec_item1_price_tv.setTypeface(setFontClass.getNotoSansRegular());
        elec_item2_title_tv.setTypeface(setFontClass.getNotoSansBold());
        elec_item2_content_tv.setTypeface(setFontClass.getNotoSansRegular());
        elec_item2_price_tv.setTypeface(setFontClass.getNotoSansRegular());
        ////////////////////
        ticket_item1_title_tv.setTypeface(setFontClass.getNotoSansBold());
        ticket_item1_content_tv.setTypeface(setFontClass.getNotoSansRegular());
        ticket_item1_price_tv.setTypeface(setFontClass.getNotoSansRegular());
        ticket_item2_title_tv.setTypeface(setFontClass.getNotoSansBold());
        ticket_item2_content_tv.setTypeface(setFontClass.getNotoSansRegular());
        ticket_item2_price_tv.setTypeface(setFontClass.getNotoSansRegular());
        ////////////////////
        brand_item1_title_tv.setTypeface(setFontClass.getNotoSansBold());
        brand_item1_content_tv.setTypeface(setFontClass.getNotoSansRegular());
        brand_item1_price_tv.setTypeface(setFontClass.getNotoSansRegular());
        brand_item2_title_tv.setTypeface(setFontClass.getNotoSansBold());
        brand_item2_content_tv.setTypeface(setFontClass.getNotoSansRegular());
        brand_item2_price_tv.setTypeface(setFontClass.getNotoSansRegular());
        ////////////////////
        smart_item1_title_tv.setTypeface(setFontClass.getNotoSansBold());
        smart_item1_content_tv.setTypeface(setFontClass.getNotoSansRegular());
        smart_item1_price_tv.setTypeface(setFontClass.getNotoSansRegular());
        smart_item2_title_tv.setTypeface(setFontClass.getNotoSansBold());
        smart_item2_content_tv.setTypeface(setFontClass.getNotoSansRegular());
        smart_item2_price_tv.setTypeface(setFontClass.getNotoSansRegular());
        ////////////////////
        etc_item1_title_tv.setTypeface(setFontClass.getNotoSansBold());
        etc_item1_content_tv.setTypeface(setFontClass.getNotoSansRegular());
        etc_item1_price_tv.setTypeface(setFontClass.getNotoSansRegular());
        etc_item2_title_tv.setTypeface(setFontClass.getNotoSansBold());
        etc_item2_content_tv.setTypeface(setFontClass.getNotoSansRegular());
        etc_item2_price_tv.setTypeface(setFontClass.getNotoSansRegular());
        ////////////////클릭이벤트////////////////////////////
        view.findViewById(R.id.main_mypage_btn).setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), MyPageActivity.class);
                        intent.putExtra("id", id);
                        intent.putExtra("user_num", user_num);
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    }
                }
        );

        buy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent write_intent = new Intent(getActivity(), WritePageActivity.class);
                write_intent.putExtra("user_num", user_num);
                write_intent.putExtra("id", id);
                startActivity(write_intent);
            }
        });

        sell_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainViewPagerActivity) getActivity()).setCurrentPage(1);
            }
        });
        //////////////////ITEM LINEAR CLICK EVENT//////////////////
        elec_item1_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(id_arrayllist.get(0).equals("NONE"))) {
                    Intent intent = new Intent(getActivity(), ESellerListViewActivity.class);
                    intent.putExtra("thing_num", id_arrayllist.get(0));
                    intent.putExtra("user_num", user_num);
                    intent.putExtra("id", id);
                    intent.putExtra("category", "전자제품");
                    startActivity(intent);
                }
            }
        });
        elec_item2_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(id_arrayllist.get(1).equals("NONE"))) {
                    Intent intent = new Intent(getActivity(), ESellerListViewActivity.class);
                    intent.putExtra("thing_num", id_arrayllist.get(1));
                    intent.putExtra("user_num", user_num);
                    intent.putExtra("id", id);
                    intent.putExtra("category", "전자제품");
                    startActivity(intent);
                }
            }
        });
        ticket_item1_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(id_arrayllist.get(2).equals("NONE"))) {
                    Intent intent = new Intent(getActivity(), ESellerListViewActivity.class);
                    intent.putExtra("thing_num", id_arrayllist.get(2));
                    intent.putExtra("user_num", user_num);
                    intent.putExtra("id", id);
                    intent.putExtra("category", "티켓 및 이용권");
                    startActivity(intent);
                }
            }
        });
        ticket_item2_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(id_arrayllist.get(3).equals("NONE"))) {
                    Intent intent = new Intent(getActivity(), ESellerListViewActivity.class);
                    intent.putExtra("thing_num", id_arrayllist.get(3));
                    intent.putExtra("user_num", user_num);
                    intent.putExtra("id", id);
                    intent.putExtra("category", "티켓 및 이용권");
                    startActivity(intent);
                }
            }
        });
        brand_item1_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(id_arrayllist.get(4).equals("NONE"))) {
                    Intent intent = new Intent(getActivity(), ESellerListViewActivity.class);
                    intent.putExtra("thing_num", id_arrayllist.get(4));
                    intent.putExtra("user_num", user_num);
                    intent.putExtra("id", id);
                    intent.putExtra("category", "브랜드");
                    startActivity(intent);
                }
            }
        });
        brand_item2_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(id_arrayllist.get(5).equals("NONE"))) {
                    Intent intent = new Intent(getActivity(), ESellerListViewActivity.class);
                    intent.putExtra("thing_num", id_arrayllist.get(5));
                    intent.putExtra("user_num", user_num);
                    intent.putExtra("id", id);
                    intent.putExtra("category", "브랜드");
                    startActivity(intent);
                }
            }
        });
        smart_item1_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(id_arrayllist.get(6).equals("NONE"))) {
                    Intent intent = new Intent(getActivity(), ESellerListViewActivity.class);
                    intent.putExtra("thing_num", id_arrayllist.get(6));
                    intent.putExtra("user_num", user_num);
                    intent.putExtra("id", id);
                    intent.putExtra("category", "스마트폰 및 가입상품");
                    startActivity(intent);
                }
            }
        });
        smart_item2_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(id_arrayllist.get(7).equals("NONE"))) {
                    Intent intent = new Intent(getActivity(), ESellerListViewActivity.class);
                    intent.putExtra("thing_num", id_arrayllist.get(7));
                    intent.putExtra("user_num", user_num);
                    intent.putExtra("id", id);
                    intent.putExtra("category", "스마트폰 및 가입상품");
                    startActivity(intent);
                }
            }
        });
        etc_item1_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(id_arrayllist.get(8).equals("NONE"))) {
                    Intent intent = new Intent(getActivity(), ESellerListViewActivity.class);
                    intent.putExtra("thing_num", id_arrayllist.get(8));
                    intent.putExtra("user_num", user_num);
                    intent.putExtra("id", id);
                    intent.putExtra("category", "기타");
                    startActivity(intent);
                }
            }
        });
        etc_item2_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(id_arrayllist.get(9).equals("NONE"))) {
                    Intent intent = new Intent(getActivity(), ESellerListViewActivity.class);
                    intent.putExtra("thing_num", id_arrayllist.get(9));
                    intent.putExtra("user_num", user_num);
                    intent.putExtra("id", id);
                    intent.putExtra("category", "기타");
                    startActivity(intent);
                }
            }
        });
        ////////////////////////서버 통신///////////////////////////////////////
        Networking();
        /////////////////////////////////////
        return view;
    }
    public void Networking()
    {
        Call<MainPageResult> requestMainPage = service.getMainPageInfo();
        requestMainPage.enqueue(new Callback<MainPageResult>() {
            @Override
            public void onResponse(Call<MainPageResult> call, Response<MainPageResult> response) {
                if (response.isSuccessful()) {
                    if (response.body().message.equals("ok")) {
                        people_tv.setText(String.valueOf(response.body().usercount));
                        comment_tv.setText(String.valueOf(response.body().allcommentCount));
                        success_tv.setText(String.valueOf(response.body().informationCount));
                        /////////////////////////ELEC 초기화////////////////////////////////
                        try {
                            elec_item1_title_tv.setText(response.body().result.magam1.get(0).title);
                            elec_item1_content_tv.setText("상품 "
                                    + "[" + response.body().result.magam1.get(0).kind + "]" + response.body().result.magam1.get(0).product);
                            elec_item1_price_tv.setText("찾은가격 " + response.body().result.magam1.get(0).price);
                            id_arrayllist.add(String.valueOf(response.body().result.magam1.get(0).elec_num));
                        } catch (IndexOutOfBoundsException e) {
                            id_arrayllist.add(new String("NONE"));
                            elec_item1_layout.setVisibility(View.GONE);
                        }
                        try {
                            elec_item2_title_tv.setText(response.body().result.magam1.get(1).title);
                            elec_item2_content_tv.setText("상품 "
                                    + "[" + response.body().result.magam1.get(1).kind + "]" + response.body().result.magam1.get(1).product);
                            elec_item2_price_tv.setText("찾은가격 " + response.body().result.magam1.get(1).price);
                            id_arrayllist.add(String.valueOf(response.body().result.magam1.get(1).elec_num));
                        } catch (IndexOutOfBoundsException e) {
                            id_arrayllist.add(new String("NONE"));
                            elec_item2_layout.setVisibility(View.GONE);
                        }
                        //////////////////////TICKET 초기화////////////////////////////////
                        try {
                            ticket_item1_title_tv.setText(response.body().result.magam2.get(0).title);
                            ticket_item1_content_tv.setText("상품 "
                                    + "[" + response.body().result.magam2.get(0).kind + "]" + response.body().result.magam2.get(0).product);
                            ticket_item1_price_tv.setText("찾은가격 " + response.body().result.magam2.get(0).price);
                            id_arrayllist.add(String.valueOf(response.body().result.magam2.get(0).util_num));
                        } catch (IndexOutOfBoundsException e) {
                            id_arrayllist.add(new String("NONE"));
                            ticket_item1_layout.setVisibility(View.GONE);
                        }
                        try {
                            ticket_item2_title_tv.setText(response.body().result.magam2.get(1).title);
                            ticket_item2_content_tv.setText("상품 "
                                    + "[" + response.body().result.magam2.get(1).kind + "]" + response.body().result.magam2.get(1).product);
                            ticket_item2_price_tv.setText("찾은가격 " + response.body().result.magam2.get(1).price);
                            id_arrayllist.add(String.valueOf(response.body().result.magam2.get(1).util_num));
                        } catch (IndexOutOfBoundsException e) {
                            id_arrayllist.add(new String("NONE"));
                            ticket_item2_layout.setVisibility(View.GONE);
                        }
                        ////////////////////////BRAND 초기화//////////////////////////////////
                        try {
                            brand_item1_title_tv.setText(response.body().result.magam3.get(0).title);
                            brand_item1_content_tv.setText("상품 "
                                    + "[" + response.body().result.magam3.get(0).kind + "]" + response.body().result.magam3.get(0).product);
                            brand_item1_price_tv.setText("찾은가격 " + response.body().result.magam3.get(0).price);
                            id_arrayllist.add(String.valueOf(response.body().result.magam3.get(0).brand_num));
                        } catch (IndexOutOfBoundsException e) {
                            id_arrayllist.add(new String("NONE"));
                            brand_item1_layout.setVisibility(View.GONE);
                        }
                        try {
                            brand_item2_title_tv.setText(response.body().result.magam3.get(1).title);
                            brand_item2_content_tv.setText("상품 "
                                    + "[" + response.body().result.magam3.get(1).kind + "]" + response.body().result.magam3.get(1).product);
                            brand_item2_price_tv.setText("찾은가격 " + response.body().result.magam3.get(1).price);
                            id_arrayllist.add(String.valueOf(response.body().result.magam3.get(1).brand_num));
                        } catch (IndexOutOfBoundsException e) {
                            id_arrayllist.add(new String("NONE"));
                            brand_item2_layout.setVisibility(View.GONE);
                        }
                        ///////////////////////SMART 초기화/////////////////////////////////
                        try {
                            smart_item1_title_tv.setText(response.body().result.magam4.get(0).title);
                            smart_item1_content_tv.setText("상품 "
                                    + "[" + response.body().result.magam4.get(0).kind + "]" + response.body().result.magam4.get(0).product);
                            smart_item1_price_tv.setText("찾은가격 " + response.body().result.magam4.get(0).price);
                            id_arrayllist.add(String.valueOf(response.body().result.magam4.get(0).smart_num));
                        } catch (IndexOutOfBoundsException e) {
                            id_arrayllist.add(new String("NONE"));
                            smart_item1_layout.setVisibility(View.GONE);
                        }
                        try {
                            smart_item2_title_tv.setText(response.body().result.magam4.get(1).title);
                            smart_item2_content_tv.setText("상품 "
                                    + "[" + response.body().result.magam4.get(1).kind + "]" + response.body().result.magam4.get(1).product);
                            smart_item2_price_tv.setText("찾은가격 " + response.body().result.magam4.get(1).price);
                            id_arrayllist.add(String.valueOf(response.body().result.magam4.get(1).smart_num));
                        } catch (IndexOutOfBoundsException e) {
                            id_arrayllist.add(new String("NONE"));
                            smart_item2_layout.setVisibility(View.GONE);
                        }
                        ///////////////////////ETC 초기화/////////////////////////////////
                        try {
                            etc_item1_title_tv.setText(response.body().result.magam5.get(0).title);
                            etc_item1_content_tv.setText("상품 "
                                    + "[" + response.body().result.magam5.get(0).kind + "]" + response.body().result.magam5.get(0).product);
                            etc_item1_price_tv.setText("찾은가격 " + response.body().result.magam5.get(0).price);
                            id_arrayllist.add(String.valueOf(response.body().result.magam5.get(0).etc_num));
                        } catch (IndexOutOfBoundsException e) {
                            id_arrayllist.add(new String("NONE"));
                            etc_item1_layout.setVisibility(View.GONE);
                        }
                        try {
                            etc_item2_title_tv.setText(response.body().result.magam5.get(1).title);
                            etc_item2_content_tv.setText("상품 "
                                    + "[" + response.body().result.magam5.get(1).kind + "]" + response.body().result.magam5.get(1).product);
                            etc_item2_price_tv.setText("찾은가격 " + response.body().result.magam5.get(1).price);
                            id_arrayllist.add(String.valueOf(response.body().result.magam5.get(1).etc_num));
                        } catch (IndexOutOfBoundsException e) {
                            id_arrayllist.add(new String("NONE"));
                            etc_item2_layout.setVisibility(View.GONE);
                        }
                    }
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "CONNECTED BUT FAILED", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MainPageResult> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(), "FAILED", Toast.LENGTH_SHORT).show();
                Log.i("myTag", t.toString());
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        Networking();
    }
}
