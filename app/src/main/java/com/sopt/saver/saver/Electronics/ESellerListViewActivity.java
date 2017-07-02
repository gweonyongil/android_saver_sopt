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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    private TextView upperbar_tv;
    private ImageView back_img;
    private ImageView find_img;
    private ImageView write_img;
    private EditText find_et;
    private NetworkService service;
    private ViewPager viewPager;
    private EProductInfoPagerAdapter pagerAdapter;
    private ListView listView;
    private ESellerListAdapter eSellerListAdapter;
    //////////////intent 통해서 받은 변수/////////////
    String category;
    String thing_num;
    String user_num;
    String id;
    String writer_user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eseller_list_view);
        ////////////////////////서비스 객체 초기화////////////////////////
        service = ApplicationController.getInstance().getNetworkService();
        ////////////////////////뷰 객체 초기화////////////////////////
        upperbar_tv = (TextView) findViewById(R.id.esller_list_upperbar_tv);
        find_img = (ImageView) findViewById(R.id.esller_list_find_img);
        write_img = (ImageView) findViewById(R.id.esller_list_write_img);
        back_img = (ImageView) findViewById(R.id.eseller_list_back_img);
        listView = (ListView) findViewById(R.id.eseller_listview);
        find_et = (EditText) findViewById(R.id.esller_list_find_et);
        ////////////////////ViewPager설정////////////////////////////////
        View header = getLayoutInflater().inflate(R.layout.viewpager, null, false);
        viewPager = (ViewPager) header.findViewById(R.id.viewpager);
        pagerAdapter = new EProductInfoPagerAdapter(getSupportFragmentManager());
        final EProductInfoFragment eprod_info_frag = new EProductInfoFragment();
        final EProductPictureFragment eprod_pict_frag = new EProductPictureFragment();
        ////////////////////////레이아웃 매니저 설정////////////////////////
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ////////////////////////각 배열에 모델 개체를 가지는 ArrayList 초기화////////////////////////
        eDatas = new ArrayList<ESellerData>();
        ////////////////////////TEST DISPLAY////////////////////////////////////
//        EProductInfoFragment test_info_frag = new EProductInfoFragment();
//        EProductPictureFragment test_pict_frag = new EProductPictureFragment();
//        eDatas.add(new ESellerData());
//        eDatas.add(new ESellerData());
//        eDatas.add(new ESellerData());
//        eDatas.add(new ESellerData());
//        eDatas.add(new ESellerData());
//        eDatas.add(new ESellerData());
//        eDatas.add(new ESellerData());
//        eDatas.add(new ESellerData());
//        pagerAdapter.setData(test_info_frag, test_pict_frag);
//        viewPager.setAdapter(pagerAdapter);
//        viewPager.setCurrentItem(0);
        //////////////////////인텐트 통해서 아이디값 전달//////////////////////
        Intent intent = getIntent();
        category = intent.getExtras().getString("category");
        upperbar_tv.setText(category);
        thing_num = intent.getExtras().getString("thing_num");
        user_num = intent.getExtras().getString("user_num");
        id = intent.getExtras().getString("id");
        ////////////////////////파라미터로 위의 ArrayList와 클릭이벤트////////////////////////
        eSellerListAdapter = new ESellerListAdapter(eDatas, open_btn_clickEvent);
        listView.addHeaderView(header);
        listView.setAdapter(eSellerListAdapter);
        ////////////////////////리스트 목록 추가 버튼에 리스너 설정////////////////////////
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //Seller + Product 서버 연동
        Call<EDetailResult> requestElectronicsDetailData = service.getElectronicsDetailResult(thing_num);
        requestElectronicsDetailData.enqueue(new Callback<EDetailResult>() {
            @Override
            public void onResponse(Call<EDetailResult> call, Response<EDetailResult> response) {
                if (response.isSuccessful()) {
                    if (response.body().message.equals("ok")) {
                        Bundle bundle_prod_info = new Bundle();
                        Bundle bundle_pict_info = new Bundle();
                        bundle_prod_info.putString("id", id);
                        bundle_prod_info.putString("writer_user_id", response.body().result.info.id);
                        writer_user_id = response.body().result.info.id;
                        bundle_prod_info.putString("time", response.body().result.info.time);
                        bundle_prod_info.putString("dday", response.body().result.info.period);
                        bundle_prod_info.putString("comment_num", response.body().result.info.count);
                        bundle_pict_info.putString("image", response.body().result.info.image);
                        bundle_prod_info.putString("text1", response.body().result.info.title);
//                        bundle_prod_info.putString("text2", response.body().result.category);
                        bundle_prod_info.putString("text3", response.body().result.info.kind);
                        bundle_prod_info.putString("text4", response.body().result.info.product);
                        bundle_prod_info.putString("text5", response.body().result.info.price);
                        bundle_prod_info.putString("profileimage", response.body().result.info.profileimage);

                        bundle_pict_info.putString("image", response.body().result.info.image);

                        eprod_info_frag.setContext(getApplicationContext());
                        eprod_pict_frag.setContext(getApplicationContext());

                        eprod_info_frag.setArguments(bundle_prod_info);
                        eprod_pict_frag.setArguments(bundle_pict_info);
                        //////////뷰페이저 첫페이지 초기화//////////////
                        pagerAdapter.setData(eprod_info_frag, eprod_pict_frag);
                        viewPager.setAdapter(pagerAdapter);
                        viewPager.setCurrentItem(0);

                        eDatas = response.body().result.comment;
                        eSellerListAdapter.setAdapter(eDatas);
                        listView.setAdapter(eSellerListAdapter);
                    }
                } else {
                    Toast.makeText(ESellerListViewActivity.this, "HI2", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<EDetailResult> call, Throwable t) {
                Toast.makeText(ESellerListViewActivity.this, "HI", Toast.LENGTH_SHORT).show();
                Log.i("err", t.getMessage());
            }
        });
    }

    public View.OnClickListener open_btn_clickEvent = new View.OnClickListener() {
        public void onClick(View v) {
            /////////////////////TEST DISPLAY///////////////////////
            //열람하기(자기 자신, 자기가 아닐 때) 다이어로그 1, 다이어로그 2
            if(id.equals(writer_user_id))
            {
                CheckOkDialog okdialog = new CheckOkDialog();
                okdialog.show();
            }
            else
            {
                CheckFailDialog faildialog = new CheckFailDialog();
                faildialog.show();
            }
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
                    intent.putExtra("user_num", user_num);
                    intent.putExtra("id", id);
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
        }

        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    }
}
