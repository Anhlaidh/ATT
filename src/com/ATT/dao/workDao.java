package com.ATT.dao;

import com.ATT.bean.WorkRecordBean;

import java.sql.*;

public class workDao {
    private final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private final String UNAME = "SCOTT";
    private final String PWD = "tiger";

    public int insertWorkRecord(WorkRecordBean workRecordBean) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(URL, UNAME, PWD);
            String sql = "insert into T_WORK_RECORD values(?,?,?,?,?,?,?,?,?) ";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "4");
            pstmt.setString(2, workRecordBean.getAccount());
            pstmt.setString(3, workRecordBean.getWork_date());
            pstmt.setString(4, workRecordBean.getStart_time());
            pstmt.setString(5, workRecordBean.getEnd_time());
            pstmt.setString(6, workRecordBean.getWork_time());
            pstmt.setString(7, workRecordBean.getWork_cause());
            pstmt.setString(8, workRecordBean.getBeikao());
            pstmt.setInt(9, 0);
            int count = pstmt.executeUpdate();
            if (count > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
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


    }
    public WorkRecordBean getWorkDetail(String record_id){
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


    }




}
