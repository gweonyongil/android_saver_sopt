package com.sopt.saver.saver.API;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kyi42 on 2017-06-30.
 */

public class SetFontClass {
    Typeface typeface;
    private AssetManager assetManager;

    public SetFontClass(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public Typeface getNotoSansRegular() {
        typeface = typeface.createFromAsset(assetManager, "fonts/NotoSansCJKkr-Regular.otf");
        return typeface;
    }

    public Typeface getNotoSansMedium() {
        typeface = typeface.createFromAsset(assetManager, "fonts/NotoSansCJKkr-Medium.otf");
        return typeface;
    }

    public Typeface getNotoSansBold() {
        typeface = typeface.createFromAsset(assetManager, "fonts/NotoSansCJKkr-Bold.otf");
        return typeface;
    }

    public void setGlobalFont(Context context, View view) {
        if (view != null) {
            if (view instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) view;
                int len = vg.getChildCount();
                for (int i = 0; i < len; i++) {
                    View v = vg.getChildAt(i);
                    if (v instanceof TextView) {
                        Toast.makeText(context, ((TextView) v).getText().toString() , Toast.LENGTH_SHORT).show();
                        typeface = typeface.createFromAsset(assetManager, "fonts/NotoSansCJKkr-Regular.otf");
                        ((TextView) v).setTypeface(typeface);
                    }
                    setGlobalFont(context, v);
                }
            }
        } else {
        }

    }
}
