package com.sopt.saver.saver.Category;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.sopt.saver.saver.Electronics.ElectronicsRecyclerViewActivity;
import com.sopt.saver.saver.R;

public class CategoryActivity extends AppCompatActivity {
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        img1 = (ImageView)findViewById(R.id.cate_img1);
        img2 = (ImageView)findViewById(R.id.cate_img2);
        img3 = (ImageView)findViewById(R.id.cate_img3);
        img4 = (ImageView)findViewById(R.id.cate_img4);
        img5 = (ImageView)findViewById(R.id.cate_img5);
        img6 = (ImageView)findViewById(R.id.cate_img6);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(CategoryActivity.this, ElectronicsRecyclerViewActivity.class);
                intent.putExtra("category", "img1");
                startActivity(intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(CategoryActivity.this, ElectronicsRecyclerViewActivity.class);
                intent.putExtra("category", "img2");
                startActivity(intent);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(CategoryActivity.this, ElectronicsRecyclerViewActivity.class);
                intent.putExtra("category", "img3");
                startActivity(intent);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(CategoryActivity.this, ElectronicsRecyclerViewActivity.class);
                intent.putExtra("category", "img4");
                startActivity(intent);
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(CategoryActivity.this, ElectronicsRecyclerViewActivity.class);
                intent.putExtra("category", "img5");
                startActivity(intent);
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(CategoryActivity.this, ElectronicsRecyclerViewActivity.class);
                intent.putExtra("category", "img6");
                startActivity(intent);
            }
        });
    }
}
