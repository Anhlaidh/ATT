package com.ATT.dao;

import common.util.Connet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search {


    public static ResultSet Search(String value,String table){
        Connection connection = Connet.Conncet();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from T_USER_INFO ");
//            preparedStatement.setString(1,table);
//            preparedStatement.setString(2,value);
             resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.out.println("prepareStatementError");
            e.printStackTrace();
        }
        return resultSet;

    }
}
