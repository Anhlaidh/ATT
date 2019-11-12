package com.ATT.dao;

import com.ATT.bean.WorkRecordBean;
import common.util.Connet;

import java.sql.*;
import java.util.Date;
import java.util.LinkedList;

public class WorkDaoImpl {
    private static String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private static String UNAME = "SCOTT";
    private static String PWD = "tiger";
    public static ResultSet getComponentPageList(String fromCount, String endCount, String choice) {
        Connection connection= Connet.Conncet();
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=null;
        try{
            if(!choice.equals("ALL")) {
                preparedStatement = connection.prepareStatement("select * from T_USER_INFO , T_WORK_RECORD where T_WORK_RECORD.STATE=? and T_USER_INFO.ACCOUNT = T_WORK_RECORD.ACCOUNT and to_date(T_WORK_RECORD.WORK_DATE,'YYYY-MM-DD') between to_date(?,'yyyy-mm-dd') and to_date(?,'yyyy-mm-dd')");
                preparedStatement.setInt(1, Integer.parseInt("choice"));
                preparedStatement.setString(2, fromCount);
                preparedStatement.setString(3, endCount);
            }else{
                preparedStatement = connection.prepareStatement("select * from T_USER_INFO , T_WORK_RECORD where T_USER_INFO.ACCOUNT = T_WORK_RECORD.ACCOUNT");

            }
            resultSet=preparedStatement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;





    }



}
