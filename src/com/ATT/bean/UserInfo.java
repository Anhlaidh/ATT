package com.ATT.bean;

import com.ATT.dao.initDepartment;
import com.ATT.dao.initUserInfo;

import java.sql.SQLException;
import java.util.Date;

public class UserInfo {
  private   long	id;
  private   String	account;
  private   String	password;
  private   String	name;
  private   String	departmentId;
  private   String	sex;
  private   String	birthday;
  private   String	mobile;
  private   String	email;
  private   int	usertype;
  private DepartmentBean departmentBean;


    private String departmentName;

    public String getDepartmentName() {

        return departmentBean.getDepartmentName();
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    private String job;

  private   java.util.Date create_time;

    public String getJob() {
        if (usertype==0)
        return "部门经理";
        if (usertype==1){
            return "系统管理员";
        }
        else return "员工";
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDepartment() {
        String department = departmentBean.getDepartmentName();


        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private   int	level;
  private   int	state;
  private   String department;

    public DepartmentBean getDepartmentBean() {
        return departmentBean;
    }

    public void setDepartmentBean(DepartmentBean departmentBean) {
        this.departmentBean = departmentBean;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        try {
            departmentBean = initDepartment.UserDep(name);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        department = departmentBean.getDepartmentName();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


}
