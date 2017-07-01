package com.sopt.saver.saver.Sign;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.sopt.saver.saver.Login.LoginActivity;
import com.sopt.saver.saver.Network.NetworkService;
import com.sopt.saver.saver.R;
import com.sopt.saver.saver.application.ApplicationController;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private EditText id_edit, pw_edit, name_edit, pw_check_edit, bank_edit, phone_edit, account_edit, birth_edit;
    private Button submit_btn;
    private ImageView back_img;
    private CheckBox sms_bx, use_bx, personal_bx;
    private Vibrator vibe;
    ////////////////////서비스/////////////////////////
    private NetworkService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //////////////////////네트워크&서비스 초기화////////////////
        service = ApplicationController.getInstance().getNetworkService();
        vibe = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        /////////////////객체 초기화////////////////////////
        id_edit = (EditText) findViewById(R.id.signup_id_edit);
        pw_edit = (EditText) findViewById(R.id.signup_pw_edit);
        pw_check_edit = (EditText) findViewById(R.id.signup_pw_check_edit);
        name_edit = (EditText) findViewById(R.id.signup_name_edit);
        phone_edit = (EditText) findViewById(R.id.signup_phone_edit);
        bank_edit = (EditText) findViewById(R.id.signup_bank_edit);
        account_edit = (EditText) findViewById(R.id.signup_account_edit);
        birth_edit = (EditText) findViewById(R.id.signup_birth_edit);
        submit_btn = (Button) findViewById(R.id.signup_submit_btn);
        back_img = (ImageView) findViewById(R.id.signup_back_img);
        sms_bx = (CheckBox) findViewById(R.id.signup_sms_check);
        use_bx = (CheckBox)findViewById(R.id.signup_use_check);
        personal_bx = (CheckBox) findViewById(R.id.signup_personal_check);
        ////////////////클릭 이벤트 정의///////////////////
        bank_edit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus == true) {
                    BankSelectDialog bankSelectDialog = new BankSelectDialog();
                    bankSelectDialog.show();
                }
            }
        });
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id_edit.getText().length() == 0) {
                    vibe.vibrate(1000);
                    Toast.makeText(getApplicationContext(), "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    id_edit.requestFocus();                 // requestFocus() id_edittext로 focus 이동
                    return;
                } else if (pw_edit.getText().length() == 0) {
                    vibe.vibrate(1000);
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    pw_edit.requestFocus();
                    return;
                } else if (pw_check_edit.getText().length() != pw_edit.length()) {
                    vibe.vibrate(1000);
                    Toast.makeText(getApplicationContext(), "비밀번호를 다시 확인해주세요.", Toast.LENGTH_SHORT).show();
                    pw_check_edit.requestFocus();
                    return;
                } else if (name_edit.getText().length() == 0) {
                    vibe.vibrate(1000);
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    name_edit.requestFocus();
                    return;
                } else if (phone_edit.getText().length() == 0) {
                    vibe.vibrate(1000);
                    Toast.makeText(getApplicationContext(), "핸드폰 번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    phone_edit.requestFocus();
                    return;
                } else if (use_bx.isChecked() == false || personal_bx.isChecked() == false) {
                    vibe.vibrate(1000);
                    Toast.makeText(getApplicationContext(), "회원 가입 동의를 체크해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                /////////////////////서버 통신///////////////////////////////
                String id = id_edit.getText().toString();
                String password = pw_edit.getText().toString();
                String password2 = pw_check_edit.getText().toString();
                String name = name_edit.getText().toString();
                String phone = phone_edit.getText().toString();
                String bankname = bank_edit.getText().toString();
                String account = account_edit.getText().toString();
                String birth = birth_edit.getText().toString();
                SignInfo signInfo = new SignInfo(id, password, password2, name, phone, bankname, account, birth);
                Call<SignResult> requestSign = service.registerSignInfo(signInfo);
                requestSign.enqueue(new Callback<SignResult>() {
                    @Override
                    public void onResponse(Call<SignResult> call, Response<SignResult> response) {
                        if (response.isSuccessful()) {
                            //////////////회원가입 성공////////////
                            if (response.body().message.equals("ok")) {
                                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        } else {
                            vibe.vibrate(1000);
                            Toast.makeText(getApplicationContext(), "Sign Error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<SignResult> call, Throwable t) {
                        vibe.vibrate(1000);
                        Toast.makeText(getApplicationContext(), "Failuer Error", Toast.LENGTH_SHORT).show();
                        Log.i("myTag", t.toString());
                    }
                });
            }
        });
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_login = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent_login);
                finish();
            }
        });
    }

    public class BankSelectDialog extends Dialog implements DialogInterface.OnClickListener {
        Button okButton;
        Button cancelButton;
        NumberPicker bankpicker;
        final String banklist[] = {"국민은행", "신한은행", "외환은행", "농협", "우리은행", "수협"};

        public BankSelectDialog() {
            super(SignUpActivity.this);
            setContentView(R.layout.dialog_selectbank);
            bankpicker = (NumberPicker)findViewById(R.id.bank_picker);
            bankpicker.setMinValue(0);
            bankpicker.setMaxValue(banklist.length - 1);
            bankpicker.setDisplayedValues(banklist);
            bankpicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
            okButton = (Button) findViewById(R.id.bank_dialog_ok_btn);
            okButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bank_edit.setText(banklist[bankpicker.getValue()].toString());
                    dismiss();
                }
            });
            cancelButton = (Button) findViewById(R.id.bank_dialog_cancel_btn);
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
