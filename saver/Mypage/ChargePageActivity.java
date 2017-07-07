package com.sopt.saver.saver.Mypage;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sopt.saver.saver.Network.NetworkService;
import com.sopt.saver.saver.R;
import com.sopt.saver.saver.application.ApplicationController;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChargePageActivity extends AppCompatActivity {

    private TextView charge_navi = null;
    private TextView charge_point = null;
    private TextView charge_money_section = null;
    private TextView how_to_charge_section = null;
    private TextView charge_sub = null;
    private TextView charge_have_point = null;

    private TextView charge_no_account = null;
    private CheckBox charge_trade = null;
    private CheckBox charge_vaccount = null;
    private CheckBox charge_card = null;
    private CheckBox charge_phone = null;

    private CheckBox charge_3 = null;
    private CheckBox charge_5 = null;
    private CheckBox charge_10 = null;
    private CheckBox charge_input = null;
    private EditText editText = null;

    private String resultText = "30000";

    private NetworkService service;
    private String id;
    private String user_num;
    private String name;
    private int point;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charge_page);
        service = ApplicationController.getInstance().getNetworkService();

        charge_navi = (TextView) findViewById(R.id.charge_navi);
        charge_point = (TextView) findViewById(R.id.charge_point);
        charge_money_section = (TextView) findViewById(R.id.charge_money_section);
        how_to_charge_section = (TextView) findViewById(R.id.how_to_charge_section);
        charge_sub = (TextView) findViewById(R.id.charge_sub);
        charge_have_point = (TextView) findViewById(R.id.charge_have_point);

        charge_3 = (CheckBox) findViewById(R.id.charge_30000);
        charge_10 = (CheckBox) findViewById(R.id.charge_100000);
        charge_5 = (CheckBox) findViewById(R.id.charge_50000);
        charge_input = (CheckBox) findViewById(R.id.charge_input);
        editText = (EditText) findViewById(R.id.charge_input_edit);

        charge_no_account = (TextView) findViewById(R.id.charge_no_account);
        charge_trade = (CheckBox) findViewById(R.id.charge_trade);
        charge_vaccount = (CheckBox) findViewById(R.id.charge_vaccount);
        charge_card = (CheckBox) findViewById(R.id.charge_card);
        charge_phone = (CheckBox) findViewById(R.id.charge_phone);
        //폰트적용//
        Typeface typeface_r = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Regular.otf");
        Typeface typeface_m = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Medium.otf");
        Typeface typeface_b = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Bold.otf");

        charge_navi.setTypeface(typeface_b);
        charge_point.setTypeface(typeface_b);
        charge_have_point.setTypeface(typeface_r);
        charge_money_section.setTypeface(typeface_m);
        charge_3.setTypeface(typeface_r);
        charge_5.setTypeface(typeface_r);
        charge_10.setTypeface(typeface_r);
        charge_input.setTypeface(typeface_r);
        editText.setTypeface(typeface_r);
        how_to_charge_section.setTypeface(typeface_m);
        charge_no_account.setTypeface(typeface_r);
        charge_trade.setTypeface(typeface_r);
        charge_vaccount.setTypeface(typeface_r);
        charge_card.setTypeface(typeface_r);
        charge_phone.setTypeface(typeface_r);
        charge_sub.setTypeface(typeface_r);
        // 데이터 초기화
        charge_point.setText(getIntent().getExtras().getString("point"));
        //ESeller에서 넘어올 경우
        name = getIntent().getExtras().getString("name");
        if(TextUtils.isEmpty(getIntent().getExtras().getString("user_num")) == false)
        {
            user_num = getIntent().getExtras().getString("user_num");
            Networking(user_num);
        }
        // 포인트페이지 이동
        findViewById(R.id.charge_point_btn).setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
        // 포인트신청완료 이동
        findViewById(R.id.charge_pay).setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), ChargeSuccessActivity.class);
                        if (charge_input.isChecked() && (editText.getText().toString().equals("") || editText.getText().toString().replace(" ", "").equals(""))) {
                            Toast.makeText(getApplicationContext(), "충전금액을 입력해주세요", Toast.LENGTH_SHORT).show();
                        } else {
                            if (charge_input.isChecked()) {
                                resultText = editText.getText().toString();
                                intent.putExtra("charge_pay", resultText);
                                intent.putExtra("name", name);
                                startActivity(intent);
                            } else {
                                intent.putExtra("charge_pay", resultText);
                                intent.putExtra("name", name);
                                startActivity(intent);
                            }
                        }
                    }
                }
        );
        charge_5.setOnCheckedChangeListener(onCheckedChangeListener);
        charge_3.setOnCheckedChangeListener(onCheckedChangeListener);
        charge_10.setOnCheckedChangeListener(onCheckedChangeListener);
        charge_input.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (buttonView == charge_3) {
                if (buttonView.isChecked()) {
                    charge_5.setChecked(false);
                    charge_input.setChecked(false);
                    charge_10.setChecked(false);
                    editText.setEnabled(false);

                    resultText = "30,000";
                }
            } else if (buttonView == charge_5) {
                if (buttonView.isChecked()) {
                    charge_3.setChecked(false);
                    charge_input.setChecked(false);
                    charge_10.setChecked(false);
                    editText.setEnabled(false);

                    resultText = "50,000";
                }
            } else if (buttonView == charge_10) {
                if (buttonView.isChecked()) {
                    charge_3.setChecked(false);
                    charge_input.setChecked(false);
                    charge_5.setChecked(false);
                    editText.setEnabled(false);

                    resultText = "100,000";
                }
            } else if (buttonView == charge_input) {
                if (buttonView.isChecked()) {
                    charge_3.setChecked(false);
                    charge_5.setChecked(false);
                    charge_10.setChecked(false);
                    editText.setEnabled(true);

                }
            }
        }
    };

    public void Networking(String user_num) {
        Call<MyPageResult> getMyPageInfo = service.getMyPageInfo(user_num);
        getMyPageInfo.enqueue(new Callback<MyPageResult>() {
            @Override
            public void onResponse(Call<MyPageResult> call, Response<MyPageResult> response) {
                if (response.isSuccessful()) {
                    if (response.body().message.equals("ok")) {
                        name = response.body().result.name;
                        point = response.body().result.point;
                        charge_point.setText(String.valueOf(point) + " P");
                    }
                }
            }
            @Override
            public void onFailure(Call<MyPageResult> call, Throwable t) {

            }
        });
    }
}
