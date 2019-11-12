package com.ATT.dao.b;

import com.ATT.bean.DepartmentBean;
import com.ATT.bean.UserInfo;
import common.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class UserInfoDaoImpl implements IUserDao {
    @Override
    public void addUser() {

    }

    @Override
    public void delUser() {

    }

    @Override
    public LinkedList<UserInfo> searchUser() {
        return null;
    }

    @Override
    public void updateUser() {

    }
    public static int getTotalCount() {
        String sql = "select count(1) from T_USER_INFO";
        return DBUtil.getTotalCount(sql);
    }
    public static LinkedList queryUserByPage(int currentPage,int pageSize) {
        String sql = "select * from(select ROWNUM r,t.* from(select s.* from T_USER_INFO s order by ID asc) t where ROWNUM<=?)where  r>?";
        Object[] params = {currentPage*pageSize,(currentPage-1)*pageSize};
        LinkedList userbeans = new LinkedList();
        try {
            ResultSet Query = DBUtil.Query(sql, params);
            while (Query.next()){
                UserInfo UserInfo = new UserInfo();
                UserInfo.setName(Query.getString("NAME"));
                UserInfo.setId(Integer.parseInt(Query.getString("ID")));
                UserInfo.setAccount(Query.getString("ACCOUNT"));
                UserInfo.setPassword(Query.getString("PASSWORD"));
                UserInfo.setDepartmentId(Query.getString("DEPARTMENT_ID"));
                UserInfo.setSex(Query.getString("SEX"));
                UserInfo.setBirthday(Query.getString("BIRTHDAY"));
                UserInfo.setMobile(Query.getString("MOBILE"));
                UserInfo.setEmail(Query.getString("EMAIL"));
                UserInfo.setUsertype(Integer.parseInt(Query.getString("USER_TYPE")));
                UserInfo.setLevel(Integer.parseInt(Query.getString("MYLEVEL")));
                UserInfo.setCreate_time(Query.getDate("CREATE_TIME"));
                UserInfo.setState(Integer.parseInt(Query.getString("STATE")));
                UserInfo.setDepartmentName(UserInfo.getDepartmentBean().getDepartmentName());
                userbeans.add(UserInfo);




            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userbeans;
    }
}
