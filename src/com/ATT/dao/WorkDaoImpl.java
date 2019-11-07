package com.ATT.dao;

import com.ATT.bean.WorkRecordBean;

import java.sql.*;
import java.util.Date;
import java.util.LinkedList;

public class WorkDaoImpl {
    private static String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private static String UNAME = "SCOTT";
    private static String PWD = "tiger";
    public static LinkedList getComponentPageList(Date fromCount, Date endCount, int choice) throws ClassNotFoundException, SQLException {
        LinkedList list=null;
        Connection connection=null;
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql;



        Class.forName("oracle.jdbc.OracleDriver");
        connection = DriverManager.getConnection(URL, UNAME, PWD);
        if(choice!=null){
             sql="";
        }else{
            sql="";
        }

        preparedStatement=connection.prepareStatement(sql);
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            WorkRecordBean workRecordBean =new WorkRecordBean();
            workRecordBean.setRecord_id(resultSet.getString("RECORD_ID"));
            workRecordBean.setAccount(resultSet.getString("ACCOUNT"));
            workRecordBean.setName(resultSet.getString("NAME"));
            workRecordBean.setWork_date(resultSet.getString("WORK_DATE"));
            workRecordBean.setStart_time(resultSet.getString("START_TIME"));
            workRecordBean.setEnd_time(resultSet.getInt("END_TIME")+"");
            workRecordBean.setWork_time(resultSet.getString("WORK_TIME"));
            list.add(workRecordBean);

        }
        resultSet.close();
        return list;







    }



}
