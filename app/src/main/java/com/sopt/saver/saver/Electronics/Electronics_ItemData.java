package com.sopt.saver.saver.Electronics;

/**
 * Created by kyi42 on 2017-04-15.
 */

public class Electronics_ItemData {
    int id;
    String title;
    String category;
    String kind;
    String product;
    String price;
    String url;
    String explantion;
    String addInformation;
    String time;
    String dday;
    String image;


    public Electronics_ItemData(int id, String title, String category, String kind, String product, String price, String url, String explantion,
                                String addInformation, String time, String dday, String image)
    {
        this.id = id;
        this.title = title;
        this.category = category;
        this.kind = kind;
        this.product = product;
        this.price = price;
        this.url = url;
        this.explantion = explantion;
        this.addInformation = addInformation;
        this.time = time;
        this.dday = dday;
        this.image = image;
    }
}
