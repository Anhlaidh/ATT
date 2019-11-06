/*
package com.ATT.dao.impl;

import com.ATT.bean.WorkRecordBean;

import java.sql.*;

public class WorkDaoImpl {
    private final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private final String UNAME = "SCOTT";
    private final String PWD = "tiger";

    public void getComponentPageList() {
        WorkRecordBean workRecordBean = null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(URL, UNAME, PWD);
            String sql = "select * from T_WORK_RECORD";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String account = rs.getString("ACCOUNT");
                String work_date = rs.getString("WORK_DATE");
                String start_time = rs.getString("START_TIME");
                String end_time = rs.getString("END_TIME");
                String work_time = rs.getString("WORK_TIME");
                String work_cause = rs.getString("WORK_CAUSE");
                int state = rs.getInt("STATEs");
                workRecordBean = new WorkRecordBean(account, work_date, start_time, end_time, work_time, work_cause, state);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
}
*/
