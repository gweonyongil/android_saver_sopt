package com.sopt.saver.saver.Category;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.sopt.saver.saver.Electronics.ERecyclerViewActivity;
import com.sopt.saver.saver.MainPage.MainPageActivity;
import com.sopt.saver.saver.Message.MessageActivity;
import com.sopt.saver.saver.Mypage.MyPageActivity;
import com.sopt.saver.saver.R;

public class CategoryActivity extends AppCompatActivity {
    private EditText find_et;
    private TextView upper_tv;
    private ImageView mypage_img;
    private ImageView find_img;
    private ImageView home_img;
    private ImageView category_img;
    private ImageView message_img;
    private ImageView mydeal_img;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;
    private ImageView img6;
    private Intent intent;
    private String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        mypage_img = (ImageView)findViewById(R.id.category_mypage_img);
        find_img = (ImageView)findViewById(R.id.category_find_img);
        home_img = (ImageView)findViewById(R.id.category_home_img);
        category_img = (ImageView)findViewById(R.id.category_category_img);
        message_img = (ImageView)findViewById(R.id.category_message_img);
        mydeal_img = (ImageView)findViewById(R.id.category_mydeal_img);
        img1 = (ImageView)findViewById(R.id.cate_img1);
        img2 = (ImageView)findViewById(R.id.cate_img2);
        img3 = (ImageView)findViewById(R.id.cate_img3);
        img4 = (ImageView)findViewById(R.id.cate_img4);
        img5 = (ImageView)findViewById(R.id.cate_img5);
        img6 = (ImageView)findViewById(R.id.cate_img6);
        upper_tv = (TextView)findViewById(R.id.category_upper_tv);
        find_et = (EditText)findViewById(R.id.category_find_et);
        ///////////////userid 서버 통신시 필요/////////////
        //userid = getIntent().getExtras().getString("userid");
        intent = new Intent(CategoryActivity.this, ERecyclerViewActivity.class);
        ////////TEST////////////
        userid = "userid";
        intent.putExtra("userid", userid.toString());
        mypage_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mypage_intent = new Intent(CategoryActivity.this, MyPageActivity.class);
                mypage_intent.putExtra("userid", userid.toString());
                startActivity(mypage_intent);
            }
        });
        find_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(find_et.getVisibility() == View.VISIBLE)
                {
                    String find_text = find_et.getText().toString();
                }
                else if(find_et.getVisibility() != View.VISIBLE)
                {
                    find_et.setVisibility(View.VISIBLE);
                    upper_tv.setVisibility(View.GONE);
                }
            }
        });
        home_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home_intent = new Intent(CategoryActivity.this, MainPageActivity.class);
                home_intent.putExtra("userid", userid.toString());
                startActivity(home_intent);
            }
        });
        category_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        message_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent message_intent = new Intent(CategoryActivity.this, MessageActivity.class);
                message_intent.putExtra("userid", userid.toString());
                startActivity(message_intent);
            }
        });
        mydeal_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, MydealRecyclerViewActivity.class);
                ///////////////////////TEST 삽입//////////////////////////////
                intent.putExtra("userid", userid.toString());
                startActivity(intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("category", "img2");
                startActivity(intent);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("category", "img3");
                startActivity(intent);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("category", "img4");
                startActivity(intent);
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("category", "img5");
                startActivity(intent);
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("category", "img6");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        find_et.setVisibility(View.GONE);
        upper_tv.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode)
        {
            case KeyEvent.KEYCODE_BACK:
                finish();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
