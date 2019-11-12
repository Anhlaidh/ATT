package com.ATT.dao.b;

import com.ATT.bean.DepartmentBean;
import common.util.DBUtil;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DeptDaoImpl implements IDeptDao {
    @Override
    public  void addDept(DepartmentBean dept) throws SQLException {
        String sql = "INSERT into T_DEPARTMENT(DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER,CREATE_TIME) values (?,?,?,sysdate)";
        Object[] param = {dept.getDepartmentId(),dept.getDepartmentName(),dept.getName()};
        DBUtil.executeUpdate(sql,param);

    }

    @Override
    public void delDept(DepartmentBean dept) throws SQLException {
        String sql = "delete from T_DEPARTMENT where DEPARTMENT_ID = ?";
        Object[] param = {dept.getDepartmentId()};
        DBUtil.executeUpdate(sql,param);


    }

    public static ResultSet searchDept(String key) throws SQLException {
        String sql = "select * from   T_DEPARTMENT where DEPARTMENT_NAME = ?";
        Object[] param = {key};
        ResultSet query = DBUtil.Query(sql, param);


        return query;
    }

    @Override
    public void updateDept(DepartmentBean dept) throws SQLException {
        String sql = "update T_DEPARTMENT set DEPARTMENT_NAME=? , DEPARTMENT_ID = ?,MANAGER=? where DEPARTMENT_ID=?";
        Object[] param = {dept.getDepartmentName(),dept.getDepartmentId(),dept.getName(),dept.getDepartmentId()};
        DBUtil.executeUpdate(sql,param);


    }


    public static int getTotalCount() {
        String sql = "select count(1) from T_DEPARTMENT";
        return DBUtil.getTotalCount(sql);
    }


    public static LinkedList queryDeptByPage(int currentPage,int pageSize) {
        String sql = "select * from(select ROWNUM r,t.* from(select s.* from T_DEPARTMENT s order by DEPARTMENT_ID asc) t where ROWNUM<=?)where  r>?";
        Object[] params = {currentPage*pageSize,(currentPage-1)*pageSize};
        LinkedList departmentBeans = new LinkedList();
        try {
            ResultSet query = DBUtil.Query(sql, params);
            while (query.next()){
                DepartmentBean departmentBean = new DepartmentBean();

                departmentBean.setDepartmentId(query.getString("DEPARTMENT_ID"));
                departmentBean.setDepartmentName(query.getString("DEPARTMENT_NAME"));
                departmentBean.setName(query.getString("MANAGER"));
                departmentBean.setTotalUser(query.getInt("TOTAL_USER")+"");
                departmentBean.setCreateTime(query.getString("CREATE_TIME"));
                departmentBeans.add(departmentBean);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentBeans;
    }
}
