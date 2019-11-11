package com.ATT.dao;

import com.ATT.bean.DepartmentBean;
import com.ATT.bean.UserInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class initDepartment {
    public static void main(String[] args) throws SQLException {

        DepartmentBean departmentBean = InitDepartment("张东");
        System.out.println(departmentBean.getDepartmentName());

    }
    public static DepartmentBean InitDepartment(String name) throws SQLException{
        ResultSet query= Search.Search(name,"T_DEPARTMENT");
        DepartmentBean departmentBean= new DepartmentBean();
        while (query.next()){

            departmentBean.setDepartmentId(query.getString("DEPARTMENT_ID"));
            departmentBean.setDepartmentName(query.getString("DEPARTMENT_NAME"));
            departmentBean.setName(query.getString("MANAGER"));
            departmentBean.setTotalUser(query.getInt("TOTAL_USER")+"");
            departmentBean.setCreateTime(query.getString("CREATE_TIME"));


        }
        query.close();

        return departmentBean;
    }
    public static DepartmentBean UserDep(String id) throws SQLException {
        ResultSet query= Search.Search(id,"User_Department");
        DepartmentBean departmentBean= new DepartmentBean();
        while (query.next()){


            departmentBean.setDepartmentName(query.getString("DEPARTMENT_NAME"));
            departmentBean.setName(query.getString("MANAGER"));
            departmentBean.setTotalUser(query.getInt("TOTAL_USER")+"");
            departmentBean.setCreateTime(query.getString("CREATE_TIME"));


        }
        query.close();

        return departmentBean;

    }
}
