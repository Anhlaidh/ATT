package com.ATT.services;

import com.ATT.bean.UserInfo;
import com.ATT.dao.initializeBean;
import common.util.CommonUtils;

import java.sql.SQLException;

public class LoginService {
    UserInfo UserInfo = null;
    public UserInfo login(String account ,String password){

        try {
            UserInfo = initializeBean.get(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (UserInfo == null || CommonUtils.isEmptyString(UserInfo.getAccount())) {
            return null;

        }
        if (!UserInfo.getPassword().equals(password)) {
            return null;
        }
        if (UserInfo.getState() != 0) {
            return null;
        }
        return UserInfo;

    }
}
