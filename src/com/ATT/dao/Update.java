package com.ATT.dao;

import com.ATT.bean.DepartmentBean;
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executeUpdate;

    }
}
