package com.sopt.saver.saver.Electronics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.sopt.saver.saver.Network.NetworkService;
import com.sopt.saver.saver.R;
import com.sopt.saver.saver.application.ApplicationController;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ERecyclerViewActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView recyclerView;
    private ArrayList<EItemData> eDatas;
    private LinearLayoutManager mLayoutManager;
    private ERecyclerAdapter adapter;
    private EditText search_et;
    private ImageView backImg;
    private ImageView writeImg;
    private ImageView findImg;
    private SwipeRefreshLayout refreshLayout;
    private EItemData edata;
    NetworkService service;
    //////intent 통해서 받아온 변수//////
    String category;
    String userid;

    //Back 키 두번 클릭 여부 확인
    private final long FINSH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);
        Log.i("Tag", "메인");
        ////////////////////////서비스 객체 초기화////////////////////////
        service = ApplicationController.getInstance().getNetworkService();
        ////////////////////////뷰 객체 초기화////////////////////////
        search_et = (EditText)findViewById(R.id.ER_search_et);
        backImg = (ImageView)findViewById(R.id.electronics_back_img);
        writeImg = (ImageView) findViewById(R.id.electronics_write_img);
        findImg = (ImageView) findViewById(R.id.electronics_find_img);
        recyclerView = (RecyclerView) findViewById(R.id.electronics_recycler_view);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.RefreshLayout);
        recyclerView.setHasFixedSize(true);
        refreshLayout.setOnRefreshListener(this);
        ////////////////////////레이아웃 매니저 설정////////////////////////
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        ////////////////////////각 배열에 모델 개체를 가지는 ArrayList 초기화////////////////////////
        eDatas = new ArrayList<EItemData>();
        //////////////////////TEST DISPLAY//////////////////////
        eDatas.add(new EItemData());
        eDatas.add(new EItemData());
        eDatas.add(new EItemData());
        eDatas.add(new EItemData());
        eDatas.add(new EItemData());
        ////////////////////////리사이클러 뷰와 어뎁터 연동////////////////////////

        ////////////////////////파라미터로 위의 ArrayList와 클릭이벤트////////////////////////
        adapter = new ERecyclerAdapter(eDatas, clickEvent);
        recyclerView.setAdapter(adapter);
        ////////////////////////리스트 목록 추가 버튼에 리스너 설정////////////////////////
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
                ///////////////////////EDIT TEXT 비쥬얼 변경//////////////////////
                
                ///////////////////////검색 시 서버와 통신////////////////////////
            }
        });
        /*
          OnCreate()- 생명주기 내의 통신
         액티비티가 지워지고 재생성 되지않는 이상 한 번만 실행됩니다.
         이러한 이유로 아래 쪽에 OnRestart()를 오버라이드 하여 메인액티비티가 재실행되는 경우
          리스트를 갱신합니다 아래에 있어요!!

          통신부는 따로 정리해서 올려드리겠습니다!!
         */
        category = getIntent().getExtras().getString("category");
        userid = getIntent().getExtras().getString("userid");
        Call<EItemResult> requestElectronicsData;
        requestElectronicsData = service.getElectronicsResult();//Default
        if (category.equals("img2")) {
            requestElectronicsData = service.getElectronicsResult();
        }
        else if (category.equals("img3")) {
            requestElectronicsData = service.getEBrandResult();
        }
        else if (category.equals("img4")) {
            requestElectronicsData = service.getEUtilResult();
        }
        else if (category.equals("img5")) {
            requestElectronicsData = service.getEEtcResult();
        }
        else{
            requestElectronicsData = service.getESmartResult();
        }
        requestElectronicsData.enqueue(new Callback<EItemResult>() {
            @Override
            public void onResponse(Call<EItemResult> call, Response<EItemResult> response) {
                if (response.isSuccessful()) {
                    if (response.body().message.equals("ok")) {
                        eDatas = response.body().result;
                        adapter.setAdapter(eDatas);
                    }
                }
            }

            @Override
            public void onFailure(Call<EItemResult> call, Throwable t) {
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
        Call<EItemResult> requestMainData = service.getElectronicsResult();
        requestMainData.enqueue(new Callback<EItemResult>() {
            @Override
            public void onResponse(Call<EItemResult> call, Response<EItemResult> response) {

                if (response.isSuccessful()) {
                    if (response.body().message.equals("ok")) {
                        eDatas = response.body().result;
                        adapter.setAdapter(eDatas);
                    }
                }
            }

            @Override
            public void onFailure(Call<EItemResult> call, Throwable t) {

            }
        });
    }

    ////////////////////////클릭 이벤트 정의////////////////////////
    public View.OnClickListener clickEvent = new View.OnClickListener() {
        public void onClick(View v) {
            int itemPosition = recyclerView.getChildPosition(v);
            int tempId = eDatas.get(itemPosition).id;
            Intent intent = new Intent(getApplicationContext(), ESellerRecyclerViewActivity.class);
            intent.putExtra("id", String.valueOf(tempId));
            intent.putExtra("userid", userid);
            startActivity(intent);
        }
    };
}
