package com.ATT.dao;

import com.ATT.bean.WorkRecordBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class initializeWorkManager {
    public static LinkedList get(String start_date, String end_date, int choice) throws SQLException {
        LinkedList list = new LinkedList();
        ResultSet resultSet = WorkManagerSearch.WM_Search(start_date, end_date, choice);
        while (resultSet.next()) {
            WorkRecordBean workRecordBean = new WorkRecordBean();
            workRecordBean.setRecord_id(resultSet.getString("RECORD_ID"));
            workRecordBean.setAccount(resultSet.getString("ACCOUNT"));
            workRecordBean.setName(resultSet.getString("NAME"));
            workRecordBean.setWork_date(resultSet.getString("WORK_DATE"));
            workRecordBean.setStart_time(resultSet.getString("START_TIME"));
            workRecordBean.setEnd_time(resultSet.getString("END_TIME"));
            workRecordBean.setWork_time(resultSet.getString("WORK_TIME"));
            workRecordBean.setState(resultSet.getString("STATE"));
            list.add(workRecordBean);


        }
        resultSet.close();
        WorkManagerSearch.WM_Search(start_date, end_date, choice).close();
        return list;


    }
}
