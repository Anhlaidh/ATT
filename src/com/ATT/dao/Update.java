package com.ATT.dao;

import com.ATT.bean.DepartmentBean;
import com.ATT.bean.WorkRecordBean;
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
            else if (table.equals("T_WORK_RECORD_Y")){
                WorkRecordBean workRecordBean = (WorkRecordBean)bean;
                PreparedStatement preparedStatement = connection.prepareStatement("update T_WORK_RECORD set STATE = 1 where ACCOUNT = ?");
                preparedStatement.setString(1,workRecordBean.getRecord_id());
                executeUpdate = preparedStatement.executeUpdate();

            }
            else if (table.equals("T_WORK_RECORD_N")){
                WorkRecordBean workRecordBean = (WorkRecordBean)bean;
                PreparedStatement preparedStatement = connection.prepareStatement("update T_WORK_RECORD set STATE = 2 where ACCOUNT = ?");
                preparedStatement.setString(1,workRecordBean.getRecord_id());
                executeUpdate = preparedStatement.executeUpdate();

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executeUpdate;

    }
}
