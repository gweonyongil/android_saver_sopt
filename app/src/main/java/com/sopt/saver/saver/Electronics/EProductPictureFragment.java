package com.sopt.saver.saver.Electronics;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sopt.saver.saver.R;

/**
 * Created by kyi42 on 2017-06-28.
 */

public class EProductPictureFragment extends Fragment {
    private ImageView prod_img;
    public EProductPictureFragment() {
        super();
    }
    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_productpicture, container, false);
        prod_img = (ImageView) view.findViewById(R.id.frag_prod_img);
        if(getArguments().get("image") != null) {
            Glide.with(context)
                    .load(getArguments().get("image"))
                    .into(prod_img);
        }
        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
