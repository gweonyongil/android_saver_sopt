package com.sopt.saver.saver.Electronics;

import java.util.ArrayList;

/**
 * Created by kyi42 on 2017-07-03.
 */

public class UDetailResult {
    public ResultData result;
    public String message;
    public class ResultData
    {
        public UProductData info;
        public ArrayList<ESellerData> comment;
    }
}
