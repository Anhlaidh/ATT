package com.ATT.dao;

import com.ATT.bean.DepartmentBean;
import com.ATT.bean.UserInfo;
import com.ATT.dao.Search;
import common.util.Connet;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class initializeList {



    public static LinkedList get(String key,String type) throws SQLException {

        ResultSet Query = null;

        LinkedList list=new LinkedList();

       if (type.equals("UserInfo")){
           Query = Search.Search(key, "T_USER_INFO");

           while (Query.next()){
               UserInfo UserInfo = initUserInfo.initUserInfo(Query.getString("ACCOUNT"));
               list.add(UserInfo);

           }
       }
       if (type.equals("DepartmentBean")){
           Query = Search.Search(key, "T_DEPARTMENT");
           while (Query.next()){
               DepartmentBean departmentBean = initDepartment.InitDepartment(Query.getString("DEPARTMENT_NAME"));

               list.add(departmentBean);

           }

       }

       Query.close();

       return list;

    }
}
