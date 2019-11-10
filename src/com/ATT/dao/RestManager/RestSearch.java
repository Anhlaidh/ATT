package com.ATT.dao.RestManager;

import common.util.Connet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestSearch {
    public static ResultSet RestSearch(String start_date,String end_date,int state){
        Connection connection = Connet.Conncet();
        ResultSet resultSet = null;

        try {
            PreparedStatement preparedStatement = null;
            //前台查询传参
            if (!start_date.equals("ALL")){
                preparedStatement = connection.prepareStatement("select * from T_REST_RECORD,T_USER_INFO where T_USER_INFO.ACCOUNT = T_REST_RECORD.ACCOUNT and to_date(T_REST_RECORD.REST_START_DATE,'yyyy-mm-dd') = to_date(?,'yyyy-mm-dd') and to_date(T_REST_RECORD.REST_END_DATE,'yyyy-mm-dd') = to_date(?,'yyyy-mm-dd') and T_REST_RECORD.REST_STATE = ?");
                preparedStatement.setString(1,start_date);
                preparedStatement.setString(2,end_date);
                preparedStatement.setInt(3,state);
            }
            //ALL为全部查询
            else{
                preparedStatement = connection.prepareStatement("select * from T_USER_INFO,T_REST_RECORD where T_USER_INFO.ACCOUNT = T_REST_RECORD.ACCOUNT");
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
