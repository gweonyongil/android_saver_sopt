package com.sopt.saver.saver;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;

public class SignUpActivity extends AppCompatActivity {

    /*
    private EditText id_edit, pwd_edit, name_edit, major_edit;
    private RadioGroup part_Radio, jender_Radio;
    private Button submit_btn, reset_btn;
    private RadioButton temppart, tempjender;
    */

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

        //Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

        /*
        id_edit = (EditText) findViewById(R.id.id_edit);
        pwd_edit = (EditText) findViewById(R.id.pwd_edit);
        name_edit = (EditText) findViewById(R.id.name_edit);
        major_edit = (EditText) findViewById(R.id.major_edit);

        part_Radio = (RadioGroup) findViewById(part_Radio);
        jender_Radio = (RadioGroup) findViewById(jender_Radio);

        submit_btn = (Button) findViewById(submit_btn);
        reset_btn = (Button) findViewById(reset_btn);

        submit_btn.setOnClickListener(this);
        reset_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case submit_btn:
                temppart = (RadioButton) findViewById(part_Radio.getCheckedRadioButtonId());      //getCheckedRadioButtonId() 메소드를 통해 선택된 버튼의 아이디값을 얻어낸다
                tempjender = (RadioButton) findViewById(jender_Radio.getCheckedRadioButtonId());

                //유효성 검사 ( 엽력정보 공백 여부 파악)

                if (id_edit.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Id을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    id_edit.requestFocus();                 // requestFocus() id_edittext로 focus 이동
                    return;
                }
                if (pwd_edit.length() == 0) {
                    Toast.makeText(getApplicationContext(), "pwd을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    pwd_edit.requestFocus();
                    return;
                }
                if (name_edit.length() == 0) {
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    name_edit.requestFocus();
                    return;
                }
                if (major_edit.length() == 0) {
                    Toast.makeText(getApplicationContext(), "전공을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    major_edit.requestFocus();
                    return;
                }
                if (temppart == null) {
                    Toast.makeText(getApplicationContext(), "파트를 선택해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (tempjender == null) {
                    Toast.makeText(getApplicationContext(), "성별을 선택해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }


                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.putExtra("id", String.valueOf(id_edit.getText()));
                intent.putExtra("pwd", String.valueOf(pwd_edit.getText()));
                intent.putExtra("name", String.valueOf(name_edit.getText()));
                intent.putExtra("major", String.valueOf(major_edit.getText()));
                intent.putExtra("part", String.valueOf(temppart.getText()));
                intent.putExtra("jender", String.valueOf(tempjender.getText()));
                startActivity(intent);
                finish();
                break;

            case reset_btn:
                id_edit.setText("");
                pwd_edit.setText("");
                name_edit.setText("");
                major_edit.setText("");
                part_Radio.clearCheck();
                jender_Radio.clearCheck();
                break;
                }
        }
    */
    }

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
