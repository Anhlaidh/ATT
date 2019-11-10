package com.ATT.dao.Report;

import com.ATT.bean.ReportBean;
import common.util.Connet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportUpdateDao {
    public static int Update(ReportBean Bean){
        Connection connection = Connet.Conncet();
        int update = -1;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        ResultSet resultSet1 = null;
        String account = null;
        try {
            pstmt1 = connection.prepareStatement("select * from T_USER_INFO where NAME = ?");
            pstmt1.setString(1,Bean.getName());
            resultSet1 = pstmt1.executeQuery();
            while (resultSet1.next()) {
                account = resultSet1.getString("ACCOUNT");
            }
            pstmt2 = connection.prepareStatement("update T_REPORT_RECORD set T_REPORT_RECORD.ACCOUNT = ?,REPORT_DATE = ?,WORK_PROCESS = ?,WORK_CONTENT = ?,TOMORROW_PLAN = ?,PROBLEM = ?,OTHER = ? where REPORT_ID = ?");
            pstmt2.setString(1,account);
            pstmt2.setString(2,Bean.getReport_date());
            pstmt2.setString(3,Bean.getWork_process());
            pstmt2.setString(4,Bean.getWork_content());
            pstmt2.setString(5,Bean.getTomorrow_plan());
            pstmt2.setString(6,Bean.getProblem());
            pstmt2.setString(7,Bean.getOther());
            pstmt2.setInt(8,Bean.getReport_id());
            update = pstmt2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  update;
    }
}
