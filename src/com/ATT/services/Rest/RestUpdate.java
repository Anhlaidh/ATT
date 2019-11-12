package com.ATT.services.Rest;

import com.ATT.bean.RestManagerBean;
import com.ATT.dao.RestManager.RestUpdateDao;

public class RestUpdate {
    public static int ReportUpdate(int rest_id,String start_date,String start_time,String end_date,String end_time,String rest_time,String rest_cause){
        RestManagerBean restManagerBean = new RestManagerBean();
        restManagerBean.setRest_id(rest_id);
        restManagerBean.setStart_date(start_date);
        restManagerBean.setStart_time(start_time);
        restManagerBean.setEnd_date(end_date);
        restManagerBean.setEnd_time(end_time);
        restManagerBean.setRest_time(rest_time);
        restManagerBean.setRest_cause(rest_cause);
        int i = RestUpdateDao.Update(restManagerBean);
        return i;
    }
}
