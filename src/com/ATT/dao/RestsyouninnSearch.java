package com.ATT.dao;

import common.util.Connet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestsyouninnSearch {
    public static ResultSet Search(String name, String startdate, String enddate){
        Connection connection= Connet.Conncet();
        ResultSet resultSet=null;
        try {
            PreparedStatement pstmt=null;
            if (!name.equals("ALL")){
                String sql="select * from T_USER_INFO,T_REST_RECORD where NAME=? and T_USER_INFO.ACCOUNT=T_REST_RECORD.ACCOUNT and to_date(T_REST_RECORD.REST_START_DATE,'YYYY-MM-DD') between to_date(?,'yyyy-mm-dd') and to_date(?,'yyyy-mm-dd')";
                pstmt=connection.prepareStatement(sql);
                pstmt.setString(1,name);
                pstmt.setString(2,startdate);
                pstmt.setString(3,enddate);
            }else {
                pstmt=connection.prepareStatement("select * from T_REST_RECORD,T_USER_INFO where T_USER_INFO.ACCOUNT=T_REST_RECORD.ACCOUNT");
            }
            resultSet=pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  resultSet;
    }
}
