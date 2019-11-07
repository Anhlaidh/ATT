package com.ATT.dao;

import com.ATT.bean.ReportBean;
import com.ATT.bean.UserInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class initializeReport {
    public static LinkedList get(String name, String startdate, String enddate) throws SQLException {
        LinkedList list = new LinkedList();
        ResultSet query = ReportSearch.R_Search(name, startdate, enddate);
        while (query.next()) {
            ReportBean reportBean = new ReportBean();
            reportBean.setReport_id(query.getInt("REPORT_ID"));
            reportBean.setAccount(query.getString("ACCOUNT"));
            reportBean.setName(query.getString("NAME"));
            reportBean.setReport_date(query.getString("REPORT_DATE"));
            reportBean.setWork_process(query.getString("WORK_PROCESS") );
            reportBean.setWork_content(query.getString("WORK_CONTENT") );
            reportBean.setProblem(query.getString("PROBLEM"));
            reportBean.setOther(query.getString("OTHER"));
            list.add(reportBean);
        }
        query.close();
        ReportSearch.R_Search(name,startdate,enddate).close();
        return list;
    }
}
