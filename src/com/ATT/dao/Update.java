package com.ATT.dao;

import com.ATT.bean.DepartmentBean;
import com.ATT.bean.UserInfo;
import common.util.Connet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public static int Update(String id,Object bean,String table){
        Connection connection = Connet.Conncet();
        int executeUpdate=-1;
        try {
            if (table == "T_DEPARTMENT"){
                DepartmentBean departmentBean = (DepartmentBean)bean;
                PreparedStatement preparedStatement = connection.prepareStatement("update T_DEPARTMENT set DEPARTMENT_NAME=? , DEPARTMENT_ID = ?,MANAGER=? where DEPARTMENT_ID=?");
                preparedStatement.setString(1,departmentBean.getDepartmentName());
                preparedStatement.setString(2,departmentBean.getDepartmentId());
                preparedStatement.setString(3,departmentBean.getName());
                preparedStatement.setString(4,id);
                executeUpdate = preparedStatement.executeUpdate();

            }
            else if (table=="T_USER_INFO"){

                    PreparedStatement preparedStatement =
                            connection.prepareStatement("update T_USER_INFO set ID=?, PASSWORD=?, NAME=?, SEX=?, BIRTHDAY=sysdate, MOBILE=?, EMAIL=?, USER_TYPE=?, MYLEVEL=?, STATE=?,ACCOUNT=?,DEPARTMENT_ID=?" +
                            "where ID=?");
                    UserInfo Bean = (UserInfo) bean;
                    char sex;
                    if (Bean.getSex()=="男"){
                        sex=0;
                    }
                    else sex=1;
                    preparedStatement.setString(1,Bean.getId()+"");
                    preparedStatement.setString(2,Bean.getPassword());
                    preparedStatement.setString(3,Bean.getName());
                    preparedStatement.setString(4,sex+"");

                    preparedStatement.setString(5,Bean.getMobile());
                    preparedStatement.setString(6,Bean.getEmail());
                    preparedStatement.setString(7,"1");
                    preparedStatement.setString(8,"1");
                    preparedStatement.setString(9,"1");
                    preparedStatement.setString(10,Bean.getId()+"");
                    preparedStatement.setString(11,Bean.getDepartmentId()+"");
                    preparedStatement.setString(12,id);






                    executeUpdate = preparedStatement.executeUpdate();


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executeUpdate;

    }
}
