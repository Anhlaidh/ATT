package com.ATT.dao.RestManager;

import com.ATT.bean.RestManagerBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class initializeRest {
    public static LinkedList get(String start_date,String end_date,int state) throws SQLException {
        LinkedList list = new LinkedList();
        //调用查询返回result
        ResultSet query = RestSearch.RestSearch(start_date,end_date,state);
        //遍历结果集并封装进list中
        while(query.next()){
            RestManagerBean restManagerBean = new RestManagerBean();
            restManagerBean.setRest_id(query.getInt("REST_ID"));
            restManagerBean.setName(query.getString("NAME"));
            restManagerBean.setAccount(query.getString("ACCOUNT"));
            restManagerBean.setStart_date(query.getString("REST_START_DATE"));
            restManagerBean.setStart_time(query.getString("START_TIME"));
            restManagerBean.setEnd_date(query.getString("REST_END_DATE"));
            restManagerBean.setEnd_time(query.getString("END_TIME"));
            restManagerBean.setRest_time(query.getString("REST_TIME"));
            restManagerBean.setRest_cause(query.getString("REST_CAUSE"));
            restManagerBean.setBeikao(query.getString("BEIKAO"));
            //后台int转前台状态
            if(query.getInt("REST_STATE") == 0){
                restManagerBean.setShenpi("审批中");
            }else if(query.getInt("REST_STATE") == 1){
                restManagerBean.setShenpi("已批准");
            }else{
                restManagerBean.setShenpi("已驳回");
            }
            list.add(restManagerBean);

        }
        return list;
    }
}
