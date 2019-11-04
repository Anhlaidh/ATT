package com.ATT.dao;

import com.ATT.bean.DepartmentBean;
import com.ATT.bean.UserInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class initializeDepartment {
    public static void main(String[] args) throws SQLException {
        LinkedList list = get("ALL");
        for (int i =0;i<list.size();i++){
            DepartmentBean departmentBean;
            departmentBean = (DepartmentBean) list.get(i);
            System.out.println(departmentBean.getDepartmentId());
        }

    }
    public static LinkedList get(String name) throws SQLException{

        LinkedList list = new LinkedList();

        ResultSet query = Search.Search(name, "T_DEPARTMENT");
        while (query.next()){
            DepartmentBean departmentBean= new DepartmentBean();
            departmentBean.setDepartmentId(query.getString("DEPARTMENT_ID"));
            departmentBean.setDepartmentName(query.getString("DEPARTMENT_NAME"));
            departmentBean.setName(query.getString("MANAGER"));
            departmentBean.setTotalUser(query.getInt("TOTAL_USER")+"");
            departmentBean.setCreateTime(query.getString("CREATE_TIME"));
            list.add(departmentBean);

        }
        query.close();

        return list;
    }
}
