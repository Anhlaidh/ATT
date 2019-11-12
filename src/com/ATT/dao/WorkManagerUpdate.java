package com.ATT.dao;

import com.ATT.bean.WorkRecordBean;
import common.util.Connet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WorkManagerUpdate {
    public static int Update(WorkRecordBean workRecordBean){
        Connection connection=Connet.Conncet();
        int update=-1;
        PreparedStatement pstmt = null;
        try {
            String sql="update T_WORK_RECORD set WORK_DATE=?,START_TIME=?,END_TIME=?,WORK_TIME=?,WORK_CAUSE=? WHERE RECORD_ID=? ";
            pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,workRecordBean.getWork_date());
            pstmt.setString(2,workRecordBean.getStart_time());
            pstmt.setString(3,workRecordBean.getEnd_time());
            pstmt.setString(4,workRecordBean.getWork_time());
            pstmt.setString(5,workRecordBean.getWork_cause());
            pstmt.setString(6,workRecordBean.getRecord_id());
            update=pstmt.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;


    }
}
