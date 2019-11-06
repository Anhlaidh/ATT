package com.ATT.services;

import com.ATT.bean.WorkRecordBean;
import com.ATT.dao.workDao;

public class workService {
    workDao workDao=new workDao();

    public int insertWorkRecord(WorkRecordBean workRecordBean){
        if (workDao.insertWorkRecord(workRecordBean)==1){
            return 1;

        }else{
            return 0;
        }



    }
}
