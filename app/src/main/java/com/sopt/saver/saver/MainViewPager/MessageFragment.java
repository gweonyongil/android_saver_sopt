package com.sopt.saver.saver.MainViewPager;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sopt.saver.saver.API.SetFontClass;
import com.sopt.saver.saver.Message.MRecyclerAdapter;
import com.sopt.saver.saver.Message.MessageListData;
import com.sopt.saver.saver.R;

import java.util.ArrayList;

/**
 * Created by kyi42 on 2017-07-05.
 */

public class MessageFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private Context context;
    private AssetManager assetManager;
    private String id;
    private String user_num;
    private RecyclerView recyclerView;
    private ArrayList<MessageListData> mDatas;
    private MRecyclerAdapter MRecyclerAdapter;
    private LinearLayoutManager linearLayoutManager;
    private ImageView restart_btn;
    private TextView msgBox;
    private SwipeRefreshLayout refreshLayout;
    private MessageListData messageListData;
    private SetFontClass setFontClass;

    public MessageFragment()
    {
        super();
    }
    //////////////////////메소드//////////////////////////
    public void setContext(Context context)
    {
        this.context = context;
    }
    public void setAssetManager(AssetManager assetManager)
    {
        this.assetManager = assetManager;
    }
    public void setUserData(String id, String user_num)
    {
        this.id = id;
        this.user_num = user_num;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_message, container, false);
        ////////////////////////서비스 객체 초기화////////////////////////
        //service = ApplicationController.getInstance().getNetworkService();
        ////////////////////////뷰 객체 초기화////////////////////////
        restart_btn = (ImageView) view.findViewById(R.id.message_restart);
        msgBox = (TextView) view.findViewById(R.id.message_box);
        recyclerView = (RecyclerView) view.findViewById(R.id.rcv);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.RefreshLayout);
        recyclerView.setHasFixedSize(true);
        refreshLayout.setOnRefreshListener(this);
        ///////////////////////폰트설정/////////////////////////////
        setFontClass = new SetFontClass(assetManager);
        msgBox.setTypeface(setFontClass.getNotoSansBold());
        return view;
    }
    @Override
    public void onRefresh() {
        //페이지 리로드 필요
        ListReload();
    }
    public void ListReload(){

    }
}
