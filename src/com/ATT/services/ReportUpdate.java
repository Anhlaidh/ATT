package com.ATT.services;

import com.ATT.bean.ReportBean;

public class ReportUpdate {
    public static int ReportUpdate(int report_id,String name,String report_date,String work_process,String work_content,String tomorrow_plan,String problem,String other){
        ReportBean reportBean = new ReportBean();
        reportBean.setReport_id(report_id);
        reportBean.setName(name);
        reportBean.setReport_date(report_date);
        reportBean.setWork_process(work_process);
        reportBean.setWork_content(work_content);
        reportBean.setTomorrow_plan(tomorrow_plan);
        reportBean.setProblem(problem);
        reportBean.setOther(other);
        int i = updateReport.updateReport(reportBean);
        return i;
}
}
