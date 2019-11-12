package com.ATT.dao.RestManager;

import com.ATT.bean.RestManagerBean;
import common.util.Connet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestUpdateDao {
    public static int Update(RestManagerBean Bean){
        Connection connection = Connet.Conncet();
        int update = -1;
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement("update T_REST_RECORD set REST_START_DATE = ?,START_TIME = ?,REST_END_DATE = ?,END_TIME = ?,REST_TIME= ?,REST_CAUSE = ?where REST_ID = ?");
            pstmt.setString(1,Bean.getStart_date());
            pstmt.setString(2,Bean.getStart_time());
            pstmt.setString(3,Bean.getEnd_date());
            pstmt.setString(4,Bean.getEnd_time());
            pstmt.setString(5,Bean.getRest_time());
            pstmt.setString(6,Bean.getRest_cause());
            pstmt.setInt(7,Bean.getRest_id());
            update = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  update;
    }
}
