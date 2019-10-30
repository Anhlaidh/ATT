package com.ATT.dao;

import com.ATT.bean.DepartmentBean;
import com.ATT.bean.UserInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class initializeDepartment {
    public static void main(String[] args) {
//        get("")
    }
    public static LinkedList get(String name) throws SQLException{

        LinkedList list = new LinkedList();
        ResultSet query = Search.Search(name, "SCOTT.T_DEPARTMENT");
        while (query.next()){
            DepartmentBean departmentBean = new DepartmentBean();
            departmentBean.setDepartmentId(query.getString("DEPARTMENT_ID"));
            departmentBean.setDepartmentName(query.getString("DEPARTMENT_NAME"));
            departmentBean.setName(query.getString("MANAGER"));
            departmentBean.setTotalUser(query.getInt("TOTAL_USER")+"");
            departmentBean.setCreateTime(query.getString("CREATE_TIME"));
            list.add(departmentBean);

        }
        query.close();
        Search.Search(name,"SCOTT.T_DEPARTMENT").close();
        return list;
    }
}
