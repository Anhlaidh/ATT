package com.ATT.dao;

import common.util.Connet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkManagerSearch {
    public static ResultSet WM_Search(String start_date,String end_date,int choice){
        Connection connection= Connet.Conncet();
        ResultSet resultSet=null;
        try{
            PreparedStatement preparedStatement;
            if(!start_date.equals("ALL")) {
                preparedStatement = connection.prepareStatement("select * from T_USER_INFO , T_WORK_RECORD where T_WORK_RECORD.STATE=? and T_USER_INFO.ID = T_WORK_RECORD.ACCOUNT and to_date(T_WORK_RECORD.WORK_DATE,'YYYY-MM-DD') between to_date(?,'yyyy-mm-dd') and to_date(?,'yyyy-mm-dd')");
                preparedStatement.setInt(1,choice);
                preparedStatement.setString(2, start_date);
                preparedStatement.setString(3, end_date);
            }else{
                preparedStatement = connection.prepareStatement("select * from T_USER_INFO , T_WORK_RECORD where T_USER_INFO.ID = T_WORK_RECORD.ACCOUNT");

            }
            resultSet=preparedStatement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }
}
