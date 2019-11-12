package com.ATT.dao;

import com.ATT.bean.UserInfoBean;

import java.sql.*;

public class UserDao {
    static final String URL="jdbc:oracle:thin:@localhost:1521:ORCL";
    static final String USERNAME="scott";
    static final String PASSWORD="tiger";
    public static int updateUser(UserInfoBean userInfoBean){
        Connection connection=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String sql="update T_USER_INFO set ACCOUNT=? , PASSWORD=? , NAME=? , SEX=? , MOBILE=? , BIRTHDAY=? , EMAIL=? where ACCOUNT=?";
            pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,userInfoBean.getAccount());
            pstmt.setString(2,userInfoBean.getPassword());
            pstmt.setString(3,userInfoBean.getName());
            pstmt.setString(4,userInfoBean.getSex());
            pstmt.setString(5,userInfoBean.getMobile());
            pstmt.setString(6,userInfoBean.getBirthday());
            pstmt.setString(7,userInfoBean.getEmail());
            pstmt.setString(8,userInfoBean.getAccount());
            int count=pstmt.executeUpdate();
            rs=pstmt.executeQuery();
            if (count>0)
                return 1;
            else
                return -1;

        }catch (ClassNotFoundException e){
            e.printStackTrace();
            return -1;
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static int updateUser2(UserInfoBean userInfoBean1) {
        Connection connection = null;
        PreparedStatement pstmt=null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "update T_DEPARTMENT set DEPARTMENT_NAME=? where T_DEPARTMENT.DEPARTMENT_ID='yanfa1'";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, userInfoBean1.getDepartment_name());
            int count = pstmt.executeUpdate();
            rs = pstmt.executeQuery();
            if (count > 0)
                return 1;
            else
                return -1;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
