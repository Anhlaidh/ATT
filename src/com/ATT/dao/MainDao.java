package com.ATT.dao;

import common.util.Connet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainDao {
    public static int MainSearch(String account) throws SQLException {
        Connection connection= Connet.Conncet();
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=null;
        int myl=-1;
        try {
            preparedStatement = connection.prepareStatement("select MYLEVEL from T_USER_INFO where ACCOUNT = ?");
            preparedStatement.setString(1,account);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                myl=resultSet.getInt("MYLEVEL");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myl;


    }
}
