package com.sopt.saver.saver.Mydeal;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.sopt.saver.saver.Network.NetworkService;
import com.sopt.saver.saver.R;
import com.sopt.saver.saver.application.ApplicationController;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MydealRecyclerViewActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener{
    private RecyclerView recyclerView;
    private ArrayList<Mydeal_ProductData> mDatas;
    private LinearLayoutManager mLayoutManager;
    private MydealRecyclerAdapter adapter;
    private ImageView homeImg;
    private ImageView cateImg;
    private ImageView messageImg;
    private ImageView mydealImg;
    private SwipeRefreshLayout refreshLayout;
    private Mydeal_ProductData mdata;
    NetworkService service;
    private String id;

    private Button mywrite_btn;
    private Button mycomment_btn;

    //Back 키 두번 클릭 여부 확인
    private final long FINSH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydeal_recycler_view);
        Log.i("Tag", "메인");
        ////////////////////////서비스 객체 초기화////////////////////////
        service = ApplicationController.getInstance().getNetworkService();
        ////////////////////////뷰 객체 초기화////////////////////////
        homeImg = (ImageView)findViewById(R.id.mydeal_home_img);
        cateImg = (ImageView)findViewById(R.id.mydeal_category_img);
        messageImg = (ImageView)findViewById(R.id.mydeal_message_img);
        mydealImg = (ImageView)findViewById(R.id.mydeal_mydeal_img);
        recyclerView = (RecyclerView) findViewById(R.id.mydeal_recycler_view);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.RefreshLayout);
        recyclerView.setHasFixedSize(true);
        refreshLayout.setOnRefreshListener(this);
        mywrite_btn = (Button)findViewById(R.id.m_mywrite_btn);
        mycomment_btn = (Button)findViewById(R.id.m_mycomment_btn);
        ////////////////////////레이아웃 매니저 설정////////////////////////
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        ////////////////////////각 배열에 모델 개체를 가지는 ArrayList 초기화////////////////////////
        mDatas = new ArrayList<Mydeal_ProductData>();
        ////////////////////////리사이클러 뷰와 어뎁터 연동////////////////////////

        ////////////////////////파라미터로 위의 ArrayList와 클릭이벤트////////////////////////
        adapter = new MydealRecyclerAdapter(mDatas, clickEvent);
        recyclerView.setAdapter(adapter);
        ////////////////////////리스트 목록 추가 버튼에 리스너 설정////////////////////////
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
        mywrite_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mycomment_btn.setOnClickListener(new View.OnClickListener() {
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
        Call<Mydeal_ProductResult> requestElectronicsData = service.getMydealProductResult(id);
        requestElectronicsData.enqueue(new Callback<Mydeal_ProductResult>() {
            @Override
            public void onResponse(Call<Mydeal_ProductResult> call, Response<Mydeal_ProductResult> response) {
                if (response.isSuccessful()) {
                    if (response.body().message.equals("ok")) {
                        mDatas = response.body().result;
                        adapter.setAdapter(mDatas);
                    }
                }
            }

            @Override
            public void onFailure(Call<Mydeal_ProductResult> call, Throwable t) {
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
        Call<Mydeal_ProductResult> requestMainData = service.getMydealProductResult(id);
        requestMainData.enqueue(new Callback<Mydeal_ProductResult>() {
            @Override
            public void onResponse(Call<Mydeal_ProductResult> call, Response<Mydeal_ProductResult> response) {
                if (response.isSuccessful()) {
                    if (response.body().message.equals("ok")) {
                        mDatas = response.body().result;
                        adapter.setAdapter(mDatas);
                    }
                }
            }

            @Override
            public void onFailure(Call<Mydeal_ProductResult> call, Throwable t) {

            }
        });
    }
    ////////////////////////클릭 이벤트 정의////////////////////////
    public View.OnClickListener clickEvent =    new View.OnClickListener() {
        public void onClick(View v) {
            int itemPosition = recyclerView.getChildPosition(v);
            int tempId = mDatas.get(itemPosition).id;
            //Intent intent = new Intent(getApplicationContext(), ESellerRecyclerViewActivity.class);
            //intent.putExtra("id", String.valueOf(tempId));
            //startActivity(intent);
        }
    };
}
