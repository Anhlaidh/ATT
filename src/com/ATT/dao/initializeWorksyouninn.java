package com.ATT.dao;

import com.ATT.bean.DepartmentBean;
import com.ATT.bean.WorkRecordBean;
import com.ATT.dao.Search;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class initializeWorksyouninn {

    public static LinkedList get(String name,String startdate,String enddate) throws SQLException{
        LinkedList list = new LinkedList();
        ResultSet query = WorksyouninnSearch.Search(name, startdate, enddate);
        while (query.next()){
            WorkRecordBean workRecordBean = new WorkRecordBean();
            workRecordBean.setRecord_id(query.getString("RECORD_ID"));
            workRecordBean.setAccount(query.getString("ACCOUNT"));
            workRecordBean.setWork_date(query.getString("WORK_DATE"));
            workRecordBean.setStart_time(query.getString("START_TIME"));
            workRecordBean.setEnd_time(query.getString("END_TIME"));
            workRecordBean.setWork_cause(query.getString("WORK_CAUSE"));
            workRecordBean.setBeikao(query.getString("beikao"));

            workRecordBean.setState(query.getString("STATE"));
            workRecordBean.setName(query.getString("NAME"));
            list.add(workRecordBean);
        }
        query.close();

        return  list;
    }

 /*   //进入页面，显示所有加班申请信息
    public static LinkedList show() throws SQLException{
        LinkedList list = new LinkedList();
        ResultSet query=Search.SearchAll();
        while (query.next()){
            WorkRecordBean workRecordBean = new WorkRecordBean();
            workRecordBean.setRecord_id(query.getString("RECORD_ID"));
            workRecordBean.setAccount(query.getString("ACCOUNT"));
            workRecordBean.setWork_date(query.getString("WORK_DATE"));
            workRecordBean.setStart_time(query.getString("START_TIME"));
            workRecordBean.setEnd_time(query.getString("END_TIME"));
            workRecordBean.setWork_cause(query.getString("WORK_CAUSE"));
            workRecordBean.setBeikao(query.getString("beikao"));
            workRecordBean.setState(query.getString("STATE"));
            workRecordBean.setName(query.getString("NAME"));
            list.add(workRecordBean);
        }
        query.close();
        return list;
    }*/


}
