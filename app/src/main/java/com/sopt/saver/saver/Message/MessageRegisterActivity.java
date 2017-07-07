package com.sopt.saver.saver.Message;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.sopt.saver.saver.Network.NetworkService;
import com.sopt.saver.saver.R;
import com.sopt.saver.saver.application.ApplicationController;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static com.sopt.saver.saver.R.id.message_send_content_edit;

public class MessageRegisterActivity extends AppCompatActivity {

    private ImageButton send_btn;
    private TextView id_title;
    private EditText message_send_content;
    private TextView container,text_length;

    final int REQ_CODE_SELECT_IMAGE=100;
    String imgUrl = "";
    Uri data;
    NetworkService service;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_register);

        ////////////////////////서비스 객체 초기화////////////////////////
        service = ApplicationController.getInstance().getNetworkService();

        ////////////////////////뷰 객체 초기화////////////////////////
        send_btn= (ImageButton)findViewById(R.id.message_send_btn);
        id_title= (TextView) findViewById(R.id.message_id);
        message_send_content= (EditText)findViewById(message_send_content_edit);
        text_length = (TextView)findViewById(R.id.text_length);
        container = (TextView)findViewById(R.id.container);

        ///////////////////////폰트설정////////////////////////////
        Typeface typeface_bold = Typeface.createFromAsset(getAssets(),"font/NotoSansCJKkr-Bold.otf");
        Typeface typeface_regular = Typeface.createFromAsset(getAssets(),"font/NotoSansCJKkr-Regular.otf");

        id_title.setTypeface(typeface_bold);
        container.setTypeface(typeface_regular);
        text_length.setTypeface(typeface_regular);
        message_send_content.setTypeface(typeface_regular);

        ////////////////////////프로그래스 다이얼로그 입니다////////////////////////
        mProgressDialog = new ProgressDialog(MessageRegisterActivity.this);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("등록 중...");
        mProgressDialog.setIndeterminate(true);


        ////////////////////////text 필드의 텍스트 길이를 출력!!////////////////////////
        message_send_content.addTextChangedListener(new TextWatcher() {
            String strCur;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                strCur = s.toString();

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                text_length.setText(String.valueOf(s.length())+"/500");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ////////////////////////Edit Text 길이제한!!////////////////////////
        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(500);
        message_send_content.setFilters(FilterArray);


        ////////////////////////완료버튼!!////////////////////////
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id_title.length() == 0 || message_send_content.length() == 0){
                    Toast.makeText(getApplicationContext(),"제목 및 내용을 확인해주세요.",Toast.LENGTH_SHORT).show();
                }
                else{

                    mProgressDialog.show();

                   /*
                   RequestBody 객체에 edittext값들을 저장합니다.
                    */

                    RequestBody title = RequestBody.create(MediaType.parse("multipart/form-data"), id_title.getText().toString());
                    RequestBody content = RequestBody.create(MediaType.parse("multipart/form-data"), message_send_content.getText().toString());

                    MultipartBody.Part body;

                    if(imgUrl==""){
                        body = null;
                    }
                    else{

                        /**
                         * 비트맵 관련한 자료는 아래의 링크에서 참고
                         * http://mainia.tistory.com/468
                         */


                    /*
                    통신부는 따로 정리해드리겠습니다.
                    이번에는 post 메소드 입니다. body(이미지),writer,title,content 를 넘깁니다.
                     파일과 텍스트를 함께 넘길 때는 multipart를 사용합니다.
                     */
                    }
                }
            }
        });
    }
}
