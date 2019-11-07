package com.ATT.dao;

import com.ATT.bean.ReportBean;
import common.util.Connet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportInsert {
    public static int Insert(ReportBean Bean){
        Connection connection = Connet.Conncet();
        int insert = -1;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;
        ResultSet resultSet1 = null;
        ResultSet resultSet2 = null;
        String account = null;
        int report_id =0;
        try {
            pstmt1 = connection.prepareStatement("select * from T_USER_INFO where NAME = ?");
            pstmt1.setString(1,Bean.getName());
            resultSet1 = pstmt1.executeQuery();
            while (resultSet1.next()) {
                account = resultSet1.getString("ACCOUNT");
            }
            pstmt2 = connection.prepareStatement("select max(REPORT_ID) from T_REPORT_RECORD");
            resultSet2 =pstmt2.executeQuery();
            while (resultSet2.next()){
                report_id = resultSet2.getInt(1);
            }
            pstmt3 = connection.prepareStatement("INSERT INTO T_REPORT_RECORD(report_id, account, report_date, work_process, work_content, tomorrow_plan, problem, other) values (?,?,?,?,?,?,?,?)");
            pstmt3.setInt(1,report_id+1);
            pstmt3.setString(2,account);
            pstmt3.setString(3,Bean.getReport_date());
            pstmt3.setString(4,Bean.getWork_process());
            pstmt3.setString(5,Bean.getWork_content());
            pstmt3.setString(6,Bean.getTomorrow_plan());
            pstmt3.setString(7,Bean.getProblem());
            pstmt3.setString(8,Bean.getOther());
            insert = pstmt3.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insert;

    }
}
