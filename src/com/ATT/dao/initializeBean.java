package com.ATT.dao;

import com.ATT.bean.UserInfo;
import com.ATT.dao.Search;
import common.util.Connet;
import org.jetbrains.annotations.NotNull;


import java.sql.ResultSet;
import java.sql.SQLException;

public class initializeBean {


    @NotNull
    public static UserInfo get(String Account) throws SQLException {

        UserInfo UserInfo = new UserInfo();
        ResultSet Query = Search.Search(Account);
       while (Query.next()){
           UserInfo.setName(Query.getString("NAME"));
           UserInfo.setId(Integer.parseInt(Query.getString("ID")));
           UserInfo.setAccount(Query.getString("ACCOUNT"));
           UserInfo.setPassword(Query.getString("PASSWORD"));
           UserInfo.setDepartmentId(Query.getString("DEPARTMENT_ID"));
           UserInfo.setSex(Query.getString("SEX"));
           UserInfo.setBirthday(Query.getString("BIRTHDAY"));
           UserInfo.setMobile(Query.getString("MOBILE"));
           UserInfo.setEmail(Query.getString("EMAIL"));
           UserInfo.setUsertype(Integer.parseInt(Query.getString("USER_TYPE")));
           UserInfo.setLevel(Integer.parseInt(Query.getString("MYLEVEL")));
           UserInfo.setCreate_time(Query.getDate("CREATE_TIME"));
           UserInfo.setState(Integer.parseInt(Query.getString("STATE")));

       }
       UserInfo.getAccount();
       UserInfo.getBirthday();
       return UserInfo;

    }
}
