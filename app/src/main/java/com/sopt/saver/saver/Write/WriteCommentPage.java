package com.sopt.saver.saver.Write;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sopt.saver.saver.API.DialogSetting;
import com.sopt.saver.saver.API.ETCOperation;
import com.sopt.saver.saver.Electronics.ESellerListViewActivity;
import com.sopt.saver.saver.Network.NetworkService;
import com.sopt.saver.saver.R;
import com.sopt.saver.saver.application.ApplicationController;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WriteCommentPage extends AppCompatActivity {

    private NetworkService service;
    private TextView comment_navi = null;
    private TextView comment_title = null;
    private EditText comment_title_input = null;
    private TextView comment_price = null;
    private EditText comment_price_input = null;
    private TextView comment_date = null;
    private TextView comment_city = null;
    private TextView comment_how = null;
    private TextView comment_sub = null;
    private EditText comment_sub_input = null;
    private TextView comment_image = null;
    private DatePicker comment_date_picker = null;
    private TextView select_region_tv;
    private RadioGroup method_rg;
    private ImageButton submit_btn;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    ////////////////////////데이터 전달///////////////////////
    String id;
    String user_num;
    String category;
    String thing_num;
    WriteCommentInfo writeCommentInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_comment_page);
        ///////////////////인텐트 초기화/////////////////////////
        id = getIntent().getExtras().getString("id");
        user_num = getIntent().getExtras().getString("user_num");
        category = getIntent().getExtras().getString("category");
        thing_num = getIntent().getExtras().getString("thing_num");

        /////////////////////네트워크서비스/////////////////////////
        service = ApplicationController.getInstance().getNetworkService();
        /////////////////////객체화/////////////////////////////////
        comment_navi = (TextView) findViewById(R.id.comment_navi);
        comment_title = (TextView) findViewById(R.id.comment_title);
        comment_title_input = (EditText) findViewById(R.id.comment_title_input);
        comment_price = (TextView) findViewById(R.id.comment_price);
        comment_price_input = (EditText) findViewById(R.id.comment_price_input);
        comment_date = (TextView) findViewById(R.id.comment_date);
        comment_date_picker = (DatePicker) findViewById(R.id.comment_date_picker);
        comment_city = (TextView) findViewById(R.id.comment_city);
        comment_how = (TextView) findViewById(R.id.comment_how);
        comment_sub = (TextView) findViewById(R.id.comment_sub);
        comment_sub_input = (EditText) findViewById(R.id.comment_sub_input);
        submit_btn = (ImageButton) findViewById(R.id.editmyinfo_success_btn);
        select_region_tv = (TextView)findViewById(R.id.comment_city_tv);
        method_rg = (RadioGroup)findViewById(R.id.comment_rg);
        rb1 = (RadioButton)findViewById(R.id.comment_rb_link);
        rb2 = (RadioButton)findViewById(R.id.comment_rb_self);
        rb3 = (RadioButton)findViewById(R.id.comment_rb_trade);
        rb4 = (RadioButton)findViewById(R.id.comment_rb_etc);
        //////폰트지정/////
        Typeface typeface_r = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Regular.otf");
        Typeface typeface_m = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Medium.otf");
        Typeface typeface_b = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Bold.otf");
        comment_navi.setTypeface(typeface_b);
        comment_title.setTypeface(typeface_r);
        comment_title_input.setTypeface(typeface_m);
        comment_price.setTypeface(typeface_r);
        comment_price_input.setTypeface(typeface_r);
        comment_date.setTypeface(typeface_r);
        comment_city.setTypeface(typeface_r);
        comment_how.setTypeface(typeface_r);
        comment_sub.setTypeface(typeface_r);
        comment_sub_input.setTypeface(typeface_r);
        select_region_tv.setTypeface(typeface_r);
        rb1.setTypeface(typeface_r);
        rb2.setTypeface(typeface_r);
        rb3.setTypeface(typeface_r);
        rb4.setTypeface(typeface_r);
        ///////////////가이드 화면 띄우기///////////////////////
        Guide2Dialog guide2Dialog = new Guide2Dialog();
        guide2Dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        guide2Dialog.show();
        ///////////클릭이벤트////////////////////////////
        select_region_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegionSelectDialog regionSelectDialog= new RegionSelectDialog();
                DialogSetting.setNumberPickerTextColor(regionSelectDialog.picker, Color.rgb(50,50,50));
                regionSelectDialog.show();
            }
        });
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit_btn.setEnabled(false);
                /////////////////빈칸체크/////////////////////////
                if(comment_title_input.getText().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "제목을 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(comment_price_input.getText().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "가격을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(select_region_tv.getText().toString().equals("여기를 클릭하세요"))
                {
                    Toast.makeText(getApplicationContext(), "지역을 선택하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(comment_sub_input.getText().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "세부 정보를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(method_rg.getCheckedRadioButtonId() < 0)
                {
                    Toast.makeText(getApplicationContext(), "구매 방법을 선택하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                ////////////////서버통신 객체화///////////////////
                writeCommentInfo = new WriteCommentInfo();
                writeCommentInfo.id = id;
                writeCommentInfo.title = comment_title_input.getText().toString();
                writeCommentInfo.product = "";
                writeCommentInfo.kind = "";
                writeCommentInfo.price = comment_price_input.getText().toString();
                writeCommentInfo.time = "";
                writeCommentInfo.period = comment_date_picker.getYear() + "-" + ETCOperation.checkDigit(comment_date_picker.getMonth() + 1) + "-" + ETCOperation.checkDigit(comment_date_picker.getDayOfMonth());
                writeCommentInfo.addinformation = comment_sub_input.getText().toString();
                writeCommentInfo.local = select_region_tv.getText().toString();
                RadioButton radioButton = (RadioButton)findViewById(method_rg.getCheckedRadioButtonId());
                writeCommentInfo.method = radioButton.getText().toString();
                //////////////////////서버통신////////////////////
                if (category.equals("전자제품")) {
                    Call<WriteCommentResult> registerEComment = service.registerElecComment(thing_num, writeCommentInfo);
                    registerEComment.enqueue(new Callback<WriteCommentResult>() {
                        @Override
                        public void onResponse(Call<WriteCommentResult> call, Response<WriteCommentResult> response) {
                            if (response.isSuccessful()) {
                                if (response.body().message.equals("ok")) {
                                    Toast.makeText(getApplicationContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(WriteCommentPage.this, ESellerListViewActivity.class);
                                    intent.putExtra("user_num", user_num);
                                    intent.putExtra("id", id);
                                    intent.putExtra("thing_num",thing_num);
                                    intent.putExtra("category", category);
                                    startActivity(intent);
                                    finish();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), response.message().toString() , Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<WriteCommentResult> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "FAIL", Toast.LENGTH_SHORT).show();
                            Log.i("FAIL", t.getMessage());
                        }
                    });
                }
                else if (category.equals("티켓 및 이용권")) {
                    Call<WriteCommentResult> registerUComment = service.registerUtilComment(thing_num, writeCommentInfo);
                    registerUComment.enqueue(new Callback<WriteCommentResult>() {
                        @Override
                        public void onResponse(Call<WriteCommentResult> call, Response<WriteCommentResult> response) {
                            if (response.isSuccessful()) {
                                if (response.body().message.equals("ok")) {
                                    Toast.makeText(getApplicationContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(WriteCommentPage.this, ESellerListViewActivity.class);
                                    intent.putExtra("user_num", user_num);
                                    intent.putExtra("id", id);
                                    intent.putExtra("thing_num",thing_num);
                                    intent.putExtra("category", category);
                                    startActivity(intent);
                                    finish();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "?", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<WriteCommentResult> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "FAIL", Toast.LENGTH_SHORT).show();
                            Log.i("FAIL", t.getMessage());
                        }
                    });
                } else if (category.equals("브랜드")) {
                    Call<WriteCommentResult> registerBComment = service.registerBrandCommet(thing_num, writeCommentInfo);
                    registerBComment.enqueue(new Callback<WriteCommentResult>() {
                        @Override
                        public void onResponse(Call<WriteCommentResult> call, Response<WriteCommentResult> response) {
                            if (response.isSuccessful()) {
                                if (response.body().message.equals("ok")) {
                                    Toast.makeText(getApplicationContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(WriteCommentPage.this, ESellerListViewActivity.class);
                                    intent.putExtra("user_num", user_num);
                                    intent.putExtra("id", id);
                                    intent.putExtra("thing_num",thing_num);
                                    intent.putExtra("category", category);
                                    startActivity(intent);
                                    finish();
                                }
                            } else {

                            }
                        }

                        @Override
                        public void onFailure(Call<WriteCommentResult> call, Throwable t) {

                        }
                    });
                } else if (category.equals("스마트폰 및 가입상품")) {
                    Call<WriteCommentResult> registerSComment = service.registerSmartComment(thing_num, writeCommentInfo);
                    registerSComment.enqueue(new Callback<WriteCommentResult>() {
                        @Override
                        public void onResponse(Call<WriteCommentResult> call, Response<WriteCommentResult> response) {
                            if (response.isSuccessful()) {
                                if (response.body().message.equals("ok")) {
                                    Toast.makeText(getApplicationContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(WriteCommentPage.this, ESellerListViewActivity.class);
                                    intent.putExtra("user_num", user_num);
                                    intent.putExtra("id", id);
                                    intent.putExtra("thing_num",thing_num);
                                    intent.putExtra("category", category);
                                    startActivity(intent);
                                    finish();
                                }
                            } else {

                            }
                        }

                        @Override
                        public void onFailure(Call<WriteCommentResult> call, Throwable t) {

                        }
                    });
                } else if (category.equals("기타")) {
                    Call<WriteCommentResult> registerETCComment = service.registerEtcComment(thing_num, writeCommentInfo);
                    registerETCComment.enqueue(new Callback<WriteCommentResult>() {
                        @Override
                        public void onResponse(Call<WriteCommentResult> call, Response<WriteCommentResult> response) {
                            if (response.isSuccessful()) {
                                if (response.body().message.equals("ok")) {
                                    Toast.makeText(getApplicationContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(WriteCommentPage.this, ESellerListViewActivity.class);
                                    intent.putExtra("user_num", user_num);
                                    intent.putExtra("id", id);
                                    intent.putExtra("thing_num",thing_num);
                                    intent.putExtra("category", category);
                                    startActivity(intent);
                                    finish();
                                }
                            } else {

                            }
                        }

                        @Override
                        public void onFailure(Call<WriteCommentResult> call, Throwable t) {

                        }
                    });
                }
                submit_btn.setEnabled(true);
            }
        });
    }

    public class Guide2Dialog extends Dialog implements DialogInterface.OnClickListener {
        ImageView x_icon;

        public Guide2Dialog() {
            super(WriteCommentPage.this);
            setContentView(R.layout.dialog_guide2);
            x_icon = (ImageView) findViewById(R.id.guide2_xicon_img);
            x_icon.setOnClickListener(new View.OnClickListener() {
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
    public class RegionSelectDialog extends Dialog implements DialogInterface.OnClickListener {
        Button okButton;
        Button cancelButton;
        NumberPicker picker;
        final String picklist[] = {"서울", "경기", "충청", "경상", "제주도", "인천", "부산", "광주"};

        public RegionSelectDialog() {
            super(WriteCommentPage.this);
            setContentView(R.layout.dialog_selector);
            picker = (NumberPicker)findViewById(R.id.info_picker);
            picker.setMinValue(0);
            picker.setMaxValue(picklist.length - 1);
            picker.setDisplayedValues(picklist);
            picker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
            okButton = (Button) findViewById(R.id.select_dialog_ok_btn);
            cancelButton = (Button) findViewById(R.id.select_dialog_no_btn);
            okButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    select_region_tv.setText(picklist[picker.getValue()].toString());
                    dismiss();
                }
            });
//            cancelButton = (Button) findViewById(R.id.select_dialog_cancel_btn);
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
