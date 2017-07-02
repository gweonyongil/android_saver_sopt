package com.sopt.saver.saver.Login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sopt.saver.saver.API.SetFontClass;
import com.sopt.saver.saver.MainPage.MainPageActivity;
import com.sopt.saver.saver.Network.NetworkService;
import com.sopt.saver.saver.R;
import com.sopt.saver.saver.Sign.SignUpActivity;
import com.sopt.saver.saver.application.ApplicationController;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity {

    Vibrator vibe;
    private SetFontClass setFontClass;
    private Typeface typeface;
    private Button login_btn;
    private TextView signup_btn;
    private EditText login_id_edit, login_pw_edit;
    private NetworkService service;
    private LoginData loginData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /////////////서비스 객체 초기화/////////////////
        service = ApplicationController.getInstance().getNetworkService();
        vibe = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        //////////////////객체 초기화/////////////////
        login_id_edit = (EditText) findViewById(R.id.login_id_edit);
        login_pw_edit = (EditText) findViewById(R.id.login_pw_edit);
        login_btn = (Button) findViewById(R.id.login_btn);
        signup_btn = (TextView) findViewById(R.id.signup_btn);
        ////////////////////폰트적용////////////////////////////
        setFontClass = new SetFontClass(getApplicationContext());
        login_id_edit.setTypeface(setFontClass.getNotoSansRegular());
        login_pw_edit.setTypeface(setFontClass.getNotoSansRegular());
        login_btn.setTypeface(setFontClass.getNotoSansRegular());
        signup_btn.setTypeface(setFontClass.getNotoSansRegular());
        signup_btn.setText(Html.fromHtml("<u>" + "회원가입" + "</u>"));
        ///////////////////클릭이벤트//////////////////////////
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login_id_edit.length() == 0) {
                    Toast.makeText(getApplicationContext(), "아이디를 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (login_pw_edit.length() == 0) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                final String inputid = login_id_edit.getText().toString();

                ///////서버 통신////////
                String id = login_id_edit.getText().toString();
                String password = login_pw_edit.getText().toString();
                LoginInfo loginInfo = new LoginInfo(id, password);
                Call<LoginResult> requestLogin = service.tryLogin(loginInfo);
                requestLogin.enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                        if (response.isSuccessful()) {
                            //////////로그인 성공////////////
                            ////////마이페이지 연동//////////
                            if (response.body().message.equals("ok")) {
                                Intent intent = new Intent(LoginActivity.this, MainPageActivity.class);
                                intent.putExtra("id", inputid.toString());
                                intent.putExtra("user_num", response.body().result.user_num);
                                startActivity(intent);
                            }
                        } else {
                            vibe.vibrate(1000);
                            Toast.makeText(getApplicationContext(), "Login Error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResult> call, Throwable t) {
                        vibe.vibrate(1000);
                        Toast.makeText(getApplicationContext(), "On Failure", Toast.LENGTH_SHORT).show();
                        Log.i("myTag", t.toString());
                    }
                });
            }
        });
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
