package com.ATT.dao;

import com.ATT.bean.UserInfo;
import com.ATT.dao.Search;
import common.util.Connet;
import org.jetbrains.annotations.NotNull;


import java.sql.ResultSet;
import java.sql.SQLException;

public class initializeBean {
    public static void main(String[] args) throws SQLException {
        ResultSet Query = Search.Search("1", "T_USER_INFO");

        System.out.println(Query.getString("name"));
    }

    @NotNull
    public static UserInfo get(String Account) throws SQLException {

        UserInfo UserInfo = new UserInfo();
        ResultSet Query = Search.Search(Account, "T_USER_INFO");
       while (Query.next()){
           System.out.println(Query.getString("NAME"));
//           UserInfo.setName(Query.getString("3"));
//           System.out.println(Query.getString("NAME"));
//           UserInfo.setId(Integer.parseInt(Query.getString("ID")));
//           UserInfo.setAccount(Query.getString("ACCOUNT"));
//           UserInfo.setPassword(Query.getString("PASSWORD"));
//           UserInfo.setName(Query.getString("NAME"));
//           UserInfo.setDepartmentId(Integer.parseInt(Query.getString("DEPARTMENT_ID")));
//           UserInfo.setSex(Integer.parseInt(Query.getString("SEX")));
//           UserInfo.setBirthday(Query.getString("BIRTHDAY"));
//           UserInfo.setMobile(Query.getString("MOBILE"));
//           UserInfo.setEmail(Query.getString("EMAIL"));
//           UserInfo.setUsertype(Integer.parseInt(Query.getString("USER_TYPE")));
//           UserInfo.setLevel(Integer.parseInt(Query.getString("MYLEVEL")));
//           UserInfo.setCreate_time(Query.getDate("CREATE_TIME"));
//           UserInfo.setState(Integer.parseInt(Query.getString("STATE")));

       }
       return UserInfo;

    }
}
