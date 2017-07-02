package com.sopt.saver.saver.Mypage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.sopt.saver.saver.R;

public class MyPageActivity extends AppCompatActivity {
    private ImageButton mypage_back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);
        //객체 초기화
        mypage_back_btn = (ImageButton)findViewById(R.id.mypage_back_btn);
        //클릭 리스너 설정
        mypage_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // 리스트뷰
        ListView listview;
        MyPageListViewAdapter adapter;
        adapter = new MyPageListViewAdapter();

        listview = (ListView)findViewById(R.id.mypage_list);
        // 섹션 0, 그냥 1, 토글 2, 넥스트 3
        adapter.addItem("계정", 0);
        adapter.addItem("내정보 수정", 3);
        adapter.addItem("포인트 관리", 3);
        adapter.addItem("로그아웃", 1);

        adapter.addItem("앱 설정", 0);
        adapter.addItem("댓글 알림 설정", 2);
        adapter.addItem("쪽지 알림 설정", 2);

        adapter.addItem("앱 정보", 0);
        adapter.addItem("앱 버전", 1);
        adapter.addItem("문의하기", 3);
        adapter.addItem("공지사항", 1);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(onItemClickListener);
    }

    // 리스트뷰 별 페이지 이동
    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if(position == 2){
                //Intent intent = new Intent(getApplicationContext(), PointPageActivity.class);
                //startActivity(intent);
            }
        }
    };

}
