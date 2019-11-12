package com.ATT.dao.impl;

import com.ATT.bean.WorkRecordBean;

import java.sql.*;
import java.util.List;

public class WorksyouninnDaoImpl {
    private final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private final String USERNAME = "scott";
    private final String PASSWORD = "tiger";


    public void updateWork() {//根据加班申请编号，如通过审批，则修改审批状态为1，如驳回，则修改审批状态为2
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "insert into STUDENT values (?,?,?,?)";
            pstmt = connection.prepareStatement(sql);
            int count = pstmt.executeUpdate();
            rs = pstmt.executeQuery();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void getComponentPageList(){//加班申请一览查询
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "select * from T_WORK_RECORD  ";
            pstmt = connection.prepareStatement(sql);
            //int count = pstmt.executeUpdate();
            rs = pstmt.executeQuery();
            while (rs.next()){
                String s1=rs.getString("RECORD_ID");
                String s2=rs.getString("ACCOUNT");
                String s3=rs.getString("WORK_DATE");
                String s4=rs.getString("START_TIME");
                String s5=rs.getString("END_TIME");
                String s6=rs.getString("WORK_TIME");
                String s7=rs.getString("WORK_CAUSE");
                String s8=rs.getString("BEIKAO");
                String s9=rs.getString("STATE");

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public  WorkRecordBean querybyname(String sname){//根据姓名查信息
        WorkRecordBean workRecordBean=null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "select * from T_WORK_RECORD  where RECORD_ID =?";
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1,sname);
            rs = pstmt.executeQuery();
            if (rs.next()){
                String s1=rs.getString("RECORD_ID");
                String s2=rs.getString("ACCOUNT");
                String s3=rs.getString("WORK_DATE");
                String s4=rs.getString("START_TIME");
                String s5=rs.getString("END_TIME");
                String s6=rs.getString("WORK_TIME");
                String s7=rs.getString("WORK_CAUSE");
                String s8=rs.getString("BEIKAO");
                String s9=rs.getString("STATE");
                workRecordBean=new WorkRecordBean();
            }
            return  workRecordBean;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return  null;
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }



    /*public static void main(String[] args) {

    }*/
}
