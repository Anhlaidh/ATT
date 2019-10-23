package common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connet {

    //返回数据库连接后的 connection对象

//    public static void main(String[] args) {
//        Connet c = new Connet();
//
//        System.out.println(c.Conncet());
//    }

    private final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private final String USERNAME="scott";
    private final String PWD="tiger";
    Connection connection;
    public Connection Conncet(){
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
}
