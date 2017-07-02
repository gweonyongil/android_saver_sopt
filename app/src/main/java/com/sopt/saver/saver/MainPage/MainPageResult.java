package com.sopt.saver.saver.MainPage;

import java.util.ArrayList;

/**
 * Created by kyi42 on 2017-06-29.
 */

public class MainPageResult {
    public MainPageData result;
    public String message;

    public class MainPageData {
        public ArrayList<UserCount> usercount;
        public ArrayList<InformationCount> informationCount;
        public ArrayList<AllcommentCount> allcommentCount;
        public ArrayList<MainElecProductData> magam1;
        public ArrayList<MainUtilProductData> magam2;
        public ArrayList<MainBrandProductData> magam3;
        public ArrayList<MainSmartProductData> magam4;
        public ArrayList<MainEtcProductData> magam5;
    }
}
