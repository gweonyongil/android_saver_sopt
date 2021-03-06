package com.sopt.saver.saver.Sign;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sopt.saver.saver.API.DialogSetting;
import com.sopt.saver.saver.Login.LoginActivity;
import com.sopt.saver.saver.Network.NetworkService;
import com.sopt.saver.saver.R;
import com.sopt.saver.saver.application.ApplicationController;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {


    private NetworkService service;
    private EditText id_edit, pw_edit, name_edit, pw_check_edit, phone_edit, account_edit, birth_edit;
    private TextView title, id, pw, pw_check, name, phone, bank, account, birth, bank_edit;
    private ImageButton back_btn, submit_btn;
    private RadioGroup part_Radio;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    private NumberPicker picker;
    private Button okBtn, cancleBtn;
    final String bankArray[] = {"KB국민", "신한", "우리", "KEB하나", "IBK기업", "NH농협", "SC제일"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        service = ApplicationController.getInstance().getNetworkService();

        checkBox1 = (CheckBox)findViewById(R.id.signup_sms_check);
        checkBox2 = (CheckBox)findViewById(R.id.signup_email_check);
        checkBox3 = (CheckBox)findViewById(R.id.signup_use_check);
        checkBox4 = (CheckBox)findViewById(R.id.signup_personal_check);

        id_edit = (EditText) findViewById(R.id.signup_id_edit);
        pw_edit = (EditText) findViewById(R.id.signup_pw_edit);
        pw_check_edit = (EditText) findViewById(R.id.signup_pw_check_edit);
        name_edit = (EditText) findViewById(R.id.signup_name_edit);
        phone_edit = (EditText) findViewById(R.id.signup_phone_edit);
        account_edit = (EditText) findViewById(R.id.signup_account_edit);
        birth_edit = (EditText) findViewById(R.id.signup_birth_edit);
        bank_edit = (TextView) findViewById(R.id.signup_bank_spinner);
        title = (TextView) findViewById(R.id.signup_text);
        id = (TextView) findViewById(R.id.signup_id_title);
        pw = (TextView) findViewById(R.id.signup_pw_title);
        pw_check = (TextView) findViewById(R.id.signup_pw_check_title);
        name = (TextView) findViewById(R.id.signup_name_title);
        phone = (TextView) findViewById(R.id.signup_phone_title);
        account = (TextView) findViewById(R.id.signup_account_title);
        bank = (TextView) findViewById(R.id.signup_bank_title);
        account = (TextView) findViewById(R.id.signup_account_title);
        birth = (TextView) findViewById(R.id.signup_birth_title);

        back_btn = (ImageButton) findViewById(R.id.signup_back_btn);
        submit_btn = (ImageButton) findViewById(R.id.signup_submit_btn);

        Typeface typeface_bold = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Bold.otf");
        Typeface typeface_regular = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Regular.otf");

        title.setTypeface(typeface_bold);
        id.setTypeface(typeface_regular);
        pw.setTypeface(typeface_regular);
        pw_check.setTypeface(typeface_regular);
        name.setTypeface(typeface_regular);
        phone.setTypeface(typeface_regular);
        account.setTypeface(typeface_regular);
        bank.setTypeface(typeface_regular);
        account.setTypeface(typeface_regular);
        birth.setTypeface(typeface_regular);

        id_edit.setTypeface(typeface_regular);
        pw_edit.setTypeface(typeface_regular);
        pw_check_edit.setTypeface(typeface_regular);
        name_edit.setTypeface(typeface_regular);
        phone_edit.setTypeface(typeface_regular);
        account_edit.setTypeface(typeface_regular);
        birth_edit.setTypeface(typeface_regular);
        bank_edit.setTypeface(typeface_regular);

        checkBox1.setTypeface(typeface_regular);
        checkBox2.setTypeface(typeface_regular);
        checkBox3.setTypeface(typeface_regular);
        checkBox4.setTypeface(typeface_regular);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (id_edit.length() == 0) {
                    Toast.makeText(getApplicationContext(), "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    id_edit.requestFocus();                 // requestFocus() id_edittext로 focus 이동
                    return;
                }
                if (pw_edit.length() == 0) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    pw_edit.requestFocus();
                    return;
                }
                if (pw_check_edit.length() == 0) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 다시 확인해주세요.", Toast.LENGTH_SHORT).show();
                    pw_check_edit.requestFocus();
                    return;
                }
                // 비밀번호 일치 확인
                if (!pw_edit.getText().toString().equals(pw_check_edit.getText().toString())) {
                    Toast.makeText(SignUpActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    pw_edit.setText("");
                    pw_check_edit.setText("");
                    pw_edit.requestFocus();
                    return;
                }
                if (name_edit.length() == 0) {
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    name_edit.requestFocus();
                    return;
                }
                if (phone_edit.length() == 0) {
                    Toast.makeText(getApplicationContext(), "핸드폰 번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    phone_edit.requestFocus();
                    return;
                }

                if (checkBox3.isChecked() == false || checkBox4.isChecked() == false)
                {
                    Toast.makeText(getApplicationContext(), "이용약관에 동의해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                AddInfoDialog addInfoDialog = new AddInfoDialog();
                addInfoDialog.show();
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_login = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent_login);
                finish();

            }
        });

        bank_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog();
            }
        });
    }

    private void ShowDialog() {
        LayoutInflater dialog = LayoutInflater.from(this);
        final View dialogLayout = dialog.inflate(R.layout.dialog_selector, null);
        final Dialog myDialog = new Dialog(this);

        picker = (NumberPicker) dialogLayout.findViewById(R.id.info_picker);
        DialogSetting.setNumberPickerTextColor(picker, Color.rgb(50,50,50));

        picker.setMinValue(0);
        picker.setMaxValue(bankArray.length - 1);
        picker.setDisplayedValues(bankArray);


        picker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        myDialog.setContentView(dialogLayout);
        myDialog.show();

        okBtn = (Button) dialogLayout.findViewById(R.id.select_dialog_ok_btn);
        cancleBtn = (Button) dialogLayout.findViewById(R.id.select_dialog_no_btn);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bank_edit.setText(bankArray[picker.getValue()].toString());
                myDialog.dismiss();
            }
        });

        cancleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
    }
    public class AddInfoDialog extends Dialog implements DialogInterface.OnClickListener {
        Button okButton;
        Button cancelButton;
        ImageView x_icon_img;
        public AddInfoDialog() {
            super(SignUpActivity.this);
            setContentView(R.layout.dialog_addinfo);
            okButton = (Button) findViewById(R.id.dialog_addinfo_ok_btn);
            cancelButton = (Button) findViewById(R.id.dialog_addinfo_cancel_btn);
            x_icon_img = (ImageView) findViewById(R.id.dialog_addinfo_x_img);
            /////////////리스너등록/////////////
            okButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), SignUpAddinfoActivity.class);
                    intent.putExtra("id", id_edit.getText().toString());
                    intent.putExtra("pw", pw_edit.getText().toString());
                    intent.putExtra("pw_check", pw_check_edit.getText().toString());
                    intent.putExtra("name", name_edit.getText().toString());
                    intent.putExtra("phone", phone_edit.getText().toString());
                    intent.putExtra("bank", bank_edit.getText().toString());
                    intent.putExtra("account", account_edit.getText().toString());
                    intent.putExtra("birth", birth_edit.getText().toString());
                    startActivity(intent);
                    dismiss();
                    finish();
                }
            });
            x_icon_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /////////////////서버통신///////////////////////
                    Networking();
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                    dismiss();
                    finish();
                }
            });
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ///////////////서버통신//////////////////////////
                    Networking();
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                    dismiss();
                    finish();
                }
            });
        }
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    }
    public void Networking(){
        SignInfo signinfo = new SignInfo();
        signinfo.id = id_edit.getText().toString();
        signinfo.password = pw_edit.getText().toString();
        signinfo.password2 = pw_check_edit.getText().toString();
        signinfo.name = name_edit.getText().toString();
        signinfo.phone = phone_edit.getText().toString();
        signinfo.account = account_edit.getText().toString();
        signinfo.birth = birth_edit.getText().toString();
        signinfo.bankname = bank_edit.getText().toString();
        Call<SignResult> requestSign = service.registerSignInfo(signinfo);
        requestSign.enqueue(new Callback<SignResult>() {
            @Override
            public void onResponse(Call<SignResult> call, Response<SignResult> response) {
                if(response.isSuccessful()){
                    if(response.body().message.equals("ok"))
                    {

                    }
                }
            }
            @Override
            public void onFailure(Call<SignResult> call, Throwable t) {

            }
        });
    }
}
