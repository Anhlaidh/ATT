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
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
             return bool;

        }
}
