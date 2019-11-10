package com.ATT.services.Report;

import com.ATT.bean.ReportBean;
import com.ATT.dao.Report.ReportInsert;

public class insertReport {
    public static int insertReport(ReportBean reportBean){
        int i = ReportInsert.Insert(reportBean);
        return i;

    }
}
