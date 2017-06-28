package com.sopt.saver.saver.Category;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.sopt.saver.saver.Electronics.ERecyclerViewActivity;
import com.sopt.saver.saver.R;

public class CategoryActivity extends Activity {
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
        ///////////////userid 서버 통신시 필요/////////////
        userid = getIntent().getExtras().getString("userid");
        intent = new Intent(CategoryActivity.this, ERecyclerViewActivity.class);
        intent.putExtra("userid", userid.toString());

        find_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        home_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

            }
        });
        mydeal_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("category", "img1");
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
