package com.ATT.bean;

public class RestManagerBean {
    private int rest_id;
    private String account;
    private String start_date;

    public int getRest_id() {
        return rest_id;
    }

    public void setRest_id(int rest_id) {
        this.rest_id = rest_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getRest_time() {
        return rest_time;
    }

    public void setRest_time(String rest_time) {
        this.rest_time = rest_time;
    }

    public String getRest_cause() {
        return rest_cause;
    }

    public void setRest_cause(String rest_cause) {
        this.rest_cause = rest_cause;
    }

    public String getBeikao() {
        return beikao;
    }

    public void setBeikao(String beikao) {
        this.beikao = beikao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private String start_time;
    private String end_date;
    private String end_time;
    private String rest_time;
    private String rest_cause;
    private String beikao;
    private String name;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    private int state;

    public String getShenpi() {
        return shenpi;
    }

    public void setShenpi(String shenpi) {
        this.shenpi = shenpi;
    }

    private String shenpi;
}
