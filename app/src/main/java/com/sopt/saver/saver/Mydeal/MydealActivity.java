package com.sopt.saver.saver.Mydeal;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.sopt.saver.saver.Network.NetworkService;
import com.sopt.saver.saver.R;
import com.sopt.saver.saver.application.ApplicationController;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MydealActivity extends AppCompatActivity {
    ViewPager viewPager;
    MydealPagerAdapter mydealPagerAdapter;
    TabLayout tabLayout;

    private NetworkService service;
    String test_value1;
    String test_value2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydeal_view);
        ////////////////////네트워킹/////////////////////////
        service = ApplicationController.getInstance().getNetworkService();
        ///////////////////////객체 초기화///////////////////////////
        viewPager = (ViewPager)findViewById(R.id.mydeal_viewpager);
        tabLayout = (TabLayout)findViewById(R.id.mydeal_tab_layout);
        /////////////////////인텐트 데이터전달//////////////////////

        //////////////////////////////////////////////////////////////
        tabLayout.addTab(tabLayout.newTab().setText("내가 쓴 글"));
        tabLayout.addTab(tabLayout.newTab().setText("내가 댓글 쓴 글"));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        mydealPagerAdapter = new MydealPagerAdapter(getSupportFragmentManager(), 2);
        viewPager.setAdapter(mydealPagerAdapter);
        viewPager.setCurrentItem(0);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        if (savedInstanceState == null) {
            //처음 CreateView시 정보 전달...역할
            Bundle bundle = new Bundle();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            MydealWriteFragment mydealWriteFragment = new MydealWriteFragment();

            transaction.add(R.id.mydeal_viewpager, mydealWriteFragment , null);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        /////////////////////////서버 통신 시작////////////////////////////////
        //////////////////WRITE////////////////
        Call<Mydeal_ProductResult> requestWriteInfo = service.getMydealProductResult(test_value1);
        requestWriteInfo.enqueue(new Callback<Mydeal_ProductResult>() {
            @Override
            public void onResponse(Call<Mydeal_ProductResult> call, Response<Mydeal_ProductResult> response) {
                if(response.isSuccessful())
                {

                }
                else
                {

                }
            }
            @Override
            public void onFailure(Call<Mydeal_ProductResult> call, Throwable t) {

            }
        });
        ///////////////COMMENT/////////////////
        Call<Mydeal_ProductResult> requestCommentInfo = service.getMydealProductResult(test_value2);
        requestCommentInfo.enqueue(new Callback<Mydeal_ProductResult>() {
            @Override
            public void onResponse(Call<Mydeal_ProductResult> call, Response<Mydeal_ProductResult> response) {
                if(response.isSuccessful())
                {

                }
                else
                {

                }
            }
            @Override
            public void onFailure(Call<Mydeal_ProductResult> call, Throwable t) {

            }
        });
    }
}
