package com.ATT.dao;

import com.ATT.bean.UserInfo;

public class UserInfoInit {
    public static UserInfo init(String id,String pwd,String name,String department ,String sex,String phone,String birthday,String email){
        UserInfo UserInfo = new UserInfo();
        UserInfo.setName(name);
        UserInfo.setId(Integer.parseInt(id));
        UserInfo.setPassword(pwd);

        UserInfo.setSex(sex);
        UserInfo.setBirthday(birthday);
        UserInfo.setMobile(phone);
        UserInfo.setEmail(email);

        return UserInfo;
    }
}
