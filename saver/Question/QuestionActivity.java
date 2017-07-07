package com.sopt.saver.saver.Question;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.sopt.saver.saver.Network.NetworkService;
import com.sopt.saver.saver.R;
import com.sopt.saver.saver.application.ApplicationController;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionActivity extends AppCompatActivity {

    private NetworkService service;
    private TextView title, tv1, tv2, tv3;
    private EditText et1, et2, et3;
    private ImageButton submit_btn, back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = ApplicationController.getInstance().getNetworkService();
        setContentView(R.layout.activity_question);
        //객체화
        title = (TextView) findViewById(R.id.question_title);
        tv1 = (TextView) findViewById(R.id.question_tv1);
        tv2 = (TextView) findViewById(R.id.question_tv2);
        tv3 = (TextView) findViewById(R.id.question_tv3);
        et1 = (EditText) findViewById(R.id.question_et1);
        et2 = (EditText) findViewById(R.id.question_et2);
        et3 = (EditText) findViewById(R.id.question_et3);
        submit_btn = (ImageButton) findViewById(R.id.question_register_btn);
        back_btn = (ImageButton) findViewById(R.id.question_back_btn);

        /////폰트설정///
        Typeface typeface_r = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Regular.otf");
        Typeface typeface_b = Typeface.createFromAsset(getAssets(), "fonts/NotoSansCJKkr-Bold.otf");

        title.setTypeface(typeface_b);
        tv1.setTypeface(typeface_r);
        et1.setTypeface(typeface_r);
        tv2.setTypeface(typeface_r);
        et2.setTypeface(typeface_r);
        tv3.setTypeface(typeface_r);
        et3.setTypeface(typeface_r);
        ///리스너 설정///
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Networking();
                finish();
            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void Networking() {
        QuestionInfo questionInfo = new QuestionInfo();
        questionInfo.subject = et1.getText().toString();
        questionInfo.from = et2.getText().toString();
        questionInfo.text = et3.getText().toString();
        Call<QuestionResult> postQuestion = service.postQuestion(questionInfo);
        postQuestion.enqueue(new Callback<QuestionResult>() {
            @Override
            public void onResponse(Call<QuestionResult> call, Response<QuestionResult> response) {
                if (response.isSuccessful()) {
                    if (response.body().message.equals("ok")) {
                        Toast.makeText(getApplicationContext(), "문의완료", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<QuestionResult> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "FAIL", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        submit_btn.setEnabled(true);
    }
}
