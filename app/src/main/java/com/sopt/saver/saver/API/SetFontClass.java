package com.sopt.saver.saver.API;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by kyi42 on 2017-06-30.
 */

public class SetFontClass {
    Typeface typeface;
    private Context context;
    public SetFontClass(Context context)
    {
        this.context= context;
    }
    public Typeface getNotoSansRegular()
    {
        typeface.createFromAsset(context.getAssets(), "NotoSansCJKkr-Regular.otf");
        return typeface;
    }
    public Typeface getNotoSansMedium()
    {
        typeface.createFromAsset(context.getAssets(), "NotoSansCJKkr-Medium.otf");
        return typeface;
    }
    public Typeface getNotoSansBold()
    {
        typeface.createFromAsset(context.getAssets(), "NotoSansCJKkr-Bold.otf");
        return typeface;
    }

}
