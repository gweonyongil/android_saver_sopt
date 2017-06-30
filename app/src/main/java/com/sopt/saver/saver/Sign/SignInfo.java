package com.sopt.saver.saver.Sign;

/**
 * Created by kyi42 on 2017-06-28.
 */

public class SignInfo {
    String id;
    String password;
    String password2;
    String name;
    String phone;
    String bankname;
    String account;
    String birth;
    public SignInfo(String id, String password, String password2, String name, String phone, String bankname, String account, String birth)
    {
        this.id = id;
        this.password = password;
        this.password2 = password2;
        this.name = name;
        this.phone = phone;
        this.bankname = bankname;
        this.account = account;
        this.birth = birth;
    }
}
