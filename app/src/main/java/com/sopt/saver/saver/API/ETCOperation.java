package com.sopt.saver.saver.API;

/**
 * Created by kyi42 on 2017-07-04.
 */

public class ETCOperation {
    public static String checkDigit(int number)
    {
        return number<=9?"0"+number:String.valueOf(number);
    }
}
