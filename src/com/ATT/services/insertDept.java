package com.ATT.services;

import com.ATT.bean.DepartmentBean;
import com.ATT.dao.Insert;

public class insertDept {
    public static int insertDept(DepartmentBean departmentBean){
        int insertDept = Insert.Insert(departmentBean, "insertDept");
        return insertDept;
    }
}
