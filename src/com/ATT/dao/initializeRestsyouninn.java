package com.ATT.dao;

import com.ATT.bean.RestRecordBean;
import com.ATT.bean.WorkRecordBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class initializeRestsyouninn {
    public static LinkedList get(String name, String startdate, String enddate) throws SQLException {
        LinkedList list = new LinkedList();
        ResultSet query = RestsyouninnSearch.Search(name, startdate, enddate);
        while (query.next()){
            RestRecordBean restRecordBean=new RestRecordBean();
            restRecordBean.setRest_id(query.getString("REST_ID"));
            restRecordBean.setAccount(query.getString("ACCOUNT"));
            restRecordBean.setRest_start_date(query.getString("REST_START_DATE"));
            restRecordBean.setStart_time(query.getString("START_TIME"));
            restRecordBean.setRest_end_date(query.getString("REST_END_DATE"));
            restRecordBean.setEnd_time(query.getString("END_TIME"));
            restRecordBean.setRest_time(query.getString("REST_TIME"));
            restRecordBean.setRest_cause(query.getString("REST_CAUSE"));
            restRecordBean.setBeikao(query.getString("BEIKAO"));
            restRecordBean.setState(query.getString("STATE"));
            list.add(restRecordBean);

        }
        query.close();

        return  list;
    }
}
