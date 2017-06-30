package com.sopt.saver.saver.Electronics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sopt.saver.saver.API.ImageLoadTask;
import com.sopt.saver.saver.R;

/**
 * Created by kyi42 on 2017-06-28.
 */

public class EProductPictureFragment extends Fragment {
    private ImageView prod_img;
    public EProductPictureFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_productpicture, container, false);
        prod_img = (ImageView)view.findViewById(R.id.frag_prod_img);
        if(getArguments() != null)
        {
            new ImageLoadTask(getArguments().getString("img"),prod_img).execute();
        }
        return view;
    }
}
