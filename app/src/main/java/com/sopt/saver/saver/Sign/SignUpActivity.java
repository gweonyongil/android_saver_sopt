package com.sopt.saver.saver.Sign;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.sopt.saver.saver.R;

public class SignUpActivity extends AppCompatActivity {


    private EditText id_edit, pwd_edit, name_edit, major_edit;
    private RadioGroup part_Radio, jender_Radio;
    private Button submit_btn, reset_btn;
    private RadioButton temppart, tempjender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tl_tabs);
        //viewpager
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_pager);

        //프래그먼트 배열 - 만들어 놓은 프래그먼트를 차례대로 넣어 준다.
        Fragment[] arrFragments = new Fragment[2];
        arrFragments[0] = new FirstFragment();
        arrFragments[1] = new SecondFragment();

        //어답터 생성후 연결 - 배열을 인자로 추가해 준다.
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), arrFragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    public View.OnClickListener submitclickEvent = new View.OnClickListener() {
        public void onClick(View v) {

        }
    };

    private class MyPagerAdapter extends FragmentPagerAdapter {

        private Fragment[] arrFragments;

        //생성자
        public MyPagerAdapter(FragmentManager fm, Fragment[] arrFragments) {
            super(fm);
            this.arrFragments = arrFragments;
        }

        @Override
        public Fragment getItem(int position) {
            return arrFragments[position];
        }

        @Override
        public int getCount() {
            return arrFragments.length;
        }

        //Tab의 타이틀 설정

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "First";
                case 1:
                    return "Second";
                default:
                    return "";
            }
            //return super.getPageTitle(position);
        }
    }
}
