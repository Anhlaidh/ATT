import com.ATT.bean.UserInfo;
import com.ATT.dao.Search;
import common.util.Connet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {
        Connection connection = Connet.Conncet();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from T_USER_INFO where ACCOUNT = ?");
            preparedStatement.setString(1,"1");

//            PreparedStatement preparedStatement = connection.prepareStatement("select * from T_USER_INFO where ACCOUNT = '1'");
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.out.println("prepareStatementError");
            e.printStackTrace();
        }
        UserInfo userInfo = new UserInfo();
        while (resultSet.next()){
            userInfo.setName(resultSet.getString("NAME"));
        }
        System.out.println(userInfo.getName());


    }
}
