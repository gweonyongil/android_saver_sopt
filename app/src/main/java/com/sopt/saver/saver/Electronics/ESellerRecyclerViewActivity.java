package com.sopt.saver.saver.Electronics;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sopt.saver.saver.ImageLoadTask;
import com.sopt.saver.saver.Network.NetworkService;
import com.sopt.saver.saver.R;
import com.sopt.saver.saver.application.ApplicationController;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ESellerRecyclerViewActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private ArrayList<ESellerData> eDatas;
    private LinearLayoutManager mLayoutManager;
    private ESellerRecyclerAdapter adapter;
    private TextView product_time_tv;
    private TextView product_user_id_tv;
    private TextView product_comment_num_tv;
    private TextView product_dday_tv;
    private ImageView product_iv;
    private TextView product_tv1;
    private TextView product_tv2;
    private TextView product_tv3;
    private TextView product_tv4;
    private TextView product_tv5;
    private TextView product_tv6;
    private TextView product_tv7;
    private TextView product_tv8;
    private Button product_answer_btn;

    private ImageView writeImg;
    private ImageView findImg;
    private ImageView homeImg;
    private ImageView cateImg;
    private ImageView messageImg;
    private ImageView mydealImg;
    private SwipeRefreshLayout refreshLayout;
    NetworkService service;
    //////////////intent 통해서 받은 변수/////////////
    String id;
    String userid;
    //Back 키 두번 클릭 여부 확인
    private final long FINSH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics_seller);
        Log.i("Tag", "메인");
        ////////////////////////서비스 객체 초기화////////////////////////
        service = ApplicationController.getInstance().getNetworkService();
        ////////////////////////뷰 객체 초기화////////////////////////
        product_user_id_tv = (TextView) findViewById(R.id.electronics_prodInfo_user_id_tv);
        product_time_tv = (TextView) findViewById(R.id.electronics_prodInfo_time_text);
        product_dday_tv = (TextView) findViewById(R.id.electronics_prodInfo_item_image1_text);
        product_comment_num_tv = (TextView) findViewById(R.id.electronics_prodInfo_item_image2_text);
        product_iv = (ImageView) findViewById(R.id.electronics_prodInfo_item_img);
        product_tv1 = (TextView) findViewById(R.id.electronics_prodInfo_item_text1);
        product_tv2 = (TextView) findViewById(R.id.electronics_prodInfo_item_text2);
        product_tv3 = (TextView) findViewById(R.id.electronics_prodInfo_item_text3);
        product_tv4 = (TextView) findViewById(R.id.electronics_prodInfo_item_text4);
        product_tv5 = (TextView) findViewById(R.id.electronics_prodInfo_item_text5);
        product_tv6 = (TextView) findViewById(R.id.electronics_prodInfo_item_text6);
        product_tv7 = (TextView) findViewById(R.id.electronics_prodInfo_item_text7);
        product_tv8 = (TextView) findViewById(R.id.electronics_prodInfo_item_text8);
        product_answer_btn = (Button) findViewById(R.id.electronics_answer_btn);

        writeImg = (ImageView) findViewById(R.id.electronics_write_img);
        findImg = (ImageView) findViewById(R.id.electronics_find_img);
        homeImg = (ImageView) findViewById(R.id.electronics_home_img);
        cateImg = (ImageView) findViewById(R.id.electronics_category_img);
        messageImg = (ImageView) findViewById(R.id.electronics_message_img);
        mydealImg = (ImageView) findViewById(R.id.electronics_message_img);
        recyclerView = (RecyclerView) findViewById(R.id.electronics_recycler_view);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.RefreshLayout);
        recyclerView.setHasFixedSize(true);
        refreshLayout.setOnRefreshListener(this);
        ////////////////////////레이아웃 매니저 설정////////////////////////
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        ////////////////////////각 배열에 모델 개체를 가지는 ArrayList 초기화////////////////////////
        eDatas = new ArrayList<ESellerData>();
        ////////////////////////리사이클러 뷰와 어뎁터 연동////////////////////////
        //아이디값 전달받기
        Intent intent = getIntent();
        id = intent.getExtras().getString("id");
        userid = intent.getExtras().getString("userid");
        ////////////////////////파라미터로 위의 ArrayList와 클릭이벤트////////////////////////

        adapter = new ESellerRecyclerAdapter(eDatas, clickEvent, open_btn_clickEvent);
        recyclerView.setAdapter(adapter);
        ////////////////////////리스트 목록 추가 버튼에 리스너 설정////////////////////////

        writeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                //startActivity(intent);
            }
        });
        findImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        homeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cateImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        messageImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mydealImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /*
          OnCreate()- 생명주기 내의 통신
         액티비티가 지워지고 재생성 되지않는 이상 한 번만 실행됩니다.
         이러한 이유로 아래 쪽에 OnRestart()를 오버라이드 하여 메인액티비티가 재실행되는 경우
          리스트를 갱신합니다 아래에 있어요!!

          통신부는 따로 정리해서 올려드리겠습니다!!
         */
        //Seller RecyclerView 서버 연동
        Call<ESellerResult> requestElectronicsSellerData = service.getElectronicsSellerResult(id);
        requestElectronicsSellerData.enqueue(new Callback<ESellerResult>() {
            @Override
            public void onResponse(Call<ESellerResult> call, Response<ESellerResult> response) {
                if (response.isSuccessful()) {
                    if (response.body().message.equals("ok")) {
                        eDatas = response.body().result;
                        adapter.setAdapter(eDatas);
                    }
                }
            }

            @Override
            public void onFailure(Call<ESellerResult> call, Throwable t) {
                Log.i("fail", t.getMessage());
            }
        });
        //ProductData 서버 연동
        Call<EProductResult> requestElectronicsProductData = service.getElectronicsProductResult(id);
        requestElectronicsProductData.enqueue(new Callback<EProductResult>() {
            @Override
            public void onResponse(Call<EProductResult> call, Response<EProductResult> response) {
                if (response.isSuccessful()) {
                    if (response.body().message.equals("ok")) {
                        product_user_id_tv.setText(response.body().result.userid);
                        product_time_tv.setText(response.body().result.time);
                        product_dday_tv.setText(response.body().result.dday);
                        product_comment_num_tv.setText(response.body().result.comcount);
                        new ImageLoadTask(response.body().result.image, product_iv).execute();
                        product_tv1.setText(response.body().result.title);
                        product_tv2.setText(response.body().result.category);
                        product_tv3.setText(response.body().result.kind);
                        product_tv4.setText(response.body().result.product);
                        product_tv5.setText(response.body().result.price);
                        product_tv6.setText(response.body().result.url);
                        product_tv7.setText(response.body().result.explantion);
                        product_tv8.setText(response.body().result.addInformation);
                    }
                }
            }

            @Override
            public void onFailure(Call<EProductResult> call, Throwable t) {
                Log.i("fail", t.getMessage());
            }
        });
    }

    /*
    onRestart()를 오버라이드하여 onPause -> onRestart 시
    리스트를 갱신하는 ListReload 메소드를 실행!!
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        ListReload();
    }

    /*
    리스트를 당기면 갱신되는 메소드입니다 사용하기 위해서
    implements SwipeRefreshLayout.OnRefreshListener 와
     xml에서 리스트를 감싸는 SwipeRefreshLayout 가 필요합니다!!
     */
    @Override
    public void onRefresh() {
        ListReload();
        refreshLayout.setRefreshing(false);
        Toast.makeText(getApplicationContext(), "페이지 리로드", Toast.LENGTH_SHORT).show();
    }

    /*
    리스트를 갱신하는 메소드입니다.
     */
    public void ListReload() {
        Call<ESellerResult> requestMainData = service.getElectronicsSellerResult(id);
        requestMainData.enqueue(new Callback<ESellerResult>() {
            @Override
            public void onResponse(Call<ESellerResult> call, Response<ESellerResult> response) {

                if (response.isSuccessful()) {
                    if (response.body().message.equals("ok")) {
                        eDatas = response.body().result;
                        adapter.setAdapter(eDatas);
                    }
                }
            }

            @Override
            public void onFailure(Call<ESellerResult> call, Throwable t) {

            }
        });
    }

    ////////////////////////클릭 이벤트 정의////////////////////////
    public View.OnClickListener clickEvent = new View.OnClickListener() {
        public void onClick(View v) {
            int itemPosition = recyclerView.getChildPosition(v);
            int tempId = eDatas.get(itemPosition).id;
            //열람하기(자기 자신, 자기가 아닐 때)

            //Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            //intent.putExtra("id", String.valueOf(tempId));
            //startActivity(intent);
        }
    };
    public View.OnClickListener open_btn_clickEvent = new View.OnClickListener() {
        public void onClick(View v) {
            int itemPosition = recyclerView.getChildPosition(v);
            int tempId = eDatas.get(itemPosition).id;
            //열람하기(자기 자신, 자기가 아닐 때) 다이어로그 1, 다이어로그 2
            Call<UserCheckResult> requestUserCheck = service.getUserCheck(userid);
            requestUserCheck.enqueue(new Callback<UserCheckResult>() {
                @Override
                public void onResponse(Call<UserCheckResult> call, Response<UserCheckResult> response) {
                    if (response.isSuccessful()) {
                        if (response.body().message.equals("ok")) {
                            CheckOkDialog okdialog = new CheckOkDialog();
                            okdialog.show();
                        } else {
                            CheckFailDialog faildialog = new CheckFailDialog();
                            faildialog.show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<UserCheckResult> call, Throwable t) {

                }
            });
        }
    };

    public class CheckOkDialog extends Dialog implements DialogInterface.OnClickListener {
        Button okButton;
        Button cancelButton;

        public CheckOkDialog() {
            super(ESellerRecyclerViewActivity.this);
            setContentView(R.layout.dialog_checkok);
            okButton = (Button) findViewById(R.id.dialog_checkok_ok_btn);
            cancelButton = (Button) findViewById(R.id.dialog_checkok_cancel_btn);
        }

        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == 1) {

            } else {

            }
        }
    }
    public class CheckFailDialog extends Dialog implements DialogInterface.OnClickListener {
        Button okButton;
        Button cancelButton;

        public CheckFailDialog() {
            super(ESellerRecyclerViewActivity.this);
            setContentView(R.layout.dialog_checkfail);
            okButton = (Button) findViewById(R.id.dialog_checkfail_ok_btn);
            cancelButton = (Button) findViewById(R.id.dialog_checkfail_cancel_btn);
        }

        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == 1) {

            } else {

            }
        }
    }
}
