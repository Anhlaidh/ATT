package com.ATT.services;

import com.ATT.bean.DepartmentBean;

public class DeptInsert {
    public static String DeptInsert(String id,String name ,String manager){
        DepartmentBean departmentBean = new DepartmentBean();
        departmentBean.setDepartmentId(id);
        departmentBean.setDepartmentName(name);
        departmentBean.setName(manager);
        int i = insertDept.insertDept(departmentBean);
        return "成功插入"+i+"条数据";
    }
}
