package com.sopt.saver.saver.Electronics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.sopt.saver.saver.R;

import java.util.ArrayList;

public class ElectronicsRecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Electronics_ItemData> categoryItemDatas;
    ElectronicsRecyclerAdapter electronicsRecyclerAdapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        categoryItemDatas = new ArrayList<Electronics_ItemData>();


        electronicsRecyclerAdapter = new ElectronicsRecyclerAdapter(categoryItemDatas, clickListener);
        recyclerView.setAdapter(electronicsRecyclerAdapter);
    }
    public View.OnClickListener clickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            final int position = recyclerView.getChildPosition(v);
            Toast.makeText(getApplicationContext(), (position + 1) + "번 클릭!!",Toast.LENGTH_SHORT).show();
        }
    };
}
