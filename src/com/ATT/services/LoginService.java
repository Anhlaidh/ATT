package com.ATT.services;

import com.ATT.bean.UserInfo;
import com.ATT.dao.initializeUserInfo;

import java.sql.SQLException;

public class LoginService {
    UserInfo UserInfo = new UserInfo();
    public UserInfo login(String account ,String password){
        try {
            UserInfo = initializeUserInfo.get(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if ("null".equals(UserInfo)){
            return null;
        }
        else if (account.equals(UserInfo.getAccount())&&password.equals(UserInfo.getPassword())){
            return UserInfo;
        }
        else return null;

//        try {
//            UserInfo = initializeBean.get(account);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        if (UserInfo == null || CommonUtils.isEmptyString(UserInfo.getAccount())) {
//            return null;
//
//        }
//        if (!UserInfo.getPassword().equals(password)) {
//            return null;
//        }
//        if (UserInfo.getState() != 0) {
//            return null;
//        }


    }
}
