package com.sopt.saver.saver.Mypage;

import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.sopt.saver.saver.R;

public class EditMyInfoActivity extends AppCompatActivity {

    private TextView ed_navi = null;
    private TextView ed_title1= null;
    private TextView ed_id_t = null;
    private TextView ed_id = null;
    private TextView ed_pass_t = null;
    private EditText ed_pass = null;
    private TextView ed_pass_c_t = null;
    private EditText ed_pass_c = null;
    private TextView ed_name_t = null;
    private EditText ed_name = null;
    private TextView ed_phone_t = null;
    private EditText ed_phone = null;
    private TextView ed_bank_t = null;
    private TextView ed_bank = null;
    private TextView ed_account_t = null;
    private EditText ed_account = null;
    private TextView ed_birth = null;
    private TextView ed_title2 = null;
    private TextView ed_city_t = null;
    private TextView ed_city = null;
    private TextView ed_how_t = null;
    private TextView ed_how = null;
    private TextView ed_card_t = null;
    private TextView ed_card = null;
    private TextView ed_visa_t = null;
    private TextView ed_visa = null;
    private TextView ed_tele_t = null;
    private TextView ed_tele = null;
    private TextView ed_money_t = null;
    private EditText ed_money = null;

    final String city[] = {"서울", "경기", "인천", "부산", "대전", "대구","광주", "충북", "충남", "경북", "경남","강원","전북","전남"};
    final String bank[] = {"KB국민", "신한", "우리", "KEB하나", "IBK기업", "NH농협", "SC제일"};
    final String how[] = {"링크", "본인거래", "중개", "기타"};
    final String card[] = {"국민", "신한", "우리", "하나", "롯데", "삼성", "현대"};
    final String visa[] = {"유", "무"};
    final String tele[] = {"SKT", "KT", "LGU+"};

    private NumberPicker picker;
    private Button okBtn;
    private Button cancelBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_my_info);

        ed_navi = (TextView)findViewById(R.id.editmyinfo_navi);
        ed_title1 = (TextView)findViewById(R.id.editmyinfo_title);
        ed_id_t = (TextView)findViewById(R.id.editinfo_id_txt);
        ed_id = (TextView)findViewById(R.id.editinfo_id);
        ed_pass_t = (TextView)findViewById(R.id.editinfo_pass_txt);
        ed_pass = (EditText)findViewById(R.id.editinfo_pass);
        ed_pass_c_t = (TextView) findViewById(R.id.editinfo_passc_txt);
        ed_pass_c = (EditText)findViewById(R.id.editinfo_passc);
        ed_name_t = (TextView)findViewById(R.id.editinfo_name_txt);
        ed_name = (EditText)findViewById(R.id.editinfo_name);
        ed_phone_t = (TextView)findViewById(R.id.editinfo_phone_txt);
        ed_phone = (EditText)findViewById(R.id.editinfo_phone);
        ed_bank_t = (TextView)findViewById(R.id.editinfo_bank_txt);
        ed_bank = (TextView)findViewById(R.id.editinfo_bank);
        ed_account_t = (TextView)findViewById(R.id.editinfo_account_txt);
        ed_account = (EditText)findViewById(R.id.editinfo_account);
        ed_birth = (TextView)findViewById(R.id.editinfo_birth);
        ////
        ed_title2 = (TextView)findViewById(R.id.editinfo_title2);
        ed_city_t = (TextView)findViewById(R.id.editinfo_city_txt);
        ed_city = (TextView)findViewById(R.id.editinfo_city);
        ed_how_t = (TextView)findViewById(R.id.editinfo_how_txt);
        ed_how = (TextView)findViewById(R.id.editinfo_how);
        ed_card_t = (TextView)findViewById(R.id.editinfo_card_txt);
        ed_card = (TextView)findViewById(R.id.editinfo_card);
        ed_visa_t = (TextView)findViewById(R.id.editinfo_visa_txt);
        ed_visa = (TextView)findViewById(R.id.editinfo_visa);
        ed_tele_t = (TextView)findViewById(R.id.editinfo_tele_txt);
        ed_tele = (TextView)findViewById(R.id.editinfo_tele);
        ed_money_t = (TextView)findViewById(R.id.editinfo_money_txt);
        ed_money=(EditText)findViewById(R.id.editinfo_money);


        /////폰트설정///
        Typeface typeface_r = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Regular.otf");
        Typeface typeface_m = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Medium.otf");
        Typeface typeface_b = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Bold.otf");

        ed_navi.setTypeface(typeface_b);
        ed_title1.setTypeface(typeface_r);
        ed_id_t.setTypeface(typeface_r);
        ed_id.setTypeface(typeface_r);
        ed_pass_t.setTypeface(typeface_r);
        ed_pass.setTypeface(typeface_r);
        ed_pass_c_t.setTypeface(typeface_r);
        ed_pass_c.setTypeface(typeface_r);
        ed_name_t.setTypeface(typeface_r);
        ed_name.setTypeface(typeface_r);
        ed_phone_t.setTypeface(typeface_r);
        ed_phone.setTypeface(typeface_r);
        ed_bank_t.setTypeface(typeface_r);
        ed_bank.setTypeface(typeface_r);
        ed_account_t.setTypeface(typeface_r);
        ed_account.setTypeface(typeface_r);
        ed_birth.setTypeface(typeface_r);

        ed_city_t.setTypeface(typeface_r);
        ed_city.setTypeface(typeface_r);
        ed_title2.setTypeface(typeface_r);
        ed_how_t.setTypeface(typeface_r);
        ed_how.setTypeface(typeface_r);
        ed_card_t.setTypeface(typeface_r);
        ed_card.setTypeface(typeface_r);
        ed_visa_t.setTypeface(typeface_r);
        ed_visa.setTypeface(typeface_r);
        ed_tele_t.setTypeface(typeface_r);
        ed_tele.setTypeface(typeface_r);
        ed_money_t.setTypeface(typeface_r);
        ed_money.setTypeface(typeface_r);


        //이전페이지로 이동
        findViewById(R.id.editmyinfo_mypage_btn).setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );

        ed_bank.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowDialog(0);
            }
        });

        ed_city.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowDialog(1);
            }
        });

        ed_how.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowDialog(2);
            }
        });

        ed_card.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowDialog(3);
            }
        });

        ed_visa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowDialog(4);
            }
        });

        ed_tele.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowDialog(5);
            }
        });
    }

    private void ShowDialog(int temp){
        LayoutInflater dialog = LayoutInflater.from(this);
        final View dialogLayout = dialog.inflate(R.layout.dialog_selector, null);
        final Dialog myDialog = new Dialog(this);
        final int check = temp;

        picker = (NumberPicker)dialogLayout.findViewById(R.id.info_picker);

        picker.setMinValue(0);

        if(check == 0){
            picker.setMaxValue(bank.length - 1);
            picker.setDisplayedValues(bank);
        }

        else if(check == 1){
            picker.setMaxValue(city.length - 1);
            picker.setDisplayedValues(city);
        }

        else if(check == 2){
            picker.setMaxValue(how.length - 1);
            picker.setDisplayedValues(how);
        }

        else if(check == 3){
            picker.setMaxValue(card.length - 1);
            picker.setDisplayedValues(card);
        }
        else if(check == 4){
            picker.setMaxValue(visa.length - 1);
            picker.setDisplayedValues(visa);
        }
        else if(check==5){
            picker.setMaxValue(tele.length - 1);
            picker.setDisplayedValues(tele);
        }


        picker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        myDialog.setContentView(dialogLayout);
        myDialog.show();

        okBtn = (Button)dialogLayout.findViewById(R.id.select_dialog_ok_btn);
        cancelBtn = (Button)dialogLayout.findViewById(R.id.select_dialog_no_btn);

        okBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(check == 0){
                    ed_bank.setText(bank[picker.getValue()].toString());
                }
                else if(check == 1){
                    ed_city.setText(city[picker.getValue()].toString());
                }
                else if(check == 2){
                    ed_how.setText(how[picker.getValue()].toString());
                }
                else if(check == 3){
                    ed_card.setText(card[picker.getValue()].toString());
                }
                else if(check == 4){
                    ed_visa.setText(visa[picker.getValue()].toString());
                }
                else if(check == 5){
                    ed_tele.setText(tele[picker.getValue()].toString());
                }

                myDialog.dismiss();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
    }
}
