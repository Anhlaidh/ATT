package com.ATT.dao;

import common.util.Connet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search {


    public static ResultSet Search(String key,String table){
        Connection connection = Connet.Conncet();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = null;
            if (table.equals("T_USER_INFO")) {
                preparedStatement = connection.prepareStatement("select * from T_USER_INFO where ACCOUNT = ?");
            }
//            (table.equals("T_DEPARTMENT")
            else  {
                preparedStatement = connection.prepareStatement("select * from   T_DEPARTMENT where DEPARTMENT_NAME = ?");
            }
            preparedStatement.setString(1,key);

             resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.out.println("prepareStatementError");
            e.printStackTrace();
        }
        return resultSet;

    }
}
