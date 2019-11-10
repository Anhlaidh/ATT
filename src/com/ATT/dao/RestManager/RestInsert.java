package com.ATT.dao.RestManager;

import com.ATT.bean.RestManagerBean;
import common.util.Connet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestInsert {
    public static int RestInsert(RestManagerBean restManagerBean){
        Connection connection = Connet.Conncet();
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        ResultSet resultSet = null;
        int rest_id = 0;
        int insert = -1;
        try {
            pstmt1 = connection.prepareStatement("select max(REST_ID) from T_REST_RECORD");
            resultSet =pstmt1.executeQuery();
            while (resultSet.next()){
                rest_id = resultSet.getInt(1);
            }
            pstmt2 = connection.prepareStatement("INSERT INTO T_REST_RECORD(REST_ID, ACCOUNT, REST_START_DATE, START_TIME, REST_END_DATE, END_TIME, REST_TIME, REST_CAUSE, BEIKAO, REST_STATE) values (?,?,?,?,?,?,?,?,?,?)");
            pstmt2.setInt(1,rest_id+1);
            pstmt2.setString(2,restManagerBean.getAccount());
            pstmt2.setString(3,restManagerBean.getStart_date());
            pstmt2.setString(4,restManagerBean.getStart_time());
            pstmt2.setString(5,restManagerBean.getEnd_date());
            pstmt2.setString(6,restManagerBean.getEnd_time());
            pstmt2.setString(7,restManagerBean.getRest_time());
            pstmt2.setString(8,restManagerBean.getRest_cause());
            pstmt2.setString(9,restManagerBean.getBeikao());
            pstmt2.setInt(10,0);
            insert = pstmt2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insert;
    }
}
