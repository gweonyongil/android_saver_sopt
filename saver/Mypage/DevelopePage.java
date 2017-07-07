package com.sopt.saver.saver.Mypage;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sopt.saver.saver.R;

public class DevelopePage extends AppCompatActivity {

    private TextView navi, n1, n2, plan, jh, design, hwd, hj, server, yh, cj, and, yl, hl, hwa, ios, ss, sm;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_develope_page);

        navi = (TextView)findViewById(R.id.develope_navi);
        n1 = (TextView)findViewById(R.id.develope_notice1);
        n2 = (TextView)findViewById(R.id.develope_notice2);
        plan = (TextView)findViewById(R.id.develope_ceo);
        jh = (TextView)findViewById(R.id.develope_jh);
        design = (TextView)findViewById(R.id.develope_design);
        hwd = (TextView)findViewById(R.id.develope_hw_d);
        hj = (TextView)findViewById(R.id.develope_hj);
        yh = (TextView)findViewById(R.id.develope_yh);
        cj = (TextView)findViewById(R.id.develope_cj);
        and  = (TextView)findViewById(R.id.develope_android);
        yl = (TextView)findViewById(R.id.develope_yl);
        hl = (TextView)findViewById(R.id.develope_hl);
        hwa = (TextView)findViewById(R.id.develope_hw_a);
        ios=(TextView)findViewById(R.id.develope_ios);
        ss=(TextView)findViewById(R.id.develope_ss);
        sm=(TextView)findViewById(R.id.develope_sm);
        back = (ImageButton)findViewById(R.id.develope_back_btn);
        server = (TextView)findViewById(R.id.develope_server);

        /////폰트설정///
        Typeface typeface_r = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Regular.otf");
        Typeface typeface_m = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Medium.otf");
        Typeface typeface_b = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Bold.otf");

        navi.setTypeface(typeface_b);
        n1.setTypeface(typeface_r);
        n2.setTypeface(typeface_r);
        plan.setTypeface(typeface_r);
        jh.setTypeface(typeface_r);
        design.setTypeface(typeface_r);
        hwd.setTypeface(typeface_r);
        hj.setTypeface(typeface_r);
        server.setTypeface(typeface_r);
        yh.setTypeface(typeface_r);
        cj.setTypeface(typeface_r);
        and.setTypeface(typeface_r);
        yl.setTypeface(typeface_r);
        hl.setTypeface(typeface_r);
        hwa.setTypeface(typeface_r);
        ios.setTypeface(typeface_r);
        ss.setTypeface(typeface_r);
        sm.setTypeface(typeface_r);

        ///페이지이동
        findViewById(R.id.develope_back_btn).setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
    }
}
