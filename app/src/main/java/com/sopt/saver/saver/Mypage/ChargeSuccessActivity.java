package com.sopt.saver.saver.Mypage;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sopt.saver.saver.R;

import java.text.DecimalFormat;

public class ChargeSuccessActivity extends AppCompatActivity {

    private TextView charge2_navi;
    private TextView charge2_h1;
    private TextView charge2_money_txt;
    private TextView charge2_money;
    private TextView charge2_how_txt;
    private TextView charge2_how;
    private TextView charge2_bank;
    private TextView charge2_account;
    private TextView charge2_ownername;
    private TextView charge2_date_txt;
    private TextView charge2_date;
    private TextView charge2_name_txt;
    private TextView charge2_name;
    private TextView charge2_chargemoney_txt;
    private TextView charge2_chargemoney;
    private TextView charge2_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charge_success);

        charge2_navi = (TextView)findViewById(R.id.charge2_navi);
        charge2_h1 = (TextView)findViewById(R.id.charge2_h1);
        charge2_money_txt = (TextView)findViewById(R.id.charge2_money_txt);
        charge2_money = (TextView)findViewById(R.id.charge2_money);
        charge2_how_txt = (TextView)findViewById(R.id.charge2_how_txt);
        charge2_how = (TextView)findViewById(R.id.charge2_money_input);
        charge2_bank = (TextView)findViewById(R.id.charge2_bank);
        charge2_account = (TextView)findViewById(R.id.charge2_account);
        charge2_ownername = (TextView)findViewById(R.id.charge2_ownername);
        charge2_date_txt = (TextView)findViewById(R.id.charge2_date_txt);
        charge2_date = (TextView)findViewById(R.id.charge2_date);
        charge2_name_txt = (TextView)findViewById(R.id.charge2_name_txt);
        charge2_name = (TextView)findViewById(R.id.charge2_name);
        charge2_chargemoney_txt = (TextView)findViewById(R.id.charge2_charge_money_txt);
        charge2_chargemoney = (TextView)findViewById(R.id.charge2_charge_money);
        charge2_sub = (TextView)findViewById(R.id.charge2_sub);

        /////폰트적용//////
        Typeface typeface_r = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Regular.otf");
        Typeface typeface_m = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Medium.otf");
        Typeface typeface_b = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Bold.otf");

        charge2_navi.setTypeface(typeface_b);
        charge2_h1.setTypeface(typeface_b);
        charge2_money_txt.setTypeface(typeface_r);
        charge2_money.setTypeface(typeface_r);
        charge2_how_txt.setTypeface(typeface_r);
        charge2_how.setTypeface(typeface_r);
        charge2_bank.setTypeface(typeface_r);
        charge2_account.setTypeface(typeface_r);
        charge2_ownername.setTypeface(typeface_r);
        charge2_date_txt.setTypeface(typeface_r);
        charge2_date.setTypeface(typeface_r);
        charge2_name_txt.setTypeface(typeface_r);
        charge2_name.setTypeface(typeface_r);
        charge2_chargemoney_txt.setTypeface(typeface_r);
        charge2_chargemoney.setTypeface(typeface_r);
        charge2_sub.setTypeface(typeface_r);

        Intent intent = getIntent();
        String charge_price = intent.getStringExtra("charge_pay");

        if(!charge_price.contains(",")){
            long value = Long.parseLong(charge_price);
            DecimalFormat format = new DecimalFormat("###,###");
            format.format(value);
            charge_price = format.format(value);
        }

        charge2_money.setText(charge_price + " P");
        charge2_chargemoney.setText(charge_price + " 원");

        ///이전 페이지 이동
        findViewById(R.id.charge2_charge_btn).setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), ChargePageActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
