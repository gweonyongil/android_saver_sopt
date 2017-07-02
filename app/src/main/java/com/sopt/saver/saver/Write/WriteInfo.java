package com.sopt.saver.saver.Write;

import java.io.File;

/**
 * Created by kyi42 on 2017-07-02.
 */

public class WriteInfo {
    public String user_num;
    public String title;
    public String category;
    public String product;
    public String price;
    public String time;
    public String explantion;
    public String kind;
    public String period;
    public String url;
    public File image;
    public WriteInfo(String user_num, String title, String category, String product, String price, String time, String explantion, String kind,
                     String period, String url, File image)
    {
        this.user_num = user_num;
        this.title = title;
        this.category = category;
        this.product = product;
        this.price = price;
        this.time = time;
        this.explantion = explantion;
        this.kind = kind;
        this.period = period;
        this.url = url;
        this.image = image;
    }
}
