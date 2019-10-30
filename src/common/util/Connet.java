package common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connet {


//    返回数据库连接后的 connection对象

//  public static void main(String[] args) {
//
//
//        System.out.println(Conncet());
//    }

    static private final String URL = "jdbc:oracle:thin:@localhost:1521:ATT";
    static private final String USERNAME="scott";
    static private final String PWD="tiger";
    static Connection connection;
    public static Connection Conncet(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
           connection = DriverManager.getConnection(URL, USERNAME,PWD);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return connection;


    }

    public static void  close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
