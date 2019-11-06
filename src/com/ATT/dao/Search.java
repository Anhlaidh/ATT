package com.ATT.dao;

import common.util.Connet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search {
//    public static void main(String[] args) throws SQLException {
//        ResultSet all = Search("*", "ALL", "T_DEPARTMENT");
//        while (all.next()){
//            System.out.println(all.getString("MANAGER"));
//        }
//    }

   static Connection connection = Connet.Conncet();
    public static ResultSet Search(String key,String table){

        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = null;
            if (table.equals("T_USER_INFO")) {
                if (!key.equals("ALL"))
                {
                    preparedStatement = connection.prepareStatement("select * from T_USER_INFO where ACCOUNT = ?");
//
                    preparedStatement.setString(1,key);
                }else

                preparedStatement=connection.prepareStatement("select * from T_USER_INFO");

            }
//            (table.equals("T_DEPARTMENT")
            else  if (table.equals("T_DEPARTMENT")){
                if (!key.equals("ALL")){
                    preparedStatement = connection.prepareStatement("select * from   T_DEPARTMENT where DEPARTMENT_NAME = ?");

                    preparedStatement.setString(1,key);

                }else

                preparedStatement=connection.prepareStatement("select * from T_DEPARTMENT");


            }
            else if (table.equals("User_Department")){
                if (!key.equals("ALL")){
                    preparedStatement = connection.prepareStatement("select * from   T_DEPARTMENT where MANAGER = ?");

                    preparedStatement.setString(1,key);

                }else

                    preparedStatement=connection.prepareStatement("select * from T_DEPARTMENT");

            }



            assert preparedStatement != null;
            resultSet = preparedStatement.executeQuery();



        } catch (SQLException e) {
            System.out.println("prepareStatementError");
            e.printStackTrace();
        }

        return resultSet;

    }
}
