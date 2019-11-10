package com.ATT.dao;

import common.util.Connet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Delete {
        public static boolean Delete(String key,String table){
            Connection connection = Connet.Conncet();
            PreparedStatement preparedStatement;
            Boolean bool = false;
            try{
                if (table=="T_DEPARTMENT"){
                    preparedStatement= connection.prepareStatement("delete from T_DEPARTMENT where DEPARTMENT_ID = ?");
                    preparedStatement.setString(1,key);
                    bool = preparedStatement.execute() ;
                }else if (table=="T_REPORT_RECORD"){
                    int id = Integer.parseInt(key);
                    preparedStatement = connection.prepareStatement("delete  from T_REPORT_RECORD where REPORT_ID = ?");
                    preparedStatement.setInt(1,id);
                    bool = preparedStatement.execute();
                }else if (table=="T_REST_RECORD"){
                    int id = Integer.parseInt(key);
                    preparedStatement = connection.prepareStatement("delete from T_REST_RECORD where REST_ID = ?");
                    preparedStatement.setInt(1,id);
                    bool = preparedStatement.execute();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
             return bool;

        }
}
