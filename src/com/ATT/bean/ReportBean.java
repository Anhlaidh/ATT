package com.ATT.bean;

public class ReportBean {
    private String report_id;
    private String account;
    private String report_date;
    private String work_process;
    private String work_content;
    private String tomorrow_plan;
    public ReportBean() {
    }
    public ReportBean(String name,String account , String report_date) {
        this.account = account;
        this.report_date = report_date;
        this.name = name;
    }

    public String getReport_id() {
        return report_id;
    }

    public void setReport_id(String report_id) {
        this.report_id = report_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getReport_date() {
        return report_date;
    }

    public void setReport_date(String report_date) {
        this.report_date = report_date;
    }

    public String getWork_process() {
        return work_process;
    }

    public void setWork_process(String work_process) {
        this.work_process = work_process;
    }

    public String getWork_content() {
        return work_content;
    }

    public void setWork_content(String work_content) {
        this.work_content = work_content;
    }

    public String getTomorrow_plan() {
        return tomorrow_plan;
    }

    public void setTomorrow_plan(String tomorrow_plan) {
        this.tomorrow_plan = tomorrow_plan;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    private String problem;
    private String other;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
