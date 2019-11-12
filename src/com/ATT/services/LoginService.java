package com.ATT.services;

import com.ATT.bean.UserInfo;
import com.ATT.dao.initUserInfo;
import com.ATT.dao.initializeList;
import common.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class LoginService {
    UserInfo UserInfo = new UserInfo();
    public Boolean login(String account ,String password) throws SQLException {
        String sql = "select count(*) from  T_USER_INFO where ACCOUNT=? and PASSWORD=?";
        Object[] param = {account,password};
        ResultSet query = DBUtil.Query(sql, param);
        int check = -1;
        if (query.next()){
            check = query.getInt(1);
        }


        if (check>0){
            return true;
        }

        else return false;

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
