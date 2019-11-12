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


    public static ResultSet Search(String key,String table){
        Connection connection = Connet.Conncet();
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
            else if (table.equals("T_WORK_RECORD")){
                if (!key.equals("ALL")){
                    preparedStatement = connection.prepareStatement("select * from   T_WORK_RECORD where NAME = ?");

                    preparedStatement.setString(1,key);

                }else

                    preparedStatement=connection.prepareStatement("select * from T_WORK_RECORD");

            }



            assert preparedStatement != null;
            resultSet = preparedStatement.executeQuery();



        } catch (SQLException e) {
            System.out.println("prepareStatementError");
            e.printStackTrace();
        }

        return resultSet;

    }


    public static ResultSet SearchAll(){
        Connection connection = Connet.Conncet();
        ResultSet resultSet=null;
        try {
            PreparedStatement preparedStatement=null;
            String sql="select * from T_WORK_RECORD";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
        }catch (SQLException e){
            System.out.println("prepareStatementError");
            e.printStackTrace();
        }
        return resultSet;
    }
}
