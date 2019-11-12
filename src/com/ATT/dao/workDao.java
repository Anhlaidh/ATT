package com.ATT.dao;

import com.ATT.bean.WorkRecordBean;
import common.util.Connet;

import java.sql.*;

public class workDao {
    public static int insertWorkRecord(WorkRecordBean workRecordBean){
        Connection connection = Connet.Conncet();
        int insert = -1;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        ResultSet resultSet1 = null;
        int record_id =0;
        try{
            pstmt1 = connection.prepareStatement("select max(RECORD_ID) from T_WORK_RECORD");
            resultSet1 =pstmt1.executeQuery();
            while (resultSet1.next()){
                record_id = resultSet1.getInt(1);
            }
            pstmt2 = connection.prepareStatement("INSERT INTO T_WORK_RECORD(RECORD_ID, ACCOUNT, WORK_DATE, START_TIME, END_TIME, WORK_TIME, WORK_CAUSE, STATE) values (?,?,?,?,?,?,?,?)");
            pstmt2.setInt(1,record_id+1);
            pstmt2.setString(2,workRecordBean.getAccount());
            pstmt2.setString(3,workRecordBean.getWork_date());
            pstmt2.setString(4,workRecordBean.getStart_time());
            pstmt2.setString(5,workRecordBean.getEnd_time());
            pstmt2.setString(6,workRecordBean.getWork_time());
            pstmt2.setString(7,workRecordBean.getWork_time());
            pstmt2.setInt(8,0);
            insert = pstmt2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insert;



    }
    /*public WorkRecordBean getWorkDetail(String record_id){
        WorkRecordBean workRecordBean =null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(URL, UNAME, PWD);
            String sql = "select  ACCOUNT,WORK_DATE,START_TIME=?,START_TIME=?,END_TIME=?,WORK_CAUSE=?,BEIKAO=?from SCOTT.T_WORK_RECORD where RECORD_ID=?";
            pstmt = connection.prepareStatement(sql);
            if(rs.next()){
                String account =rs.getString("ACCOUNT");
                S


            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();

            }
        }


    }*/




}
