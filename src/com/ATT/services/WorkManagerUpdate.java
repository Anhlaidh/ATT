package com.ATT.services;

import com.ATT.bean.WorkRecordBean;

public class WorkManagerUpdate {
    public static int Update(String record_id,String work_date,String start_date,String end_date,String work_time,String work_cause){
        WorkRecordBean workRecordBean=new WorkRecordBean();
        workRecordBean.setRecord_id(record_id);
        workRecordBean.setWork_date(work_date);
        workRecordBean.setStart_time(start_date);
        workRecordBean.setEnd_time(end_date);
        workRecordBean.setWork_time(work_time);
        workRecordBean.setWork_cause(work_cause);
        int i = com.ATT.dao.WorkManagerUpdate.Update(workRecordBean);
        return i;

    }

}
