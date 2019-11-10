package com.ATT.services.Rest;

import com.ATT.bean.RestManagerBean;

public class RestInsertService {
    public static int RestInsert(String account,String start_date,String start_time,String end_date,String end_time,String rest_time,String rest_cause,String beikao){
        RestManagerBean restManagerBean = new RestManagerBean();
        restManagerBean.setAccount(account);
        restManagerBean.setStart_date(start_date);
        restManagerBean.setStart_time(start_time);
        restManagerBean.setEnd_date(end_date);
        restManagerBean.setEnd_time(end_time);
        restManagerBean.setRest_time(rest_time);
        restManagerBean.setRest_cause(rest_cause);
        restManagerBean.setBeikao(beikao);
        int i = insertRest.insertRest(restManagerBean);
        return i;
    }
}
