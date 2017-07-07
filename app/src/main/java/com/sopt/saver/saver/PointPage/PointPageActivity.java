package com.sopt.saver.saver.PointPage;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.sopt.saver.saver.Mypage.ChargePageActivity;
import com.sopt.saver.saver.R;

public class PointPageActivity extends AppCompatActivity {

    private TextView point_navi = null;
    private TextView point_point = null;
    private TextView point_have = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_page);

        point_navi = (TextView)findViewById(R.id.point_navi);
        point_point = (TextView)findViewById(R.id.point_point);
        point_have = (TextView)findViewById(R.id.point_have);

        //폰트적용//
        Typeface typeface_r = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Regular.otf");
        Typeface typeface_b = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Bold.otf");

        point_navi.setTypeface(typeface_b);
        point_point.setTypeface(typeface_b);
        point_have.setTypeface(typeface_r);

        /////////////////////////////////////
        point_point.setText(getIntent().getExtras().getString("point"));
        findViewById(R.id.point_mypage_btn).setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );

        findViewById(R.id.point_charge_btn).setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), ChargePageActivity.class);
                        intent.putExtra("id", getIntent().getExtras().getString("id"));
                        intent.putExtra("user_num", getIntent().getExtras().getString("user_num"));
                        intent.putExtra("point", getIntent().getExtras().getString("point"));
                        startActivity(intent);
                    }
                }
        );
        ListView listview;
        PointPageListViewAdapter adapter;

        adapter = new PointPageListViewAdapter();

        listview = (ListView)findViewById(R.id.pointlistviews);
        listview.setAdapter(adapter);

        adapter.addItem("계좌");
        adapter.addItem("국민", "760702 04 082002");
        adapter.addItem("앱 설정");
        adapter.addItem("요구 환급액", 1);
        adapter.addItem("이용");
        adapter.addItem("이용내역 조회", 0);
        adapter.addItem("이용 총계", 0);
    }
}
