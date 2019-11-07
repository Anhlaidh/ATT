package com.ATT.services;

import com.ATT.bean.ReportBean;
import com.ATT.dao.ReportInsert;

public class insertReport {
    public static int insertReport(ReportBean reportBean){
        int i = ReportInsert.Insert(reportBean);
        return i;

    }
}
