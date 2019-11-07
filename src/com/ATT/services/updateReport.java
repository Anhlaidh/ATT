package com.ATT.services;

import com.ATT.bean.ReportBean;
import com.ATT.dao.ReportUpdateDao;

public class updateReport {
    public static int updateReport(ReportBean reportBean){
        int i = ReportUpdateDao.Update(reportBean);
        return i;
    }
}
