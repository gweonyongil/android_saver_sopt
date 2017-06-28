package com.sopt.saver.saver.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sopt.saver.saver.Mypage.MypageActivity;
import com.sopt.saver.saver.Network.NetworkService;
import com.sopt.saver.saver.R;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity {

    private Button login_btn;
    private TextView signup_btn;
    private EditText login_id_edit, login_pw_edit;
    private final String id = "id";
    private final String pwd = "password";
    private NetworkService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_id_edit = (EditText) findViewById(R.id.login_id_edit);
        login_pw_edit = (EditText) findViewById(R.id.login_pw_edit);

        login_btn = (Button) findViewById(R.id.login_btn);
        signup_btn = (TextView) findViewById(R.id.signup_btn);


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
                RequestBody id = RequestBody.create(MediaType.parse("multipart/form-data"), login_id_edit.getText().toString());
                RequestBody password = RequestBody.create(MediaType.parse("multipart/form-data"), login_pw_edit.getText().toString());

                Call<LoginResult> requestLogin = service.tryLogin(id, password);
                requestLogin.enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                        if (response.isSuccessful()) {
                            //////////로그인 성공////////////
                            ////////마이페이지 연동//////////
                            if (response.body().message.equals("ok")) {
                                Intent intent = new Intent(LoginActivity.this, MypageActivity.class);
                                intent.putExtra("userid", inputid.toString());
                                finish();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Login Error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResult> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Login Error", Toast.LENGTH_SHORT).show();
                        Log.i("myTag", t.toString());
                    }
                });
            }
        });
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}