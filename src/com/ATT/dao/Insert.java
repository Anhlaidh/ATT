package com.ATT.dao;

import com.ATT.bean.DepartmentBean;
import com.ATT.bean.UserInfo;
import common.util.Connet;
import org.apache.catalina.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    public static int Insert(Object Bean,String method){
        Connection connection = Connet.Conncet();
        int update = -1;
        if (method.equals("insertDept")) {
          try {
              PreparedStatement preparedStatement = connection.prepareStatement("INSERT into T_DEPARTMENT(DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER,CREATE_TIME) values (?,?,?,sysdate)");
              DepartmentBean bean = (DepartmentBean) Bean;
              preparedStatement.setString(1,bean.getDepartmentId());
              preparedStatement.setString(2,bean.getDepartmentName());
              preparedStatement.setString(3,bean.getName());

              update = preparedStatement.executeUpdate();
          } catch (SQLException e) {
              e.printStackTrace();
          }
        }
        if (method.equals("UserInfo")){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT into T_USER_INFO(ID, PASSWORD, NAME, SEX, BIRTHDAY, MOBILE, EMAIL, USER_TYPE, MYLEVEL, CREATE_TIME, STATE,ACCOUNT,DEPARTMENT_ID) VALUES (?,?,?,?,sysdate,?,?,?,?,sysdate,?,?,?)");

                UserInfo bean = (UserInfo) Bean;
                char sex;
                if (bean.getSex()=="男"){
                    sex=0;
                }
                else sex=1;
                preparedStatement.setString(1,bean.getId()+"");
                preparedStatement.setString(2,bean.getPassword());
                preparedStatement.setString(3,bean.getName());
                preparedStatement.setString(4,sex+"");

                preparedStatement.setString(5,bean.getMobile());
                preparedStatement.setString(6,bean.getEmail());
                preparedStatement.setString(7,"1");
                preparedStatement.setString(8,"1");
                preparedStatement.setString(9,"1");
                preparedStatement.setString(10,bean.getId()+"");
                preparedStatement.setString(11,bean.getDepartmentId()+"");




                update = preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return update;

    }
}
