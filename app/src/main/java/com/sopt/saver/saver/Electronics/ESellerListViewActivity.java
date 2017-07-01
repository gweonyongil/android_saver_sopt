package com.sopt.saver.saver.Electronics;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.sopt.saver.saver.Answer.AnswerActivity;
import com.sopt.saver.saver.DetailInfo.DetailActivity;
import com.sopt.saver.saver.Network.NetworkService;
import com.sopt.saver.saver.R;
import com.sopt.saver.saver.application.ApplicationController;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ESellerListViewActivity extends AppCompatActivity {

    private ArrayList<ESellerData> eDatas;
    private LinearLayoutManager mLayoutManager;
    private ImageView back_img;
    private NetworkService service;
    private ViewPager viewPager;
    private EProductInfoPagerAdapter pagerAdapter;
    private ListView listView;
    private ESellerListAdapter eSellerListAdapter;
    //////////////intent 통해서 받은 변수/////////////
    String id;
    String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eseller_list_view);
        ////////////////////////서비스 객체 초기화////////////////////////
        service = ApplicationController.getInstance().getNetworkService();
        ////////////////////////뷰 객체 초기화////////////////////////
        back_img = (ImageView)findViewById(R.id.eseller_back_img);
        listView = (ListView)findViewById(R.id.eseller_listview);
        ////////////////////ViewPager설정////////////////////////////////
        viewPager = (ViewPager) findViewById(R.id.ES_frame_layout);
        pagerAdapter = new EProductInfoPagerAdapter(getSupportFragmentManager());
        final EProductInfoFragment eprod_info_frag = new EProductInfoFragment();
        final EProductPictureFragment eprod_pict_frag = new EProductPictureFragment();
        ////////////////////////레이아웃 매니저 설정////////////////////////
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ////////////////////////각 배열에 모델 개체를 가지는 ArrayList 초기화////////////////////////
        eDatas = new ArrayList<ESellerData>();
        ////////////////////////TEST DISPLAY////////////////////////////////////
        EProductInfoFragment test_info_frag = new EProductInfoFragment();
        EProductPictureFragment test_pict_frag = new EProductPictureFragment();
        eDatas.add(new ESellerData());
        eDatas.add(new ESellerData());
        eDatas.add(new ESellerData());
        eDatas.add(new ESellerData());
        eDatas.add(new ESellerData());
        eDatas.add(new ESellerData());
        eDatas.add(new ESellerData());
        eDatas.add(new ESellerData());
        pagerAdapter.setData(test_info_frag, test_pict_frag);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(0);
        ///////////////////////////아이디값 전달받기//////////////////////
        Intent intent = getIntent();
        id = intent.getExtras().getString("id");
        userid = intent.getExtras().getString("userid");
        ////////////////////////파라미터로 위의 ArrayList와 클릭이벤트////////////////////////
        eSellerListAdapter = new ESellerListAdapter(eDatas, open_btn_clickEvent);
        listView.setAdapter(eSellerListAdapter);
        ////////////////////////리스트 목록 추가 버튼에 리스너 설정////////////////////////
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
                        eSellerListAdapter.setAdapter(eDatas);
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
                        Bundle bundle_prod_info = new Bundle();
                        Bundle bundle_pict_info = new Bundle();
                        bundle_prod_info.putString("userid", userid);
                        bundle_prod_info.putString("writer_user_id", response.body().result.userid);
                        bundle_prod_info.putString("time", response.body().result.time);
                        bundle_prod_info.putString("dday", response.body().result.dday);
                        bundle_prod_info.putString("comcount", response.body().result.comcount);
                        bundle_pict_info.putString("image", response.body().result.image);
                        bundle_prod_info.putString("text1", response.body().result.title);
                        bundle_prod_info.putString("text2", response.body().result.category);
                        bundle_prod_info.putString("text3", response.body().result.kind);
                        bundle_prod_info.putString("text4", response.body().result.product);
                        bundle_prod_info.putString("text5", response.body().result.price);
                        bundle_prod_info.putString("text6", response.body().result.url);
                        bundle_prod_info.putString("text7", response.body().result.explantion);
                        bundle_prod_info.putString("text8", response.body().result.addInformation);
                        eprod_info_frag.setArguments(bundle_prod_info);
                        eprod_pict_frag.setArguments(bundle_pict_info);
                        ////////////뷰페이저 첫페이지 초기화//////////////
                        pagerAdapter.setOnClickListener(new View.OnClickListener() {
                            //////////////답변하기///////////////
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ESellerListViewActivity.this, AnswerActivity.class);
                                intent.putExtra("id", id);
                                intent.putExtra("userid", id);
                                startActivity(intent);
                            }
                        });
                        pagerAdapter.setData(eprod_info_frag, eprod_pict_frag);
                        viewPager.setAdapter(pagerAdapter);
                        viewPager.setCurrentItem(0);
                    }
                }
            }

            @Override
            public void onFailure(Call<EProductResult> call, Throwable t) {
                Log.i("fail", t.getMessage());
            }
        });
    }
    public View.OnClickListener open_btn_clickEvent = new View.OnClickListener() {
        public void onClick(View v) {
//            int itemPosition = recyclerView.getChildPosition(v);
//            int tempId = eDatas.get(itemPosition).id;
            /////////////////////TEST DISPLAY///////////////////////
            CheckOkDialog okdialog = new CheckOkDialog();
            okdialog.show();
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
            super(ESellerListViewActivity.this);
            setContentView(R.layout.dialog_checkok);
            okButton = (Button) findViewById(R.id.dialog_checkok_ok_btn);
            okButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ESellerListViewActivity.this, DetailActivity.class);
                    intent.putExtra("userid", userid);
                    startActivity(intent);
                    dismiss();
                }
            });
            cancelButton = (Button) findViewById(R.id.dialog_checkok_cancel_btn);
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    }

    public class CheckFailDialog extends Dialog implements DialogInterface.OnClickListener {
        Button okButton;
        Button cancelButton;

        public CheckFailDialog() {
            super(ESellerListViewActivity.this);
            setContentView(R.layout.dialog_checkfail);
            okButton = (Button) findViewById(R.id.dialog_checkfail_ok_btn);
            okButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            cancelButton = (Button) findViewById(R.id.dialog_checkfail_cancel_btn);
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }

        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    }
}
