package com.ATT.dao;

import com.ATT.bean.DepartmentBean;
import common.util.Connet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    public static int Insert(Object Bean,String method){
        Connection connection = Connet.Conncet();
        int update = -1;
        if (method.equals("insertDept")) {
          try {
              PreparedStatement preparedStatement = connection.prepareStatement("INSERT into T_DEPARTMENT(DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER,CREATE_TIME) values (?,?,?,sysdate);");
              DepartmentBean bean = (DepartmentBean) Bean;
              preparedStatement.setString(1,bean.getDepartmentId());
              preparedStatement.setString(2,bean.getDepartmentName());
              preparedStatement.setString(3,bean.getName());

              update = preparedStatement.executeUpdate();
          } catch (SQLException e) {
              e.printStackTrace();
          }
        }

        return update;

    }
}
